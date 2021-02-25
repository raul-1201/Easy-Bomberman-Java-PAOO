package PaooGame.Items;


import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;


public class Bomb extends StaticItems {

    public int count;

    public Bomb(RefLinks refLink, float x, float y) {

        super(refLink, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 32;
    }

    @Override
    public void Update() {

    }
    @Override
    public void die(){




    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.bomb, (int) x, (int) y, width, height, null);



        }
    }
