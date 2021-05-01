package ClientSide;

import Messages.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ClientSide.*;
import chess_game.Move.Move;
import chess_game.Pieces.Team;
import chess_game.Player.Player;
import chess_game.gui.MainMenu;
import java.util.Set;

/*
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
 */

 /* 
 
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
                if (msg.type == Message.MessageTypes.PAIRING) {
                    this.client.isPaired = true;
                    this.client.game.getMainMenu().getPlayBTN().setEnabled(true);
                    this.client.game.getMainMenu().getPlayBTN().setText("Start Game");
                    this.client.game.getMainMenu().getInfoLBL().setText("Matched. Click To Start Game");
                } else if (msg.type == Message.MessageTypes.START) {
                    if ((msg.messageContent).equals("Black")) {
                        this.client.setTeam(Team.BLACK);

                    } else if ((msg.messageContent).equals("White")) {
                        this.client.setTeam(Team.WHITE);
                    }
                }
                else if(msg.type == Message.MessageTypes.MOVE)
                {
                    Move enemyMove = (Move)(msg.messageContent);
                    Player player = this.client.game.getChessBoard().getCurrentPlayer();
                    player.makeMove(this.client.game.getChessBoard(), enemyMove);
                    //this.client.game.boardPanel.updateBoardGUI(chessBoard);
                    this.client.game.getChessBoard().changeCurrentPlayer();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Girilen class bulunamadı");
                //System.out.println("Girilen class bulunamadı. Gönderilen class tipi = 0"+fmsg.getClass().toString());
            }
        }
    }
}
