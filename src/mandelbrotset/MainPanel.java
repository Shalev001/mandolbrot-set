/*
 * Lukas Krampitz
 * Jan 18, 2023
 * 
 */
package mandelbrotset;

import java.awt.image.BufferedImage;

/**
 *
 * @author Tacitor
 */
public class MainPanel extends javax.swing.JPanel {
    
    //ref to the super frame
    MainFrameUI mainFrameUI;
    
    private BufferedImage setImage;
    
    /**
     * Main Constructor
     * @param m
     */
    public MainPanel(MainFrameUI m) {
        
        mainFrameUI = m;
        
    }
    
    
    
}
