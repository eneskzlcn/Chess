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
    
    
    public JButton settingsButton;
    JButton playRandomlyButton;
    JButton joinRoomButton;
    JButton exitButton;

    public MainMenu()
    {
        super(new FlowLayout(GUI_Configurations.MainMenuAlignment, GUI_Configurations.MainMenuHorizantalGAP, GUI_Configurations.MainMenuVerticalGAP));
        this.setSize(200,200);
        this.setBackground(Color.BLUE);
        this.settingsButton = new JButton();
        this.settingsButton.setName("settingsBTN");
        this.settingsButton.setText("Settings");
        this.settingsButton.setSize(100,100);
        this.playRandomlyButton = new JButton();
        this.playRandomlyButton.setSize(100,100);
        this.playRandomlyButton.setName("playRandomlyBTN");
        this.playRandomlyButton.setText("Play Randomly");
        this.joinRoomButton = new JButton();
        this.joinRoomButton.setSize(100,100);
        this.joinRoomButton.setText("Join Room");
        this.joinRoomButton.setName("joinRoomBTN");
        this.exitButton = new JButton();
        this.exitButton.setSize(100,100);
        this.exitButton.setText("Exit");
        this.exitButton.setName("exitBTN");
        this.add(settingsButton);
        this.add(playRandomlyButton);
        this.add(joinRoomButton);
        this.add(exitButton);
        this.setVisible(true);
    }
    
    
}
