/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Utilities;

import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import chess_game.Pieces.Move;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class MoveUtilities {

    public static boolean isValidMove(Board board, Tile destinationTile) {
        if (!board.hasChosenTile()) {
            return false;
        }
        for (Move m : board.getChosenTile().getPiece().availableMoves(board, board.getChosenTile().getCoordinate())) {
            if (m.getDestinationTile().getCoordinate().equals(destinationTile.getCoordinate())) {
                return true;
            }
        }
        return false;
    }

}
