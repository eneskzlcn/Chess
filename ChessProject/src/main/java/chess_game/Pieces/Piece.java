/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import java.util.List;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public abstract class Piece {

    private boolean killed = false;
    private Team team;
    private PieceTypes type;
    
    public Piece(Team team,PieceTypes type) {
        this.setTeam(team);
        this.setType(type);
    }

    public PieceTypes getType() {
        return type;
    }

    public void setType(PieceTypes type) {
        this.type = type;
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

    @Override
    public String toString() {
        return this.team.toString()+" "+this.type.toString();
    }
    
    public abstract List<Move> availableMoves(Board board,Coordinate currentCoord);
      
}
