/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class MouseInputHandler implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x : "+e.getPoint().x / 60 +"    y:"+e.getPoint().y / 60 );
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("x : "+e.getPoint().x +"    y:"+e.getPoint().y );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("x : "+e.getPoint().x +"    y:"+e.getPoint().y );
    }

    @Override
    public void mouseEntered(MouseEvent e) {
                System.out.println("x : "+e.getPoint().x +"    y:"+e.getPoint().y );

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("x : "+e.getPoint().x +"    y:"+e.getPoint().y );
    }
    
}
