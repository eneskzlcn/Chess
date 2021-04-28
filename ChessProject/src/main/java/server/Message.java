/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Message implements java.io.Serializable{
   
    public MessageTypes type;
    public Object messageContent;
    public Message(MessageTypes type)
    {
        this.type = type;
    }
}
