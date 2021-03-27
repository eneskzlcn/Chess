/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game;

import chess_game.Pieces.Coordinate;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Board {
    
    Tile[][] tiles;
    
    public Board()
    {
        
    }
    
    public Tile getTile(Coordinate coordinate)
    {
        
        return getTile(coordinate.getX(),coordinate.getY());
    }
    public Tile getTile(int x , int y)
    {
        if( x < 0 ||x > 7 || y <0 || y > 7)
        {
            System.out.println("Get Tile Index Bound Of Array");
            return null;
        }
        return tiles[x][y];
    }
    
}
