/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import chess_game.Pieces.Coordinate;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */

//This class created for optimizated transformation speed. Because the move class
//has many reference on it and very heavy. Just keeping coordinates and isKilled value
// is enough to understood what rival player moved last round.
public class MovementMessage implements java.io.Serializable{
    public boolean isPieceKilled;
    public Coordinate destinationCoordinate;
    public Coordinate currentCoordinate;
}
