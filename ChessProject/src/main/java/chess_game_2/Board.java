/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game_2;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Board {
    private Tile tiles[][];
    
    public Board()
    {
        this.initializeBoard();
    }
    public void initializeBoard()
    {
        
    }
    public Tile getTile(int x, int y)
    {
        if( x<0 || x > 7 || y < 0 || y > 7)
        {
            System.out.println("Not valid arguments for getTile function");
            System.out.println("Arguments x:"+x+"\ty:"+y);
            return null;
        }
        return tiles[x][y];
    }
    
    public Tile getTileOfKingGivenColor(Color color)
    {
        for(int i = 0;i < Resources.ROW_COUNT;i++)
        {
            for (int j = 0; j < Resources.ROW_TILE_COUNT; j++) {
                if(!tiles[i][j].hasPiece())continue;
                if(tiles[i][j].getPiece().getColor() == color && tiles[i][j].getPiece().getType() == PieceType.KING) return tiles[i][j];
            }
        }
        return null;
    }
}
