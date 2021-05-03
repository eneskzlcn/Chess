/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Pieces;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public enum Team implements java.io.Serializable {
    WHITE {
        @Override
        public String toString() {
            return "White";
        }

    },
    BLACK {
        @Override
        public String toString() {
            return "Black";
        }
    }, NOCOLOR {
        @Override
        public String toString() {
            return "No Color";
        }
    };

}
