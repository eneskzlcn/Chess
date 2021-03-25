/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game_2;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Tile {
    private int x;
    private int y;
    private Piece piece;
    
    public Tile(int x,int y,Piece piece)
    {
        this.setX(x);
        this.setY(y);
        this.setPiece(piece);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public boolean hasPiece()
    {
        return this.piece == null;
    }
    
}
