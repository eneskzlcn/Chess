/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Resuources.GUI_Configurations;
import javax.swing.JFrame;
/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Table {
    
    private JFrame gameFrame;
    
    public Table()
    {
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setSize(GUI_Configurations.OUTER_FRAME_DIMENSION);
        this.gameFrame.setVisible(true);
    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(JFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    
}
