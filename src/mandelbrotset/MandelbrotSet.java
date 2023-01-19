package mandelbrotset;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mandelbrotSet.Complex;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        
        
        //****************
        
        double step = 0.00208;
        int repititions = 1000;  
        
        double xoff;
        double yoff;
        
        double ImMin = -2;
        double ImMax = 2;
        double ReMin = -2;
        double ReMax = 2;
        
        int width = (int)((ReMax-ReMin)/step);
        int height = (int)((ImMax-ImMin)/step);
        
        
        
        
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB );
        Graphics2D g2d = image.createGraphics();
        
        JFrame  frame = new JFrame("manolbrot",null);
        JPanel  panel = new JPanel();
        frame.setSize(width, height);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,width,height);
        
        
        
        for(double Im = ImMax; Im > ImMin;Im -= step){
            for(double Re = ReMin; Re < ReMax;Re += step){
                
                Complex num = new Complex(Re,Im);
                Complex z = new Complex(0,0);
                for(int i = 0; i < repititions;i++){
                    z = Complex.multiply(z,z);
                    z = Complex.add(z,num);
                    if (i > 2 && z.magnitude() < 2){
                        image.setRGB((int)((Re-ReMin)/step),(int)((Im-ImMin)/step),repititions*60687-i*60687-1);//work in progress
                    }  
                }
                 
                /*else{
                    System.out.print(" ");
                }*/
            }
            //System.out.println("");
        }
        
        g2d.drawImage(image,0,0,width,height,null);
        frame.update(g2d);
        g2d.dispose();
        
        File file = new File("mandelbrot3.png");
        
        ImageIO.write(image, "png", file);
        
    }
    
}
