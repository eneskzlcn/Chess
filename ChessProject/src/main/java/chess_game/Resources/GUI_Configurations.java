/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Resources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class GUI_Configurations {

    public static int SCREEN_WIDTH = 600;
    public static int SCREEN_HEIGHT = 700;
    public static int TILE_HEIGHT = 64;
    public static int TILE_WIDTH = 64;
    public static Dimension TILE_DIMENSION = new Dimension(TILE_WIDTH, TILE_HEIGHT);
    public static Dimension OUTER_FRAME_DIMENSION = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    public static Color creamColor = new Color(255, 229, 204);
    public static Color lightCyanColor = new Color(204, 255, 255);
    public static Color greenColor = new Color(51, 255, 51);
    public static int MainMenuAlignment = FlowLayout.CENTER;
    public static int MainMenuHorizantalGAP = SCREEN_WIDTH;
    public static int MainMenuVerticalGAP = 50;
    public static int BottomGameMenuHorizontalGap = 50;
    public static int BottomGameMenuVerticalGap = SCREEN_HEIGHT;
    public static int BottomGameMenuAlignment = FlowLayout.LEADING;

}
