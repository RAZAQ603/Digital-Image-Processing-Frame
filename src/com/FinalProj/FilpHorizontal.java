package MathematicalOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilpHorizontal {


    private final BufferedImage image;

    public FilpHorizontal (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply(){
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Create mirror image pixel by pixel
        for (int y = 0; y < height; y++)
        {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--)
            {
                // lx starts from the left side of the image
                // rx starts from the right side of the image
                // lx is used since we are getting pixel from left side
                // rx is used to set from right side
                // get source pixel value
                int p = image.getRGB(lx, y);

                // set mirror image pixel value
                newImage.setRGB(rx, y, p);
            }
        }


        return newImage;
    }






















}
