package MathematicalOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GammaTransform {

    private final BufferedImage image;

    public GammaTransform (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply(){
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<image.getWidth(); i++) {
            for(int j=0; j<image.getHeight(); j++) {
                int[] pixel = image.getRaster().getPixel(i, j, new int[3]);

                //get the gamma corrected value
                int k = (int) (255*(Math.pow((double)pixel[0]/(double)255, 2.2)));
                Color color = new Color(k, k, k);
                int rgb = color.getRGB();
                newImage.setRGB(i, j, rgb);
            }
        }
        return newImage;
    }









}
