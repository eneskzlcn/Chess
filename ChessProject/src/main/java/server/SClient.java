/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class SClient {

    public Socket socket;
    public ObjectInputStream cInput;
    public ObjectOutputStream cOutput;
    public ClientListenThread clientListenThread;
    public SClient pair;
    public boolean isPaired;
    
    public SClient(Socket socket) {

        try {
            this.socket = socket;
            this.cOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.cInput = new ObjectInputStream(this.socket.getInputStream());
            this.clientListenThread = new ClientListenThread(this);
            this.isPaired = false;
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SendMessage(Object msg) {
        if (this.socket.isConnected()) {
            try {
                cOutput.writeObject(msg);
            } catch (IOException ex) {
                System.out.println("There is an error occured when sending message");
            }
        }
    }

    public void Listen() {
        this.clientListenThread.start();
    }
}
