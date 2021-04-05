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
import chess_game.Resources.GUI_Configurations;
import chess_game.Utilities.BoardUtilities;
import chess_game.Utilities.MoveUtilities;
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
    JLabel pieceIcon;

    public TilePanel(BoardPanel boardPanel, Coordinate coord, Board chessBoard) {
        super(new GridBagLayout());
        this.coordinate = coord;
        pieceIcon = new JLabel();
        this.add(pieceIcon);
        setPreferredSize(new Dimension(BOARD_Configurations.TILE_SIZE, BOARD_Configurations.TILE_SIZE));
        assignTileColor(chessBoard);
        assignTilePieceIcon(chessBoard);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (!chessBoard.hasChosenTile()) { // if there is no chosen piece . Then make this piece chosen...
                    chessBoard.setChosenTile(chessBoard.getTile(coordinate));

                } else {
                    Tile destinationTile = chessBoard.getTile(coordinate); // if there is already a chosen piece then this tile will be destinatin place
                    if (MoveUtilities.isValidMove(chessBoard, destinationTile)) {
                        chessBoard.getCurrentPlayer().makeMove(chessBoard, new Move(chessBoard, chessBoard.getChosenTile(), destinationTile));
                    } else {
                        chessBoard.setChosenTile(destinationTile);

                    }
                }
                boardPanel.updateBoardGUI(chessBoard);

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

    public void assignTilePieceIcon(Board board) {
        //this.removeAll();
        Tile thisTile = board.getTile(this.coordinate);
        if (thisTile == null) {
            System.out.println("Tile is null");
            return;
            
        }
        if (thisTile.hasPiece()) {
            //JLabel pieceIcon = new JLabel(BoardUtilities.getImageOfTeamPiece(thisTile.getPiece().getTeam(), thisTile.getPiece().getType()));
            //this.add(pieceIcon);
            pieceIcon.setIcon(BoardUtilities.getImageOfTeamPiece(thisTile.getPiece().getTeam(), thisTile.getPiece().getType()));
            pieceIcon.validate();
        }
        else if (!thisTile.hasPiece())
        {
            pieceIcon.setIcon(null);
            pieceIcon.validate();
        }
        
        //this.add(pieceIcon);
    }

    public void assignTileColor(Board board) {

        if (this.coordinate.getX() % 2 == 0 && this.coordinate.getY() % 2 == 0) {
            this.setBackground(GUI_Configurations.creamColor);
        } else if (this.coordinate.getX() % 2 == 0 && this.coordinate.getY() % 2 == 1) {
            this.setBackground(GUI_Configurations.lightCyanColor);
        } else if (this.coordinate.getX() % 2 == 1 && this.coordinate.getY() % 2 == 0) {
            this.setBackground(GUI_Configurations.lightCyanColor);
        } else if (this.coordinate.getX() % 2 == 1 && this.coordinate.getY() % 2 == 1) {
            this.setBackground(GUI_Configurations.creamColor);
        }
        if (board.hasChosenTile()) {
            if (this.coordinate.equals(board.getChosenTile().getCoordinate())) {
                this.setBackground(Color.GREEN);
            }

        }
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
