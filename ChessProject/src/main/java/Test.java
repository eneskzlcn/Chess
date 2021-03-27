/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import chess_game.Resuources.GUI_Configurations;
import chess_game.Pieces.King;
import gui.*;
import java.awt.Dimension;

import javax.swing.*;
import gui.*;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Test {
    public static void main(String[] args) {
        
            Table table = new Table();
            JLabel j = new JLabel();
            j.setIcon(GUIUtilities.getImageIcon("black_bishop.png"));
            j.setSize(GUI_Configurations.TILE_DIMENSION);
            j.setVisible(true);
            JPanel jp = new  JPanel();
            JLabel a = new JLabel();
            a.setText("asfagagagsaaaaaaaaa");
            a.setSize(new Dimension(50,50));
            table.getGameFrame().getContentPane().add(j);
    }
}
