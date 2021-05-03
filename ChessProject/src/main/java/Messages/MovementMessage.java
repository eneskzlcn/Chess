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
public class MovementMessage implements java.io.Serializable{
    public boolean isPieceKilled;
    public Coordinate destinationCoordinate;
    public Coordinate currentCoordinate;
}
