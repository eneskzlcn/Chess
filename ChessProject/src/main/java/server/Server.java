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
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Server {

    public ServerSocket socket;
    public int port;
    public ServerListenThread listenThread;
    public static ArrayList<SClient> clients;

    //lock mechanism for pairing thread. One client can match with one client at the same time. So we use the lock mechanism to provide
    //other clients not try to pair this client at the same time.
    public static Semaphore pairingLockForTwoPair = new Semaphore(1, true);

    public Server(int port) {
        try {
            this.port = port;
            this.socket = new ServerSocket(this.port);
            this.listenThread = new ServerListenThread(this);
            this.clients = new ArrayList<SClient>();

        } catch (IOException ex) {
            System.out.println("There is an error occured when opening the server on port:" + this.port);

        }
    }

    // starts the listen thread
    public void Listen() {
        this.listenThread.start();
    }
}
