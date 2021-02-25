package PaooGame.Items;

import PaooGame.Fonts.Text;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


public class ItemManager {



    public int count;
    private RefLinks reflink;
    private Hero player;
    private Player2 player2;
    private ArrayList<Item> items;

    private Comparator<Item> sorter=new Comparator<Item>() {
        @Override
        public int compare(Item a, Item b) {
            if(a.GetY() + a.GetHeight() < b.GetY() + b.GetHeight())
                return -1;
            return 1;
        }

    };

    public ItemManager(RefLinks reflink, Hero player, Player2 player2){
        this.reflink = reflink;
        this.player = player;
        this.player2=player2;
        items = new ArrayList<Item>();
    }

    public void Update(){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item e = it.next();
            e.Update();
            if(!e.isActive())
                it.remove();
        }

        player.Update();
        player2.Update();
        items.sort(sorter);
    }





    public void addItem(Item e){
        count++;
        items.add(e);


    }
    public void Draw(Graphics g){
        for(Item e : items){
            e.Draw(g);
        }
        player.Draw(g);
        player2.Draw(g);

        if(player.getCount()==5 ) {
            g.drawImage(Assets.gameover,0,0,960,480, null);
            Text.drawString(g,"Player 1 WINS! " ,500,360,false, Color.YELLOW, Assets.font40);
            Text.drawString(g,"Press Close Tab to Exit " ,500,400,false, Color.YELLOW, Assets.font25);
            String sql = "INSERT INTO Winners (ID,NAME) " +
                   "VALUES (1, 'PLAYER 1');";
        }

        if(player2.getCount()==5) {
            g.drawImage(Assets.gameover,0,0,960,480, null);
            Text.drawString(g,"Player 2 WINS! " ,500,360,false, Color.YELLOW, Assets.font40);
            Text.drawString(g,"Press Close Tab to Exit " ,500,400,false, Color.YELLOW, Assets.font25);
            String sql = "INSERT INTO Winners (ID,NAME) " +
                    "VALUES (1, 'PLAYER 2');";
        }



    }

    //GETTERS SETTERS

    public  RefLinks getReflink() {
        return reflink;
    }

    public void setReflink(RefLinks reflink) {
        this.reflink = reflink;
    }

    public Hero getPlayer() {
        return player;
    }
    public Player2 getPlayer2(){return player2;}

    public void setHero(Hero player) {
        this.player = player;
    }
    public void setPlayer2(Player2 player){
        this.player2=player2;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> entities) {
        this.items = entities;
    }

}