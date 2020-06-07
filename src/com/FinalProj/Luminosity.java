package MathematicalOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Luminosity {

    private final BufferedImage image;

    public Luminosity (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply() {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<image.getWidth(); i++) {
            for(int j=0; j<image.getHeight(); j++) {
                int[] pixel = image.getRaster().getPixel(i, j, new int[3]);

                //get the new value
                int k =(int)((0.3*pixel[0])+(0.59*pixel[1])+(0.11*pixel[2]));
                Color color = new Color(k, k, k);
                int rgb = color.getRGB();
                newImage.setRGB(i, j, rgb);
            }
        }
        return newImage;
    }
}
