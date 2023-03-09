package mandelbrotset;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import mandelbrotSet.Complex;
import mandelbrotset.Fractals;

/**
 *
 * @author shale
 */
class MandelbrotSet {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //The panel to display it on
        MainFrameUI theFrame;
        
        //Make the frame
        theFrame = new MainFrameUI();

        //****************
        Color color;
        
        double real = 0;
        double imaginary = 0;
        
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
        
        int threadnum = 20;
        Multithread[] threads = new Multithread[threadnum];
 
        
        Color[] colors = {new Color(230,50,38),
            new Color(38,177,255),
            new Color(255,38,64),
            new Color(0,0,0)};

        BufferedImage image = new BufferedImage(width, height+1, BufferedImage.TYPE_INT_RGB);
while(xoff <4){
        for (double Im = ImMax; Im > ImMin; Im -= stepIm*threadnum) {
            for(int i = 0; i < threadnum; i++){
                threads[i] = new Multithread(Im + i*stepIm, stepRe,stepIm,ReMin, ReMax, ImMin, ImMax,
            image,repititions,width,height,colors,real,imaginary);
                threads[i].start();
            }
            for(int i = 0; i < threadnum; i++){
                threads[i].join();
            }
            /*//done in multithread class now
            for (double Re = ReMin; Re < ReMax; Re += stepRe) {
                        color = new Color(255,255,255);
                        image.setRGB((int)((Re-ReMin)/(ReMax-ReMin)*width), (int)((Im-ImMin)/(ImMax-ImMin)*height), color.getRGB() );//work in progress
                
                       
                    Complex c = new Complex(Re, Im);
                    Complex z = new Complex(real, imaginary);
                    
                    rep = Fractals.MandelbrotSubSampled(z,c, repititions,20,stepRe,stepIm);
                    //rep = Fractals.Mandelbrot(z,c, repititions);
                
            
                if (rep > 2){
                //color = new Color((int)(((Math.sin(rep)+1)*255)/2)/(int)(((float)(1+rep/10)/repititions)*255),(int)(((Math.cos(rep+Math.PI/2)+1)*255)/2)/(int)(((float)(1+rep/10)/repititions)*255),(int)(((Math.cos(rep)+1)*255)/2)/(int)(((float)(1+rep/10)/repititions)*255 ));
                color = Fractals.expgradiant(2, repititions, rep, colors);
                image.setRGB((int)(((Re-ReMin)/(ReMax-ReMin))*width), (int)(((Im-ImMin)/(ImMax-ImMin))*height), color.getRGB() );//work in progress
                }
                rep = 0;
                
                else{
                    System.out.print(" ");
                }
            }*/
            
            //System.out.println("");
            
        }
        
        //Now that the image has been made pass it over to the panel
        theFrame.setMandelSetImage(image);
        //xoff+=0.05;
        //yoff+=0.05;
        //TimeUnit.MILLISECONDS.sleep(100);
        scale*= 1.4;
        ImMin = -(2/scale)+yoff;
        ImMax = (2/scale) +yoff;
        ReMin = -(2/scale)+xoff;
        ReMax = (2/scale) +xoff;
        stepRe = (ReMax - ReMin)/width;
        stepIm = (ImMax - ImMin)/height;
        real +=0;
        imaginary += 0;
        
}
        File file = new File("mandelbrot3.png");

        ImageIO.write(image, "png", file);

    }

}
