package Messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Message implements java.io.Serializable {

    public static enum MessageTypes {
        DENEME, MATCHED, START, MOVE, END,PAIRING
    };

    public MessageTypes type;
    public Object messageContent;

    public Message(MessageTypes type) {
        this.type = type;
    }
}
