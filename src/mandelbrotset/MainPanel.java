/*
 * Lukas Krampitz
 * Jan 18, 2023
 * 
 */
package mandelbrotset;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
     *
     * @param m
     */
    public MainPanel(MainFrameUI m) {

        mainFrameUI = m;

    }

    /**
     * Override the JPanel default paintComponent() method.
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //draw the compoments of the super class

        //draw the custom stuff (epic fractal)
        draw(g);
    }

    /**
     * Custom Draw method. Slap up the nifty BufferedImage.
     *
     * @param g
     */
    private void draw(Graphics g) {
        //stop using Graphics. Get G2D

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.red);
        g2d.drawRect(100, 100, 100, 100);
    }

}
