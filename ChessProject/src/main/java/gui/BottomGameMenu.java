/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Resources.GUI_Configurations;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class BottomGameMenu extends JPanel{
    
    JButton exitToMainMenu;
    JTextArea piecesKilled;
    public BottomGameMenu()
    {
        super(new FlowLayout(GUI_Configurations.BottomGameMenuAlignment, GUI_Configurations.BottomGameMenuHorizontalGap, GUI_Configurations.BottomGameMenuVerticalGap));
        this.setSize(200,200);
        this.setBackground(Color.CYAN);
        exitToMainMenu = new JButton();
        piecesKilled = new JTextArea();
        this.add(exitToMainMenu);
        this.add(piecesKilled);
        this.setVisible(true);
    }
}
