/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class ClientRemovingControlThread extends Thread{

    private Server server;

    public ClientRemovingControlThread(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        
        while(!this.server.socket.isClosed())
        {
            for(SClient client : Server.clients)
            {
                if(client.socket.isClosed())
                {
                    Server.clients.remove(client);
                }
            }
        }
    }
    
    
}
