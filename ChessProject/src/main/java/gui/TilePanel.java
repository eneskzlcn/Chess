/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import chess_game.Pieces.Coordinate;
import chess_game.Pieces.PieceTypes;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import chess_game.Resources.BOARD_Configurations;
import java.awt.Dimension;
import javax.swing.JLabel;
/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class TilePanel extends JPanel{
    
    Coordinate coordinate;
    public TilePanel(BoardPanel boardPanel,Coordinate coordinate,Board chessBoard)
    {
        super(new GridBagLayout());
        this.coordinate = coordinate;
        setPreferredSize(new Dimension(BOARD_Configurations.TILE_SIZE,BOARD_Configurations.TILE_SIZE));
        assignTileColor();
        assignTilePieceIcon(chessBoard);
        validate();
    }
    private void assignTilePieceIcon(Board board)
    {
        this.removeAll();
        Tile thisTile = board.getTile(this.coordinate);
        if(thisTile == null)return;
        if(thisTile.hasPiece())
        {
            this.add(new JLabel(BOARD_Configurations.getImageOfTeamPiece(thisTile.getPiece().getTeam(), thisTile.getPiece().getType())));
        }
    }
    private void assignTileColor() {
        if(this.coordinate.getX() % 2 == 0 && this.coordinate.getY() % 2 == 0)
        {
            this.setBackground(BOARD_Configurations.creamColor);
        }
        else if(this.coordinate.getX() % 2 == 0 && this.coordinate.getY() % 2 == 1)
        {
            this.setBackground(BOARD_Configurations.lightCyanColor);
        }
        else if (this.coordinate.getX() % 2 == 1 && this.coordinate.getY() % 2 == 0)
        {
            this.setBackground(BOARD_Configurations.lightCyanColor);
        }
        else if (this.coordinate.getX() % 2 == 1 && this.coordinate.getY() % 2 == 1)
        {
            this.setBackground(BOARD_Configurations.creamColor);
        }
    }
  
}
