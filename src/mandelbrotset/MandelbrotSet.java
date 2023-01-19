package mandelbrotset;

import java.awt.Color;
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
        Color color;
        
        int repititions = 500;
        int repMin;

        double xoff = -0.74132652;
        double yoff = -0.23506;
        double scale = 1;

        double ImMin = -(2/scale)+yoff;
        double ImMax = (2/scale) +yoff;
        double ReMin = -(2/scale)+xoff;
        double ReMax = (2/scale) +xoff;

        int width = 480;
        int height = 480;
        double stepRe = (ReMax - ReMin)/width;
        double stepIm = (ImMax - ImMin)/height;
        int rep = 0;

        BufferedImage image = new BufferedImage(width, height+1, BufferedImage.TYPE_INT_RGB);
while(xoff <3){
        for (double Im = ImMax; Im > ImMin; Im -= stepIm) {
            for (double Re = ReMin; Re < ReMax; Re += stepRe) {
                        color = new Color(255,255,255);
                        image.setRGB((int)((Re-ReMin)/(ReMax-ReMin)*width), (int)((Im-ImMin)/(ImMax-ImMin)*height), color.getRGB() );//work in progress
                Complex num = new Complex(Re, Im);
                Complex z = new Complex(0, 0);
                for (int i = 0; i < repititions; i++) {
                    z = Complex.multiply(z, z);
                    z = Complex.add(z, num);
                    if (i > 2 && z.magnitude() < 2) {
                        rep = i;
                    }
                }
                if (rep > 2){
                color = new Color((int)(((Math.sin(rep)+1)*255)/2)/(1+rep/8),(int)(((Math.cos(rep+Math.PI/2)+1)*255)/2)/(1+rep/8),(int)(((Math.cos(rep)+1)*255)/2)/(1+rep/8));
                image.setRGB((int)((Re-ReMin)/(ReMax-ReMin)*width), (int)((Im-ImMin)/(ImMax-ImMin)*height), color.getRGB() );//work in progress
                }
                rep = 0;
                
                /*else{
                    System.out.print(" ");
                }*/
            }
            //System.out.println("");
        }
        
        //Now that the image has been made pass it over to the panel
        theFrame.setMandelSetImage(image);
        //xoff+=0.05;
        //yoff+=0.05;
        scale*=1.5;
        ImMin = -(2/scale)+yoff;
        ImMax = (2/scale) +yoff;
        ReMin = -(2/scale)+xoff;
        ReMax = (2/scale) +xoff;
        stepRe = (ReMax - ReMin)/width;
        stepIm = (ImMax - ImMin)/height;
}
        File file = new File("mandelbrot3.png");

        ImageIO.write(image, "png", file);

    }

}
