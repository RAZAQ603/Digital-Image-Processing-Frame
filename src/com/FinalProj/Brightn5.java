package MathematicalOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Brightn5 {

    private final BufferedImage image;

    public Brightn5 (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply(){
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<image.getWidth(); i++) {
            for(int j=0; j<image.getHeight(); j++) {
                int[] pixel = image.getRaster().getPixel(i, j, new int[3]);

                //adding constant we can also subtract constant from here
                int k = pixel[0]+50;

                //check if the value out side of the boundary
                if(k>255)
                    k = 255;
                else if(k<0)
                    k = 0;
                Color color = new Color(k, k,k);
                int rgb = color.getRGB();
                newImage.setRGB(i, j, rgb);
            }
        }
        return newImage;
    }
}
