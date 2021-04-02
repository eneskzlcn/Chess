/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import chess_game.Pieces.Coordinate;
import chess_game.Pieces.Move;
import chess_game.Pieces.Piece;
import chess_game.Pieces.PieceTypes;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import chess_game.Resources.BOARD_Configurations;
import chess_game.Utilities.BoardUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class TilePanel extends JPanel {

    Coordinate coordinate;
    private boolean isChosen = false;

    public TilePanel(BoardPanel boardPanel, Coordinate coord, Board chessBoard) {
        super(new GridBagLayout());
        this.coordinate = coord;
        setPreferredSize(new Dimension(BOARD_Configurations.TILE_SIZE, BOARD_Configurations.TILE_SIZE));
        assignTileColor();
        assignTilePieceIcon(chessBoard);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        validate();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isIsChosen() {
        return isChosen;
    }

    public void setIsChosen(boolean isChosen) {
        this.isChosen = isChosen;
        assignTileColor();
        validate();
    }

    private void assignTilePieceIcon(Board board) {
        this.removeAll();
        Tile thisTile = board.getTile(this.coordinate);
        if (thisTile == null) {
            System.out.println("Tile is null");
            return;
        }
        if (thisTile.hasPiece()) {
            JLabel jlabel = new JLabel(BoardUtilities.getImageOfTeamPiece(thisTile.getPiece().getTeam(), thisTile.getPiece().getType()));
            jlabel.setName(TOOL_TIP_TEXT_KEY);
            this.add(jlabel);
        }
    }

    private void assignTileColor() {
        if (this.coordinate.getX() % 2 == 0 && this.coordinate.getY() % 2 == 0) {
            this.setBackground(BOARD_Configurations.creamColor);
        } else if (this.coordinate.getX() % 2 == 0 && this.coordinate.getY() % 2 == 1) {
            this.setBackground(BOARD_Configurations.lightCyanColor);
        } else if (this.coordinate.getX() % 2 == 1 && this.coordinate.getY() % 2 == 0) {
            this.setBackground(BOARD_Configurations.lightCyanColor);
        } else if (this.coordinate.getX() % 2 == 1 && this.coordinate.getY() % 2 == 1) {
            this.setBackground(BOARD_Configurations.creamColor);
        }
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
