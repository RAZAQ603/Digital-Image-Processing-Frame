package MathematicalOperations;





import java.awt.Color;
import java.awt.image.BufferedImage;

 class Histogram {

    public int[][] histogram(BufferedImage image){
        Color colorAuxiliary;

        int[][] histogramReturn =new int[3][256];
        for( int i = 0; i < image.getWidth(); i++ ){
            for( int j = 0; j < image.getHeight(); j++ ){
                colorAuxiliary=new Color(image.getRGB(i, j));

                histogramReturn[0][colorAuxiliary.getRed()]+=1;
                histogramReturn[1][colorAuxiliary.getGreen()]+=1;
                histogramReturn[2][colorAuxiliary.getBlue()]+=1;
            }
        }
        return histogramReturn;
    }
}