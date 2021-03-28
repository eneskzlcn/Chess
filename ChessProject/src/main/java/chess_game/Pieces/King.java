/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.*;
import chess_game.Boards.Board;
import chess_game.Pieces.Move;
import chess_game.Boards.Tile;
import java.util.List;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class King extends Piece{
    
    private boolean castlingDone = false;
    
    public boolean isCastlingDone()
    {
            return castlingDone;
    }
    public void setCastlingDone(boolean castlingDone)
    {
       this.castlingDone = castlingDone;
    }
    public King(Team team)
    {
        super(team,PieceTypes.KING);
    }

    @Override
    public List<Move> availableMoves(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}