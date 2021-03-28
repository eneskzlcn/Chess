/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Utilities;

import chess_game.Pieces.*;
import chess_game.Resources.BOARD_Configurations;
/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class BoardUtilities {
    
    public static boolean isValidCoordinate(Coordinate coord)
    {
        return ( coord.getX() >= BOARD_Configurations.BOARD_LOWER_BOUND && coord.getX() <= BOARD_Configurations.BOARD_UPPER_BOUND && coord.getY() >= BOARD_Configurations.BOARD_LOWER_BOUND && coord.getY() <= BOARD_Configurations.BOARD_UPPER_BOUND);
    }
}
