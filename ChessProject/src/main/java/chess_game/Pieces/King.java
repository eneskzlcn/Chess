/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.*;
import chess_game.Board;
import chess_game.Move;
import chess_game.Tile;
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
        super(team);
    }
    
    @Override
    public boolean canMove(Board board, Tile start, Tile end) {
         if (end.getPiece().getTeam() == this.getTeam()) {
            return false;
        }
  
        int x = Math.abs(start.getCoordinate().getX()- end.getCoordinate().getX());
        int y = Math.abs(start.getCoordinate().getY() - end.getCoordinate().getY());
        if (x + y == 1) {
            // x+y ==1 is just enough to control can a piece go anywhere with distance 1.
            // The conditions especially for the King like is any enemy will able to attack after move need to be controlled here.
            return true;
        }
  
        return this.isValidCastling(board, start, end);

    }
    private boolean isValidCastling(Board board, Tile start, Tile end)
    {
  
        if (this.isCastlingDone()) {
            return false;
        }
  
        // Will be added conditions for castling that makes castling impossible. If none of them accepted then will return true
        return true;
    }

    @Override
    public List<Move> availableMoves(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}