/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Resources;

import chess_game.Pieces.PieceTypes;
import chess_game.Pieces.Team;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class BOARD_Configurations {

    public static int ROW_COUNT = 8;
    public static int ROW_TILE_COUNT = 8;
    public static int BOARD_LOWER_BOUND = 0;
    public static int BOARD_UPPER_BOUND = 7;
    public static int TILE_SIZE = 60;
    public static Color creamColor = new Color(255, 229, 204);
    public static Color lightCyanColor = new Color(204, 255, 255);

    public static ImageIcon getImageOfTeamPiece(Team team, PieceTypes pieceType) {

        String imagePath = "../images/";
        if (team == Team.BLACK) {
            imagePath += "black";
        } else {
            imagePath += "white";
        }
        if (pieceType == PieceTypes.BISHOP) {
            imagePath = "_bishop.png";
        } else if (pieceType == PieceTypes.KING) {
            imagePath = "_king.png";
        } else if (pieceType == PieceTypes.QUEEN) {
            imagePath = "_queen.png";
        } else if (pieceType == PieceTypes.KNIGHT) {
            imagePath = "_knight.png";
        } else if (pieceType == PieceTypes.PAWN) {
            imagePath = "_pawn.png";
        } else if (pieceType == PieceTypes.ROOK) {
            imagePath = "_rook.png";
        }
        try {
            File img = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(img);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            return imageIcon;

        } catch (IOException ex) {
            Logger.getLogger(BOARD_Configurations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
