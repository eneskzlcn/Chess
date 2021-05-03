package ClientSide;

import Messages.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ClientSide.*;
import Messages.MovementMessage;
import chess_game.Boards.Board;
import chess_game.Move.Move;
import chess_game.Pieces.Team;
import chess_game.Player.Player;
import javax.swing.JOptionPane;

/*
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
 */

 /* 9
 
  @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class ClientListenThread extends Thread {

    Client client;

    public ClientListenThread(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (!this.client.socket.isClosed()) {

            try {

                Message msg = (Message) (this.client.sInput.readObject());
                switch (msg.type) {
                    case START:
                        Team serverChosenTeam = (Team) msg.messageContent;
                        this.client.setTeam(serverChosenTeam);
                        break;
                    case PAIRING:
                        this.client.isPaired = true;
                        this.client.game.getMainMenu().getPlayBTN().setEnabled(true);
                        this.client.game.getMainMenu().getPlayBTN().setText("Start Game");
                        this.client.game.getMainMenu().getInfoLBL().setText("Matched. Click To Start Game");
                        break;
                    case MOVE:
                        /* when we read move object directly we need to to this changes to make the references true...

                        Move enemyMove = (Move)(msg.messageContent);
                        Player player = this.client.game.getChessBoard().getCurrentPlayer();
                        enemyMove.setBoard(this.client.game.getChessBoard());
                        enemyMove.setCurrentTile(this.client.game.getChessBoard().getTile(enemyMove.getCurrentTile().getCoordinate()));
                        enemyMove.setDestinationTile(this.client.game.getChessBoard().getTile(enemyMove.getDestinationTile().getCoordinate()));
                        if(enemyMove.getKilledPiece() != null)
                        {
                            enemyMove.setKilledPiece(this.client.game.getChessBoard().getTile(enemyMove.getDestinationTile().getCoordinate()).getPiece());
                        }
                        player.makeMove(this.client.game.getChessBoard(), enemyMove);
                        this.client.game.getBoardPanel().updateBoardGUI(this.client.game.getChessBoard());
                        this.client.game.getChessBoard().changeCurrentPlayer(); 
                         */

                        //when we use the movement message, these part is enough to know what enemy move.
                        MovementMessage movement = (MovementMessage) msg.messageContent;
                        Board board = this.client.game.getChessBoard();
                        Player player = board.getCurrentPlayer();
                        Move move = new Move(board, board.getTile(movement.currentCoordinate), board.getTile(movement.destinationCoordinate));
                        player.makeMove(board, move);
                        this.client.game.getBoardPanel().updateBoardGUI(this.client.game.getChessBoard());
                        board.changeCurrentPlayer();
                        break;
                    case CHECK:
                        //if any check state comes to client. Write information to the connected menu object.
                        Team checkStateTeam = (Team) msg.messageContent;
                        JOptionPane.showMessageDialog(null, "Check state for team: " +checkStateTeam.toString());
                        break;
                }

            } catch (IOException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Girilen class bulunamadı");
            }
        }
    }
}
