package MathematicalOperations;






import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Collections;

public class MedianFilter {

    private final BufferedImage image;

    public MedianFilter(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage applyToRGB(){
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width - 2, height - 2, BufferedImage.TYPE_INT_RGB);
        int medianRed, medianGreen, medianBlue;
        ArrayList<Integer> listRed;
        ArrayList<Integer> listGreen;
        ArrayList<Integer> listBlue;

        for (int i = 1; i < height -1 ; i++) {
            for (int j = 1; j < width - 1; j++) {

                listRed = new ArrayList<>();
                listRed.add(new Color(image.getRGB(j-1, i-1)).getRed());
                listRed.add(new Color(image.getRGB(j, i-1)).getRed());
                listRed.add(new Color(image.getRGB(j+1,i-1)).getRed());
                listRed.add(new Color(image.getRGB(j-1, i)).getRed());
                listRed.add(new Color(image.getRGB(j, i)).getRed());
                listRed.add(new Color(image.getRGB(j+1,i)).getRed());
                listRed.add(new Color(image.getRGB(j-1,i+1)).getRed());
                listRed.add(new Color(image.getRGB(j, i+1)).getRed());
                listRed.add(new Color(image.getRGB(j+1,i+1)).getRed());

                Collections.sort(listRed);
                medianRed = listRed.get(4);

                listGreen = new ArrayList<>();
                listGreen.add(new Color(image.getRGB(j-1, i-1)).getGreen());
                listGreen.add(new Color(image.getRGB(j, i-1)).getGreen());
                listGreen.add(new Color(image.getRGB(j+1,i-1)).getGreen());
                listGreen.add(new Color(image.getRGB(j-1, i)).getGreen());
                listGreen.add(new Color(image.getRGB(j, i)).getGreen());
                listGreen.add(new Color(image.getRGB(j+1,i)).getGreen());
                listGreen.add(new Color(image.getRGB(j-1,i+1)).getGreen());
                listGreen.add(new Color(image.getRGB(j, i+1)).getGreen());
                listGreen.add(new Color(image.getRGB(j+1,i+1)).getGreen());

                Collections.sort(listGreen);
                medianGreen = listGreen.get(4);

                listBlue = new ArrayList<>();
                listBlue.add(new Color(image.getRGB(j-1, i-1)).getBlue());
                listBlue.add(new Color(image.getRGB(j, i-1)).getBlue());
                listBlue.add(new Color(image.getRGB(j+1,i-1)).getBlue());
                listBlue.add(new Color(image.getRGB(j-1, i)).getBlue());
                listBlue.add(new Color(image.getRGB(j, i)).getBlue());
                listBlue.add(new Color(image.getRGB(j+1,i)).getBlue());
                listBlue.add(new Color(image.getRGB(j-1,i+1)).getBlue());
                listBlue.add(new Color(image.getRGB(j, i+1)).getBlue());
                listBlue.add(new Color(image.getRGB(j+1,i+1)).getBlue());
                Collections.sort(listBlue);
                medianBlue = listBlue.get(4);
                newImage.setRGB(j-1, i-1, new Color(medianRed,medianGreen,medianBlue).getRGB());

            }
        }
        return newImage;
    }

    public BufferedImage applyToGray(){
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width-2, height-2, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster newImgRaster = newImage.getRaster();
        WritableRaster ImgRaster = image.getRaster();

        ArrayList<Integer> list;
        int median;

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width -1 ; j++) {
                list = new ArrayList<>();
                list.add(ImgRaster.getSample(j-1, i-1, 0));
                list.add(ImgRaster.getSample(j, i-1, 0));
                list.add(ImgRaster.getSample(j+1, i-1, 0));
                list.add(ImgRaster.getSample(j-1, i, 0));
                list.add(ImgRaster.getSample(j, i-1, 0));
                list.add(ImgRaster.getSample(j+1, i-1, 0));
                list.add(ImgRaster.getSample(j-1, i+1, 0));
                list.add(ImgRaster.getSample(j, i+1, 0));
                list.add(ImgRaster.getSample(j+1, i+1, 0));

                Collections.sort(list);
                median = list.get(4);

                newImgRaster.setSample(j-1, i-1,0, median);
            }
        }
        newImage.setData(newImgRaster);
        return newImage;
    }

}
