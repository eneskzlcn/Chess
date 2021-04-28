/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Boards.Board;
import chess_game.Pieces.PieceTypes;
import chess_game.Pieces.Team;
import chess_game.Resources.BOARD_Configurations;
import chess_game.Resources.GUI_Configurations;
import chess_game.Resources.PIECE_Configurations;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Table {

    private JFrame gameFrame;
    private BoardPanel boardPanel;
    private Board chessBoard;
    private MainMenu mainMenu;
    private InGameBottomMenu bottomGameMenu;

    public Table() {
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(GUI_Configurations.OUTER_FRAME_DIMENSION);
        this.mainMenu = new MainMenu();
        createMainMenu();
        this.gameFrame.setVisible(true);

    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public Board getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(Board chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setGameFrame(JFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public void createMainMenu() {
        //this.gameFrame.removeAll();

        this.mainMenu.getSettingsBTN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createGamePanel();
            }
        });
        this.gameFrame.add(mainMenu, BorderLayout.CENTER);
    }

    public void createGamePanel() {
        this.gameFrame.remove(mainMenu);
        this.chessBoard = new Board();
        this.boardPanel = new BoardPanel(this.chessBoard);
        this.bottomGameMenu = new InGameBottomMenu();
        this.gameFrame.add(boardPanel);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.add(this.bottomGameMenu, BorderLayout.PAGE_END);

        this.gameFrame.setVisible(true);

    }
}
