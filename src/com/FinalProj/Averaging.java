package MathematicalOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Averaging {

    private final BufferedImage image;

    public Averaging (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply() {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<image.getWidth(); i++) {
            for(int j=0; j<image.getHeight(); j++) {
                int[] pixel = image.getRaster().getPixel(i, j, new int[3]);

                //get the average of RGB value
                int k = (pixel[0]+pixel[1]+pixel[2])/3;

                //set the average to the pixel
                Color color = new Color(k, k, k);
                int rgb = color.getRGB();
                newImage.setRGB(i, j, rgb);
            }
        }
        return newImage;
    }
}
