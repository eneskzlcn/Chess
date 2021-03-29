/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import java.util.ArrayList;
import java.util.List;
import chess_game.Resources.PIECE_Configurations;
import java.util.Set;
import chess_game.Utilities.BoardUtilities;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Bishop extends Piece {

    public Bishop(Team team) {
        super(team, PieceTypes.BISHOP);
    }

    public List<Move> availableMoves(Board board,Coordinate currentCoord) {
        List<Move> possibleMoves = new ArrayList<Move>();
        Coordinate currentCoordinate = board.getCoordOfGivenTeamPiece(this.getTeam(), this.getType());

        Tile destinationTile;
        Coordinate destinationCoordinate = currentCoordinate;
        for (Coordinate coord : PIECE_Configurations.BISHOP_MOVES) {
            do {
                destinationCoordinate.setX(coord.getX() + destinationCoordinate.getX());
                destinationCoordinate.setY(coord.getY() + destinationCoordinate.getY());
                destinationTile = board.getTile(destinationCoordinate);

                if (!board.getTile(destinationCoordinate).hasPiece()) {
                    possibleMoves.add(new Move(board, board.getTileOfGivenTeamPiece(this.getTeam(), this.getType()), destinationTile));
                }
                if (board.getTile(destinationCoordinate).getPiece().getTeam() != this.getTeam()) {
                    possibleMoves.add(new Move(board, board.getTileOfGivenTeamPiece(this.getTeam(), this.getType()), destinationTile));
                    break;
                }
            } while (BoardUtilities.isValidCoordinate(destinationCoordinate));
            destinationCoordinate = currentCoordinate;
        }
        return null;
    }

}
