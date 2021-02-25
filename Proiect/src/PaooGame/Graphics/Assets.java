package PaooGame.Graphics;

import PaooGame.Fonts.FontLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc
      public static BufferedImage[] heroUp, heroDown, heroLeft, heroRight,pl2Up, pl2Down, pl2Left, pl2Right;

    public static BufferedImage gameover;
    public static Font font25;
    public static Font font40;

    public static BufferedImage grass;

    public static BufferedImage piatra;

    public static BufferedImage bomb;

    public static BufferedImage cutie;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/bomberman.png"));
        SpriteSheet endGame=new SpriteSheet(ImageLoader.LoadImage("/textures/gameover.png"));
        font25= FontLoader.loadFont("res/fonts/arcade.TTF",25);
        font40= FontLoader.loadFont("res/fonts/arcade.TTF",40);
        heroUp = new BufferedImage[3];
        heroDown = new BufferedImage[3];
        heroLeft = new BufferedImage[3];
        heroRight = new BufferedImage[3];

        pl2Down = new BufferedImage[3];
        pl2Left = new BufferedImage[3];
        pl2Right = new BufferedImage[3];
        pl2Up = new BufferedImage[3];



            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass = sheet.crop(1, 0);
        cutie=sheet.crop(9,0);

        gameover=endGame.crop1(0,0);
        pl2Up[0]=sheet.crop(0,4);
        pl2Up[1]=sheet.crop(8,4);
        pl2Up[2]=sheet.crop(9,4);
        pl2Down[0]=sheet.crop(1,4);
        pl2Down[1]=sheet.crop(2,4);
        pl2Down[2]=sheet.crop(3,4);
        pl2Left[0]=sheet.crop(0,4);
        pl2Left[1]=sheet.crop(8,4);
        pl2Left[2]=sheet.crop(9,4);
        pl2Right[0]=sheet.crop(4,4);
        pl2Right[1]=sheet.crop(5,4);
        pl2Right[2]=sheet.crop(6,4);

        heroUp[0]=sheet.crop(0,1);
       heroUp[1]=sheet.crop(8,1);
       heroUp[2]=sheet.crop(9,1);
       heroDown[0]=sheet.crop(1,1);
       heroDown[1]=sheet.crop(2,1);
       heroDown[2]=sheet.crop(3,1);
        heroLeft[0]=sheet.crop(0,1);
        heroLeft[1]=sheet.crop(8,1);
        heroLeft[2]=sheet.crop(9,1);
       heroRight[0]=sheet.crop(4,1);
        heroRight[1]=sheet.crop(5,1);
        heroRight[2]=sheet.crop(6,1);
        piatra=sheet.crop(10,5);
        bomb=sheet.crop(5, 5);


    }
}
