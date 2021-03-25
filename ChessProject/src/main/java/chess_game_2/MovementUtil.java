/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game_2;

import java.util.ArrayList;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class MovementUtil {
    
    public static ArrayList<Tile> availableTilesToMove(Board board, Tile tileOfPieceToMove)
    {
        ArrayList availableTiles = null;
        switch(tileOfPieceToMove.getPiece().getType())
        {
            case QUEEN:
                availableTiles = givenQueenAvailableMoves(board,tileOfPieceToMove);
        }
        
        return availableTiles;
    }
    
    public static ArrayList<Tile> givenQueenAvailableMoves(Board board, Tile currentTile)
    {
            ArrayList availableTiles = null;
            isVerticalMoveAvailable(board, currentTile);
            
            return availableTiles;
    }
    public static boolean isVerticalMoveAvailable(Board board, Tile currentTile)
    {
      for(int y = currentTile.getY()+1;y <8;y++)
      {
          if(board.getTile(currentTile.getX(),y).hasPiece())return false;
          if(board.getTile(currentTile.getX(),y).getPiece().getColor() == currentTile.getPiece().getColor()) return false;
          
      }
      return true;   
    }
    
    public static boolean controlMateState(Board board,Tile currentTile,int newPosX,int newPosY)
    {
        int x_dif = newPosX - currentTile.getX();
        int y_dif = newPosY - currentTile.getY();
        Tile king = board.getTileOfKingGivenColor(currentTile.getPiece().getColor());
        if()
    }
    }
}
