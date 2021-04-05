/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Resources;

import chess_game.Pieces.Coordinate;
import chess_game.Pieces.Team;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class PIECE_Configurations {

    //this coordinates means a knıght can make 8 different moves in a possible position. Its current position plus this positions shows its possible move coordinates.
    public static Coordinate[] KNIGHT_MOVES = {new Coordinate(2, 1), new Coordinate(-2, 1), new Coordinate(2, -1), new Coordinate(-2, -1), new Coordinate(1, 2), new Coordinate(-1, 2), new Coordinate(1, -2), new Coordinate(-1, -2)};

    //this coordinates shows a bishops available move directions from its current position;
    public static Coordinate[] BISHOP_MOVES = {new Coordinate(1, 1), new Coordinate(-1, 1), new Coordinate(1, -1), new Coordinate(-1, -1)};

    //this coordinates shows a roooks available move directions from its current position;
    public static Coordinate[] ROOK_MOVES = {new Coordinate(0, 1), new Coordinate(0, -1), new Coordinate(1, 0), new Coordinate(-1, 0)};

    //this coordinates shows a queens available move directions from its current position;
    public static Coordinate[] QUUEN_MOVES = {new Coordinate(0, 1), new Coordinate(0, -1), new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(1, 1), new Coordinate(-1, 1), new Coordinate(1, -1), new Coordinate(-1, -1)};

    //this coordinates shows a black pawns available movement directions from its current position
    public static Coordinate[] BLACK_PAWN_NORMAL_MOVES = {new Coordinate(0, 1)};

    //this coordinates shows a white pawns available movement directions from its current position
    public static Coordinate[] WHITE_PAWN_NORMAL_MOVES = {new Coordinate(0, -1)};

    //this coordinates shows the coordinate way that can a white pawn able to attack
    public static Coordinate[] WHITE_PAWN_ATTACK_MOVES = {new Coordinate(1, -1), new Coordinate(-1, -1)};

    //this coordinates shows the coordinate way that can a black pawn able to attack 
    public static Coordinate[] BLACK_PAWN_ATTACK_MOVES = {new Coordinate(1, 1), new Coordinate(-1, 1)};

    //black pawn able to double move at start. This shows it.
    public static Coordinate[] BLACK_PAWN_START_MOVES = {new Coordinate(0, 2)};

    //white pawn able to double move at start. This shows it.
    public static Coordinate[] WHITE_PAWN_START_MOVES = {new Coordinate(0, -2)};

    public static int BLACK_PAWNS_START_Y_POS = 1;

    public static int WHITE_PAWNS_START_Y_POS = 6;

    public static Map<Team, Map> PAWN_MOVES; // Here is a map for the 3 different pawn moves.

    static {
        PAWN_MOVES = new HashMap<>();
        Map<String, Coordinate[]> whitePawnMoves = new HashMap<>();
        Map<String, Coordinate[]> blackPawnMoves = new HashMap<>();
        whitePawnMoves.put("Normal", WHITE_PAWN_NORMAL_MOVES);
        whitePawnMoves.put("Attack", WHITE_PAWN_ATTACK_MOVES);
        whitePawnMoves.put("Start", WHITE_PAWN_START_MOVES);
        blackPawnMoves.put("Normal", BLACK_PAWN_NORMAL_MOVES);
        blackPawnMoves.put("Attack", BLACK_PAWN_ATTACK_MOVES);
        blackPawnMoves.put("Start", BLACK_PAWN_START_MOVES);
        PAWN_MOVES.put(Team.WHITE, whitePawnMoves);
        PAWN_MOVES.put(Team.BLACK, blackPawnMoves);

    }

    public static int getPawnStartPosY(Team team) {
        if (team == Team.WHITE) {
            return WHITE_PAWNS_START_Y_POS;
        } else {
            return BLACK_PAWNS_START_Y_POS;
        }
    }
}
