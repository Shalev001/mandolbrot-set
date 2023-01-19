package mandelbrotset;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mandelbrotSet.Complex;

/**
 *
 * @author shale
 */
class MandelbrotSet {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //The panel to display it on
        MainFrameUI theFrame;
        
        //Make the frame
        theFrame = new MainFrameUI();

        //****************
        double step = 0.002;
        int repititions = 10;

        double xoff;
        double yoff;

        double ImMin = -2;
        double ImMax = 2;
        double ReMin = -2;
        double ReMax = 2;

        int width = (int) ((ReMax - ReMin) / step);
        int height = (int) ((ImMax - ImMin) / step);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (double Im = ImMax; Im > ImMin; Im -= step) {
            for (double Re = ReMin; Re < ReMax; Re += step) {

                Complex num = new Complex(Re, Im);
                Complex z = new Complex(0, 0);
                for (int i = 0; i < repititions; i++) {
                    z = Complex.multiply(z, z);
                    z = Complex.add(z, num);
                    if (i > 2 && z.magnitude() < 2) {
                        image.setRGB((int) ((Re - ReMin) / step), (int) ((Im - ImMin) / step), repititions * 60687 - i * 60687 - 1);//work in progress
                    }
                }

                /*else{
                    System.out.print(" ");
                }*/
            }
            //System.out.println("");
        }
        
        //Now that the image has been made pass it over to the panel
        theFrame.setMandelSetImage(image);

        File file = new File("mandelbrot3.png");

        ImageIO.write(image, "png", file);

    }

}
