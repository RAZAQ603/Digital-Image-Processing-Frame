package MathematicalOperations;





import java.awt.Color;
import java.awt.image.BufferedImage;

public class Binarization {

    private final BufferedImage image;
    public Binarization(BufferedImage image) {
        this.image = image;
    }
    public BufferedImage apply(int ThresholdRed, int ThresholdGreen,int ThresholdBlue){

        int High = image.getHeight();
        int Width = image.getWidth();

        int red, green, blue;

        Color [][] colors = new Color[High][Width];

        for (int j = 0; j < High; j++) {
            for (int i = 0; i < Width; i++) {
                int srcPixel = image.getRGB(i, j);
                Color c = new Color(srcPixel);
                red = c.getRed();
                green = c.getGreen();
                blue = c.getBlue();

                if(red > ThresholdRed){
                    red = 0;
                }else{
                    red = 255;
                }

                if(green > ThresholdGreen){
                    green = 0;
                }else{
                    green = 255;
                }

                if(blue > ThresholdBlue){
                    blue = 0;
                }else{
                    blue = 255;
                }

                colors[j][i] = new Color(red,green,blue,255);
            }
        }
        BufferedImage newImage = new BufferedImage(Width, High, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < High; i++) {
            for (int j = 0; j < Width; j++) {
                newImage.setRGB(j, i, colors[i][j].getRGB());
            }
        }
        return newImage;
    }
}
