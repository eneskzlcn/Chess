/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Player;

import chess_game.Boards.Board;
import chess_game.Pieces.*;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */


public class Player {
    
    private Team team;
    
    public Player(Team team)
    {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    public void makeMove(Board board, Move move)
    {
        board.getTile(move.getDestinationTile().getCoordinate()).setPiece(move.getCurrentTile().getPiece());
        board.getTile(move.getCurrentTile().getCoordinate()).setPiece(null);
        System.out.println(board.getTile(move.getCurrentTile().getCoordinate()).getPiece());
        System.out.println(board.getTile(move.getDestinationTile().getCoordinate()).getPiece());
    }
}
