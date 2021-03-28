/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Boards.Board;
import chess_game.Resources.GUI_Configurations;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Table {
    
    private JFrame gameFrame;
    private BoardPanel boardPanel;
    private Board chessBoard;
    
    public Table()
    {
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(GUI_Configurations.OUTER_FRAME_DIMENSION);
        this.chessBoard = new Board();
        this.boardPanel = new BoardPanel(this.chessBoard);
        this.gameFrame.add(boardPanel);
        this.gameFrame.add(this.boardPanel,BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(JFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    
}
