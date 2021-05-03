/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
   @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */

// this thread called by server directly when the server opens and never closes. The purpose of this
// thread is always waiting for new client connection requests to accept or reject them.

public class ListenConnectionRequestThread extends Thread {

    private Server server;

    public ListenConnectionRequestThread(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (!this.server.socket.isClosed()) {
            try {
                Socket nSocket = this.server.socket.accept();
                SClient nClient = new SClient(nSocket);
                nClient.Listen();
                server.clients.add(nClient);
                
            } catch (IOException ex) {
                System.out.println("There is an error occured when the new client being accepted.");
            }
        }
    }
}
