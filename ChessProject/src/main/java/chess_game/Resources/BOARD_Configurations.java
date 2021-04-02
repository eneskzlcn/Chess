/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Resources;

import chess_game.Pieces.PieceTypes;
import chess_game.Pieces.Team;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class BOARD_Configurations {

    public static int ROW_COUNT = 8;
    public static int ROW_TILE_COUNT = 8;
    public static int BOARD_LOWER_BOUND = 0;
    public static int BOARD_UPPER_BOUND = 7;
    public static int TILE_SIZE = 60;
    public static Color creamColor = new Color(255, 229, 204);
    public static Color lightCyanColor = new Color(204, 255, 255);
    public static Color greenColor = new Color(51,255,51);
    
   

}
