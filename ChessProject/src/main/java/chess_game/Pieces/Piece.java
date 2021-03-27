/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.Board;
import chess_game.Move;
import chess_game.Tile;
import java.util.List;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public abstract class Piece {

    private boolean killed = false;
    private Team team;

    public Piece(Team team) {
        this.setTeam(team);
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board,
            Tile start, Tile end);
    
    public abstract List<Move> availableMoves(Board board);
}
