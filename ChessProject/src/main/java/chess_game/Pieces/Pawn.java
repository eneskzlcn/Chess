/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

import chess_game.Boards.Board;
import chess_game.Move.Move;
import chess_game.Boards.Tile;
import java.util.ArrayList;
import java.util.List;
import chess_game.Resources.PIECE_Configurations;
import chess_game.Utilities.BoardUtilities;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Pawn extends Piece {

    public Pawn(Team team) {
        super(team, PieceTypes.PAWN);
    }

    @Override
    public List<Move> availableMoves(Board board, Coordinate currentCoord) {
        List<Move> possibleMoves = new ArrayList<Move>();
        Tile currentTile = board.getTile(currentCoord);
        Tile destinationTile;

        //normal available moves calculating. Movement of 1 length on y or -y axis.
        for (Coordinate coord : (Coordinate[]) PIECE_Configurations.PAWN_MOVES.get(this.getTeam()).get("Normal")) {
            if (!BoardUtilities.isValidCoordinate(currentCoord.plus(coord))) {
                continue;
            }
            destinationTile = board.getTile(currentCoord.plus(coord));
            if (!destinationTile.hasPiece()) {
                possibleMoves.add(new Move(board, currentTile, destinationTile));
            }
            //not need to else state. becuse if there is a piece in any team on pawn it cant moves.             
        }
        if (currentTile.getCoordinate().getY() == PIECE_Configurations.getPawnStartPosY(this.getTeam())) {
            for (Coordinate coord : (Coordinate[]) PIECE_Configurations.PAWN_MOVES.get(this.getTeam()).get("Start")) {
                if (!BoardUtilities.isValidCoordinate(currentCoord.plus(coord))) {
                    continue;
                }
                destinationTile = board.getTile(currentCoord.plus(coord));
                if (!destinationTile.hasPiece()) {
                    possibleMoves.add(new Move(board, currentTile, destinationTile));
                }

            }
        }
        for (Coordinate coord : (Coordinate[]) PIECE_Configurations.PAWN_MOVES.get(this.getTeam()).get("Attack")) {

            if (!BoardUtilities.isValidCoordinate(currentCoord.plus(coord))) {
                continue;
            }
            destinationTile = board.getTile(currentCoord.plus(coord));

            if (!destinationTile.hasPiece()) {
                continue;
            } else {
                if (destinationTile.getPiece().getTeam() != this.getTeam()) {
                    possibleMoves.add(new Move(board, currentTile, destinationTile));
                }
            }
        }

        return possibleMoves;
    }

}
