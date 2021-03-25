/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.Board;
import chess_game.Tile;
import javax.swing.JLabel;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */

public class Knight extends Piece{
    
    public Knight(boolean isWhite)
    {
         super(isWhite);   
    } 

    @Override
    public boolean canMove(Board board, Tile start, Tile end) {
        
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        return true;
    }
}
