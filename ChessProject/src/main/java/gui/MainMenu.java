/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Resources.GUI_Configurations;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;


/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class MainMenu extends JPanel {
    
    
    JButton settingsButton;
    JButton playRandomlyButton;
    JButton joinRoomButton;
    JButton exitButton;
    
    public MainMenu()
    {
        super(new FlowLayout(GUI_Configurations.MainMenuAlignment, GUI_Configurations.MainMenuHorizantalGAP, GUI_Configurations.MainMenuVerticalGAP));
        this.setSize(300,300);
        this.setBackground(Color.BLUE);
        this.settingsButton = new JButton();
        this.settingsButton.setText("Settings");
        this.settingsButton.setSize(100,100);
        this.playRandomlyButton = new JButton();
        this.playRandomlyButton.setSize(100,100);
        this.playRandomlyButton.setText("Play Randomly");
        this.joinRoomButton = new JButton();
        this.joinRoomButton.setSize(100,100);
        this.joinRoomButton.setText("Join Room");
        this.exitButton = new JButton();
        this.exitButton.setSize(100,100);
        this.exitButton.setText("Exit");
        this.add(settingsButton);
        this.add(playRandomlyButton);
        this.add(joinRoomButton);
        this.add(exitButton);
        this.setVisible(true);
    }
    
    
}
