/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chessproject;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Test {
    public static void main(String[] args) {
        King king = new King(true);
        King king2 = new King(true);
        System.out.println(king.getClass() == king2.getClass());
    }
}