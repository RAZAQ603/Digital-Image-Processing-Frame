package MathematicalOperations;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;

public class Histogram11 {

    private final BufferedImage image;

    public Histogram11(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply(){

        int[][] histogram = new Histogram().histogram(image);


        int ThresholdRed;
        int ThresholdGreen;
        int ThresholdBlue;

        int size;
        int middle;
        ArrayList<ListHistogram> listRed = new ArrayList<>();
        ArrayList<ListHistogram> listGreen = new ArrayList<>();
        ArrayList<ListHistogram> listBlue = new ArrayList<>();

        for(int i = 120 ; i < 150 ; i++){
            listRed.add(new ListHistogram(i, histogram[0][i]));
            listGreen.add(new ListHistogram(i, histogram[1][i]));
            listBlue.add(new ListHistogram(i, histogram[2][i]));
        }

        listRed.sort(Comparator.comparingInt(ListHistogram::getValue));

        listGreen.sort(Comparator.comparingInt(ListHistogram::getValue));

        listBlue.sort(Comparator.comparingInt(ListHistogram::getValue));

        size = listRed.size();
        middle = size / 2;
        ThresholdRed = listRed.get(middle).getI();

        size = listGreen.size();
        middle = size / 2;
        ThresholdGreen = listGreen.get(middle).getI();

        size = listBlue.size();
        middle = size / 2;
        ThresholdBlue = listBlue.get(middle).getI();


        return new Binarization(image).apply(ThresholdRed, ThresholdGreen, ThresholdBlue);

    }

}


class ListHistogram{
    private final int i;
    private final int value;

    public ListHistogram(int i, int value) {
        this.i = i;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getValue() {
        return value;
    }

}
