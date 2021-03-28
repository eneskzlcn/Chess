/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import chess_game.Boards.Board;
import chess_game.Pieces.Coordinate;
import java.awt.Graphics;
import javax.swing.JPanel;
import chess_game.Resources.BOARD_Configurations;
import java.awt.Color;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class BoardPanel extends JPanel {

    private TilePanel boardTiles[][];

    public BoardPanel(Board chessBoard) {
        super(new GridLayout(BOARD_Configurations.ROW_COUNT, BOARD_Configurations.ROW_TILE_COUNT));
        this.boardTiles = new TilePanel[BOARD_Configurations.ROW_COUNT][BOARD_Configurations.ROW_TILE_COUNT];
        for (int i = 0; i < BOARD_Configurations.ROW_COUNT; i++) {
            for (int j = 0; j < BOARD_Configurations.ROW_TILE_COUNT; j++) {
                TilePanel tilePanel = new TilePanel(this, new Coordinate(i, j),chessBoard);
                this.boardTiles[i][j] = tilePanel;
                add(tilePanel);
            }

        }
    }
}
