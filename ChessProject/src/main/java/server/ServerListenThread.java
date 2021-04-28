/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class ServerListenThread extends Thread {

    private Server server;

    public ServerListenThread(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (!this.server.socket.isClosed()) {
            try {
                System.out.println("Listening");
                Socket nSocket = this.server.socket.accept();
                SClient nClient = new SClient(nSocket);
                nClient.Listen();
                server.clients.add(nClient);
            } catch (IOException ex) {
                Logger.getLogger(ServerListenThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
