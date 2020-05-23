package MathematicalOperations;




import java.awt.Color;
import java.awt.image.BufferedImage;

public class Contrast {

    private final BufferedImage image;
    private final int [][] Histogram;
    private final int Channels ;

    public Contrast(BufferedImage image) {
        this.image = image;
        this.Histogram = new Histogram().histogram(image);
        this.Channels = 3;
    }

    public BufferedImage contrast(){

        int levelsOfIntents = 256;
        int rows = image.getHeight();
        int columns  = image.getWidth();
        int dimen = rows*columns;
        int[][] fg = new int[Channels][levelsOfIntents];
        int[] histogram;
        int fa;

        for (int i = 0; i < Channels; i++) {
            fa = 0;
            for (int j = 0; j < levelsOfIntents; j++) {
                fa += Histogram[i][j];
                fg[i][j] = Math.max(0, Math.round((float)(levelsOfIntents*fa)/dimen) -1);
            }
        }
        BufferedImage newImage = new BufferedImage(columns, rows, BufferedImage.TYPE_INT_RGB);
        int red, green, blue;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // red
                red = fg[0][new Color(image.getRGB(j, i)).getRed()];
                green = fg[1][new Color(image.getRGB(j, i)).getGreen()];
                blue = fg[2][new Color(image.getRGB(j, i)).getBlue()];

                newImage.setRGB(j, i, new Color(red,green, blue).getRGB());
            }
        }
        return newImage;
    }
    public double [] getColors(Color color){
        double [] colors = new double[3];
        colors[0] = color.getRed();
        colors[1] = color.getGreen();
        colors[2] = color.getBlue();

        return colors;
    }

}
