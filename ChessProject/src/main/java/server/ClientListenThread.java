/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class ClientListenThread extends Thread {

    SClient client;

    public ClientListenThread(SClient client) {
        this.client= client;
    }

    @Override
    public void run() {
        while (!this.client.socket.isClosed()) {
            
            try {
                Object msg = this.client.cInput.readObject();
                System.out.println(msg.toString());
            } catch (IOException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
