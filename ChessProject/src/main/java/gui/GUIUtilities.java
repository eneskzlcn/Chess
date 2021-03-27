/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
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
public class GUIUtilities {
    
    public static ImageIcon getImageIcon(String image_source)
    {
         try { 
            File img = new File(image_source);
            BufferedImage bufferedImage = ImageIO.read(img);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            return imageIcon;
            
        } catch (IOException ex) {
            Logger.getLogger(GUIUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
