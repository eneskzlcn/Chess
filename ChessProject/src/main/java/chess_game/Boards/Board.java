/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Boards;

import chess_game.Pieces.*;
import chess_game.Resources.*;
import chess_game.Utilities.BoardUtilities;
/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Board {

    Tile[][] tiles;

    public Tile getTile(Coordinate coordinate) {
        return getTile(coordinate.getX(), coordinate.getY());
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            System.out.println("Get Tile Index Bound Of Array");
            return null;
        }
        return tiles[x][y];
    }

    public Coordinate getCoordOfGivenTeamPiece(Team team, PieceTypes pieceType) {
        for (int i = 0; i < BOARD_Configurations.ROW_COUNT; i++) {
            for (int j = 0; j < BOARD_Configurations.ROW_TILE_COUNT; j++) {
                if (!tiles[i][j].hasPiece()) {
                    continue;
                }
                if (tiles[i][j].getPiece().getTeam() == team && tiles[i][j].getPiece().getType() == pieceType) {
                    return tiles[i][j].getCoordinate();
                }
            }
        }
        return null;
    }
    public Tile getTileOfGivenTeamPiece(Team team, PieceTypes pieceType) {
        for (int i = 0; i < BOARD_Configurations.ROW_COUNT; i++) {
            for (int j = 0; j < BOARD_Configurations.ROW_TILE_COUNT; j++) {
                if (!tiles[i][j].hasPiece()) {
                    continue;
                }
                if (tiles[i][j].getPiece().getTeam() == team && tiles[i][j].getPiece().getType() == pieceType) {
                    return tiles[i][j];
                }
            }
        }
        return null;
    }
}
