/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Messages.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
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
                System.out.println("Pairing thread aktif oldu.");
                //matching system starts to matching clients.
                SClient chosenPair = null;
                //while the client is connected and not have pair try this to match him.
                while (this.client.socket.isConnected() && chosenPair == null) {
                    for (SClient client : Server.clients) {
                        if (client != this.client && client.isPaired == false && client.isWantToPair == true) {
                            //matching objects and making client pairs to play each other.
                            chosenPair = client;
                            this.client.pair = chosenPair;
                            client.pair = this.client;
                            this.client.isWantToPair = false;
                            client.isWantToPair = false;    
                            client.isPaired = true;
                            this.client.isPaired = true;
                            //giving information to the clients about the success on pairing3
                            Message message = new Message(Message.MessageTypes.PAIRING);
                            message.messageContent = "Eşleştin";
                            Server.SendMessage(this.client, (message));
                            Server.SendMessage(chosenPair,  (message));
                            
                            //after succeeded pairing, determine the team of the clients which for the chess game(black or white)
                            Message clientStartMessage = new Message(Message.MessageTypes.START);
                            clientStartMessage.messageContent = "White";
                            Message pairClientStartMessage = new Message(Message.MessageTypes.START);
                            pairClientStartMessage.messageContent = "Black";
                            Server.SendMessage(this.client, clientStartMessage);
                            Server.SendMessage(chosenPair,pairClientStartMessage);
                            break;
                        }
                    }
                    //do not try anytime this operation. Just every second is enough. So sleep...
                    sleep(1000);
                    
                    
                }
                Server.pairingLockForTwoPair.release();
            } catch (InterruptedException ex) {
                System.out.println("Pairing thread could not been acquired 1 permit. There is an error occured there.");
            }
        }
    }
}
