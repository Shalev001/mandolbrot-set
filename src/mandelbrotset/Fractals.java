/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mandelbrotset;

import java.awt.Color;
import mandelbrotSet.Complex;

/**
 *
 * @author shale
 */
public class Fractals {
    
    public static int Mandelbrot(Complex z, Complex c, int repititions){
        
        int rep = 0;
        
        for (int i = 0; i < repititions; i++) {
                    z = Complex.multiply(z, z);
                    z = Complex.add(z, c);
                    if (i > 2 && z.magnitude() < 2) {
                        rep = i;
                    }else if (i > 2){
                        break;
                    }
                }
        
        return rep;
    }
    
    public static Color gradiant(int min, int max,int num,Color[] colors){
        int step = (max - min)/colors.length;
        if (((num-min)/step)+1<=colors.length-1){
            int index = (num-min)/step;
        Color color1 = colors[index];
        Color color2 = colors[index+1];
        Color hi = new Color((int)(color1.getRed()+((color2.getRed()-color1.getRed())*(((num-min)-index*step)/(float)step))),
                (int)(color1.getGreen()+((color2.getGreen()-color1.getGreen())*(((num-min)-index*step)/(float)step))),
                (int)(color1.getBlue()+((color2.getBlue()-color1.getBlue())*(((num-min)-index*step)/(float)step))));
        return hi;
        }
        else {
            return colors[colors.length-1];
        }
    }
    
}
