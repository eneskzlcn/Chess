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
import chess_game.Resources.BOARD_Configurations;
import chess_game.Utilities.BoardUtilities;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Knight extends Piece {

    public Knight(Team team) {
        super(team, PieceTypes.KNIGHT);
    }

    @Override
    public List<Move> availableMoves(Board board) {

        List<Move> possibleMoves = new ArrayList<Move>();

        Coordinate currentCoord = board.getCoordOfGivenTeamPiece(this.getTeam(), this.getType());

        Coordinate destinationCoordinate = new Coordinate(0, 0);
        Tile destinationTile;

        for (Coordinate coord : PIECE_Configurations.KNIGHT_MOVES) {
            destinationCoordinate.setX(currentCoord.getX() + coord.getX());
            destinationCoordinate.setY(currentCoord.getY() + coord.getY());

            if (!BoardUtilities.isValidCoordinate(destinationCoordinate)) {
                continue; // chech if the coord outside of board.
            }
            destinationTile = board.getTile(destinationCoordinate);

            if (!destinationTile.hasPiece()) {
                possibleMoves.add(new Move(board,board.getTileOfGivenTeamPiece(this.getTeam(), this.getType()),destinationTile));
            } else {
                if (destinationTile.getPiece().getTeam() != this.getTeam()) {
                    possibleMoves.add(new Move(board,board.getTileOfGivenTeamPiece(this.getTeam(), this.getType()),destinationTile));
                }
            }
        }
        return possibleMoves;
    }
}
