/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Boards;

import chess_game.Pieces.*;
import chess_game.Resources.*;
import chess_game.Utilities.BoardUtilities;
import javax.swing.JPanel;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Board {

    private final Tile[][] tiles = new Tile[BOARD_Configurations.ROW_COUNT][BOARD_Configurations.ROW_TILE_COUNT];

    public Tile getTile(Coordinate coordinate) {
        return getTile(coordinate.getX(), coordinate.getY());
    }

    public Board() {
        //black
        tiles[0][0] = new Tile(new Coordinate(0,0),new Rook(Team.BLACK));
        tiles[1][0]= new Tile(new Coordinate(1,0),new Knight(Team.BLACK));
        tiles[2][0]= new Tile(new Coordinate(2,0),new Bishop(Team.BLACK));
        tiles[3][0]= new Tile(new Coordinate(3,0),new Queen(Team.BLACK));
        tiles[4][0]= new Tile(new Coordinate(4,0),new King(Team.BLACK));
        tiles[5][0]= new Tile(new Coordinate(5,0),new Bishop(Team.BLACK));
        tiles[6][0]= new Tile(new Coordinate(6,0),new Knight(Team.BLACK));
        tiles[7][0]= new Tile(new Coordinate(7,0),new Rook(Team.BLACK));
        
        for(int i= 0; i< 8; i++)
        {
            tiles[i][1] = new Tile(new Coordinate(i,1),new Pawn(Team.BLACK));
            tiles[i][6] = new Tile(new Coordinate(i,6),new Pawn(Team.WHITE));
        }
        for(int i = 2; i <6; i++)
        {
            for(int j = 0; j <8;j++)
            {
                tiles[j][i] = new Tile(new Coordinate(j,i),null);
            }
        }
        //white
        tiles[0][7] = new Tile(new Coordinate(0,7),new Rook(Team.WHITE));
        tiles[1][7]= new Tile(new Coordinate(1,7),new Knight(Team.WHITE));
        tiles[2][7]= new Tile(new Coordinate(2,7),new Bishop(Team.WHITE));
        tiles[3][7]= new Tile(new Coordinate(3,7),new King(Team.WHITE));
        tiles[4][7]= new Tile(new Coordinate(4,7),new Queen(Team.WHITE));
        tiles[5][7]= new Tile(new Coordinate(5,7),new Bishop(Team.WHITE));
        tiles[6][7]= new Tile(new Coordinate(6,7),new Knight(Team.WHITE));
        tiles[7][7]= new Tile(new Coordinate(7,7),new Rook(Team.WHITE));

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
