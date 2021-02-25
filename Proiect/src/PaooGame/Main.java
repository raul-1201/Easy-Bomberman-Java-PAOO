

package PaooGame;

import PaooGame.GameWindow.GameWindow;
import java.sql.*;
public class Main
{
    public static void main(String[] args)

    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:winners6.db");
            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS 'Winners'; " +
                    "CREATE TABLE Winners" +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " NAME TEXT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
        Game paooGame = new Game("No Violence Bomberman", 960, 480);
        paooGame.StartGame();
    }
}
