package MathematicalOperations;






import java.awt.Component;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePixels extends Component {
    private BufferedImage img;
    private int NoColumns;
    private int NoRows;
    private int numberOfChannels;

    public ImagePixels(String NameImage){
        try{
            img = ImageIO.read(new File(NameImage));
            convertImageMatrix();
        }
        catch (IOException ignored) {}
    }

    public ImagePixels(BufferedImage image){
        this.img = image;
        convertImageMatrix();
    }

    public void convertImageMatrix()
    {
        NoRows = img.getHeight();
        NoColumns = img.getWidth();

        double[][] matrixImage = new double[NoRows][NoColumns];
        double[][] matrixImage_R = new double[NoRows][NoColumns];
        double[][] matrixImage_G = new double[NoRows][NoColumns];
        double[][] matrixImage_B = new double[NoRows][NoColumns];
        double r;
        double g;
        double b;

        WritableRaster raster=img.getRaster();
        this.numberOfChannels =raster.getNumBands();

        for (int i=0;i<NoRows;i++){

            for(int j=0;j<NoColumns;j++){

                if (this.numberOfChannels == 3){
                    r=raster.getSampleDouble(j,i,0);
                    g=raster.getSampleDouble(j,i,1);
                    b=raster.getSampleDouble(j,i,2);

                    matrixImage[i][j]=(r+g+b)/3;
                    matrixImage_R[i][j]=r;
                    matrixImage_G[i][j]=g;
                    matrixImage_B[i][j]=b;
                }
                if (this.numberOfChannels == 1){
                    matrixImage[i][j]=raster.getSampleDouble(j,i,0);
                }
            }
        }
    }
    public BufferedImage convertMatrixGrayImage(double [][] Matrix){
        int High = Matrix.length;
        int Width = Matrix[0].length;

        BufferedImage image = new BufferedImage(Width,High,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = image.getRaster();

        for (int i=0;i<High;i++)
        {
            for(int j=0;j<Width;j++)
            {
                wr.setSample(j,i,0,Matrix[i][j]);
            }
        }
        image.setData(wr);

        return image;
    }
    public BufferedImage convertMatrixRGBImage(double [][]Matrix_R, double [][]Matrix_G, double [][]Matrix_B){

        BufferedImage image = new BufferedImage(Matrix_R[0].length,Matrix_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = image.getRaster();

        for (int i=0;i<Matrix_R.length;i++){
            for(int j=0;j<Matrix_R[0].length;j++){
                wr.setSample(j,i,0,Matrix_R[i][j]);
                wr.setSample(j,i,1,Matrix_G[i][j]);
                wr.setSample(j,i,2,Matrix_B[i][j]);
            }
        }
        image.setData(wr);
        return image;
    }

    public static void savePicture(double [][]Matrix, String path){
        BufferedImage imgNew = new BufferedImage(Matrix[0].length,Matrix.length,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = imgNew.getRaster();

        for (int i=0;i<Matrix.length;i++) {
            for(int j=0;j<Matrix[0].length;j++) {
                wr.setSample(j,i,0,Matrix[i][j]);
            }
        }
        imgNew.setData(wr);
        try {
            ImageIO.write(imgNew, "JPG", new File(path+".jpg"));
        }
        catch(IOException ignored){}
    }

    public static void savePicture(double [][]Matrix_R, double [][]Matrix_G, double [][]Matrix_B,String path) {
        BufferedImage img = new BufferedImage(Matrix_R[0].length,Matrix_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = img.getRaster();
        int i, j;

        for(i=0;i<Matrix_R.length;i++){
            for(j=0;j<Matrix_R[0].length;j++){
                wr.setSample(j,i,0,Matrix_R[i][j]);
                wr.setSample(j,i,1,Matrix_G[i][j]);
                wr.setSample(j,i,2,Matrix_B[i][j]);
            }
        }

        img.setData(wr);
        try{
            path = path + "\\im.jpg";
            ImageIO.write(img, "JPG", new File(path));
            System.out.println("-" + path);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public int getColumns() {
        return NoColumns;
    }
    public int getRows() {
        return NoRows;
    }
    public BufferedImage getImg() {
        return img;
    }
}
