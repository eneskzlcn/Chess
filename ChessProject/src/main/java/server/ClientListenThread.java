/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Messages.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
// The purpose of this thread is listening data incoming to the sclients input stream. After a data come this thread determines what will
// going to do with this data and then recontinue to the listening the input stream. This listening never ends until the sclient connection
// is lost...
public class ClientListenThread extends Thread {

    SClient client;

    public ClientListenThread(SClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (!this.client.socket.isClosed()) {

            try {
                Message msg = (Message) (this.client.cInput.readObject());
                switch (msg.type) {
                    case PAIRING:
                        this.client.isWantToPair = true;
                        this.client.pairingThread.start();
                        break;
                    case MOVE:
                        this.client.pair.Send(msg);
                        break;
                    case CHECK:
                        this.client.pair.Send(msg);
                        break;
                    case END:
                        this.client.isPaired = false;
                        this.client.isWantToPair = false;
                        this.client.pair = null;

                    case LEAVE:
                        this.client.isPaired = false;
                        this.client.isWantToPair = false;
                        this.client.pair.isWantToPair = false;
                        this.client.pair.isPaired = false;
                        this.client.pair.pair = null;
                        this.client.pair = null;

                }
            } catch (IOException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
