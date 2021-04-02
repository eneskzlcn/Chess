/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Resources;

import chess_game.Pieces.Coordinate;
import java.util.List;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class PIECE_Configurations {
    
    //this coordinates means a knıght can make 8 different moves in a possible position. Its current position plus this positions shows its possible move coordinates.
    public static Coordinate[] KNIGHT_MOVES = {new Coordinate(2,1),new Coordinate(-2,1),new Coordinate(2,-1),new Coordinate(-2,-1),new Coordinate(1,2),new Coordinate(-1,2),new Coordinate(1,-2),new Coordinate(-1,-2)};
    //this coordinates shows a bishops available move directions from its current position;
    public static Coordinate[] BISHOP_MOVES = {new Coordinate(1,1),new Coordinate(-1,1),new Coordinate(1,-1),new Coordinate(-1,-1)};

}

