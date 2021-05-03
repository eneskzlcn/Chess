/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.gui;

import ClientSide.Client;
import Messages.Message;
import Messages.MovementMessage;
import chess_game.Boards.Board;
import chess_game.Boards.Tile;
import chess_game.Pieces.Coordinate;
import chess_game.Move.Move;
import chess_game.Pieces.PieceTypes;
import chess_game.Pieces.Team;
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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
//This class is the visual version of every Tile class in Board class
public class TilePanel extends JPanel {

    Coordinate coordinate;
    JLabel pieceIcon;

    public TilePanel(BoardPanel boardPanel, Coordinate coord, Board chessBoard, Client client) {
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
                if (client.getTeam() != chessBoard.getCurrentPlayer().getTeam()) {
                    return;
                }

                if (!chessBoard.hasChosenTile()) { // if there is no chosen piece . Then make this piece chosen...
                    if (chessBoard.getTile(coordinate).hasPiece()) {
                        if (chessBoard.getCurrentPlayer().getTeam() != chessBoard.getTile(coordinate).getPiece().getTeam()) {
                            return;
                        }
                    }

                    chessBoard.setChosenTile(chessBoard.getTile(coordinate));

                } else {
                    Tile destinationTile = chessBoard.getTile(coordinate); // if there is already a chosen piece then this tile will be destinatin place
                    if (MoveUtilities.isValidMove(chessBoard, destinationTile)) {
                        Move move = new Move(chessBoard, chessBoard.getChosenTile(), destinationTile);
                        chessBoard.getCurrentPlayer().makeMove(chessBoard, move);
                        if (move.hasKilledPiece()) {
                            client.game.getBottomGameMenu().killedPiecesListModel.addElement(move.getKilledPiece().toString());
                        }
                        //the time when we send move class directly we using this code.
//                        Message movementMessage = new Message(Message.MessageTypes.MOVE);
//                        movementMessage.content = (Object) (move);
//                        client.Send(movementMessage);
                        //instead of send move classs directly we just send the coordinates of the tiles (current,destination) in  MovementMessage object
                        Message msg = new Message(Message.MessageTypes.MOVE);
                        MovementMessage movement = new MovementMessage();
                        movement.currentCoordinate = move.getCurrentTile().getCoordinate();
                        movement.destinationCoordinate = move.getDestinationTile().getCoordinate();
                        if (move.getKilledPiece() != null) {
                            movement.isPieceKilled = true;
                        }
                        msg.content = (Object) movement;
                        client.Send(msg);
                        chessBoard.changeCurrentPlayer();
                        client.game.getBottomGameMenu().getTurnLBL().setText("Enemy Turn");
                        client.game.getBottomGameMenu().getTurnLBL().setForeground(Color.RED);

                        if (move.hasKilledPiece()) {
                            if (move.getKilledPiece().getType() == PieceTypes.KING) {
                                Team winnerTeam;
                                winnerTeam = (move.getKilledPiece().getTeam() == Team.BLACK) ? Team.WHITE : Team.BLACK;
                                JOptionPane.showMessageDialog(null, "Winner: " + winnerTeam.toString());
                                Message message = new Message(Message.MessageTypes.END);
                                message.content = null;
                                client.Send(message);
                            }
                        }

                    } else {
                        if (destinationTile.hasPiece()) {
                            if (chessBoard.getCurrentPlayer().getTeam() != chessBoard.getTile(coordinate).getPiece().getTeam()) {
                                return;
                            }
                        }
                        chessBoard.setChosenTile(destinationTile);

                    }
                    if (MoveUtilities.controlCheckState(chessBoard, Team.BLACK)) {
                        JOptionPane.showMessageDialog(null, "Check state for team : " + Team.BLACK.toString());

                        //if there is a chech-state. give a check information to client. And also send this same information to rival client
                        Message msg = new Message(Message.MessageTypes.CHECK);
                        //the content will be the team which in check state ( in-danger)
                        msg.content = (Object) Team.BLACK;
                        client.Send(msg);
                    } else if (MoveUtilities.controlCheckState(chessBoard, Team.WHITE)) {
                        JOptionPane.showMessageDialog(null, "Check state for team : " + Team.WHITE.toString());
                        //if there is a chech-state. give a check information to client. And also send this same information to rival client
                        Message msg = new Message(Message.MessageTypes.CHECK);
                        //the content will be the team which in check state ( in-danger)
                        msg.content = (Object) Team.WHITE;
                        client.Send(msg);
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
        } else if (!thisTile.hasPiece()) {
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
