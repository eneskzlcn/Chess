/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Messages.Message;
import chess_game.Pieces.Team;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */

//The purpose of this thread is the pairing every client with its rival in game. Because of the chess game is 1 versus 1 game,
// the pairing operation just happens between 2 clients. When this thread called by a sclient, it starts to search for a player 
// which also want to pair with someone. When the pairing completed, this thread gonna stops until this sclient finish or leave
//its match and start to search a new rival for a new game.
public class ClientPairingThread extends Thread {

    SClient client;

    public ClientPairingThread(SClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (this.client.socket.isConnected() && this.client.isWantToPair == true && this.client.isPaired == false) {

            try {
                // take one client to here ==> acquire 1 permit
                Server.pairingLockForTwoPair.acquire(1);
                //matching system starts to matching clients.
                SClient chosenPair = null;
                //while the client is connected and not have pair try this to match him.
                while (this.client.socket.isConnected() && chosenPair == null) {
                    for (SClient client : Server.clients) {
                        if (client != this.client && client.isPaired == false && client.isWantToPair == true) {
                            //matching objects and making client pairs to play each other.
                            chosenPair = client;
                            this.client.pair = client;
                            client.pair = this.client;
                            this.client.isWantToPair = false;
                            client.isWantToPair = false;    
                            client.isPaired = true;
                            this.client.isPaired = true;
                            //giving information to the clients about the success on pairing3
                            Message message = new Message(Message.MessageTypes.PAIRING);
                            message.content = "Eşleştin";
                            Server.SendMessage(this.client, (message));
                            Server.SendMessage(chosenPair,  (message));
                            
                            //after succeeded pairing, determine the team of the clients which starter for the chess game(black or white)
                            Message clientStartMessage = new Message(Message.MessageTypes.START);
                            clientStartMessage.content = (Object)Team.WHITE;
                            Message pairClientStartMessage = new Message(Message.MessageTypes.START);
                            pairClientStartMessage.content = (Object)Team.BLACK;
                            Server.SendMessage(this.client, clientStartMessage);
                            Server.SendMessage(chosenPair,pairClientStartMessage);
                            break;
                        }
                    }
                    //do not try anytime this operation. Just every second is enough. Do not need to control is there a client want to pair
                    //in any time. Every second is more optimized solution.So sleep 1 second...
                    sleep(1000);
                    
                    
                }
                // after a completed pairing for a sclient. Release the lock to let other clients match with each other.
                Server.pairingLockForTwoPair.release(1);
            } catch (InterruptedException ex) {
                System.out.println("Pairing thread could not been acquired 1 permit. There is an error occured there.");
            }
        }
    }
}
