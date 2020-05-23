package MathematicalOperations;





import FrameComponent.DigitalImageProcessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Brightness {

    private final int Percentage;
    private final int Channel;

    public Brightness(int Percentage, int Channel) {
        this.Percentage = Percentage;
        this.Channel = Channel;
    }

    public BufferedImage getNewImage(){
        if(DigitalImageProcessing.modeRGB){
            switch (this.Channel) {
                case 0:
                    return brightRGB();
                case 1:
                    return  brightRed();
                case 2:
                    return  brightGreen();
                case 3:
                    return  brightBlue();
                default:
                    break;
            }
        }
        else{
            return brightGRAY();
        }
        return null;
    }

    private int calculateMoreBright(int color){
        int difference = 255 - color;
        return (difference * ( Percentage - 100 )) / 100;
    }

    private int calculateLessBright(int color){
        return (color * Percentage) / 100;
    }

    public BufferedImage brightRGB(){
        int width = DigitalImageProcessing.bufferedActualImage.getWidth();
        int height = DigitalImageProcessing.bufferedActualImage.getHeight();

        int r, g, b;
        int newColorR;
        int newColorG;
        int newColorB;
        Color color;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        if(Percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    newColorR = r + calculateMoreBright(r);

                    g = color.getGreen();
                    newColorG = g + calculateMoreBright(g);

                    b = color.getBlue();
                    newColorB = b + calculateMoreBright(b);

                    bufferedImage.setRGB(j ,i, new Color(newColorR, newColorG, newColorB).getRGB());

                }
            }
        }else if(Percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));

                    r = color.getRed();
                    newColorR = calculateLessBright(r);

                    g = color.getGreen();
                    newColorG = calculateLessBright(g);

                    b = color.getBlue();
                    newColorB = calculateLessBright(b);
                    bufferedImage.setRGB(j, i, new Color(newColorR, newColorG, newColorB).getRGB());
                }
            }
        }
        return bufferedImage;
    }


    public BufferedImage brightRed(){
        int width = DigitalImageProcessing.bufferedOriginalImage.getWidth();
        int height = DigitalImageProcessing.bufferedOriginalImage.getHeight();

        int r, g, b;
        int newColorR;
        Color color;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        if(Percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    newColorR = r + calculateMoreBright(r);

                    g = color.getGreen();
                    b = color.getBlue();

                    bufferedImage.setRGB(j ,i, new Color(newColorR, g, b).getRGB());
                }
            }
        }else if(Percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));

                    r = color.getRed();
                    newColorR = calculateLessBright(r);

                    g = color.getGreen();
                    b = color.getBlue();
                    bufferedImage.setRGB(j, i, new Color(newColorR, g, b).getRGB());
                }
            }
        }
        return bufferedImage;
    }

    public BufferedImage brightGreen(){
        int width = DigitalImageProcessing.bufferedActualImage.getWidth();
        int height = DigitalImageProcessing.bufferedActualImage.getHeight();

        int r, g, b;
        int newColorG;
        Color color;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        if(Percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    g = color.getGreen();
                    newColorG = g + calculateMoreBright(g);
                    b = color.getBlue();
                    bufferedImage.setRGB(j ,i, new Color(r, newColorG, b).getRGB());

                }
            }
        }else if(Percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));

                    r = color.getRed();
                    g = color.getGreen();
                    newColorG = calculateLessBright(g);
                    b = color.getBlue();
                    bufferedImage.setRGB(j, i, new Color(r, newColorG, b).getRGB());
                }
            }
        }
        return bufferedImage;
    }


    public BufferedImage brightBlue(){
        int width = DigitalImageProcessing.bufferedActualImage.getWidth();
        int height = DigitalImageProcessing.bufferedActualImage.getHeight();

        int r, g, b;
        int newColorB;
        Color color;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        if(Percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    g = color.getGreen();
                    b = color.getBlue();
                    newColorB = b + calculateMoreBright(b);

                    bufferedImage.setRGB(j ,i, new Color(r, g, newColorB).getRGB());

                }
            }
        }else if(Percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    color = new Color(DigitalImageProcessing.bufferedOriginalImage.getRGB(j, i));

                    r = color.getRed();
                    g = color.getGreen();
                    b = color.getBlue();
                    newColorB = calculateLessBright(b);
                    bufferedImage.setRGB(j, i, new Color(r, g, newColorB).getRGB());
                }
            }
        }
        return bufferedImage;
    }

    public BufferedImage brightGRAY(){

        int width = DigitalImageProcessing.bufferedActualImageCopy.getWidth();
        int height = DigitalImageProcessing.bufferedActualImageCopy.getWidth();

        int colorGray;

        WritableRaster writableRaster = DigitalImageProcessing.bufferedActualImageCopy.getRaster();
        BufferedImage bufferedNewImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster writableRasterNewImage = bufferedNewImage.getRaster();

        if(Percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    colorGray = writableRaster.getSample(j, i, 0);
                    colorGray = colorGray + calculateMoreBright(colorGray);
                    writableRasterNewImage.setSample(j, i, 0, colorGray);
                }
            }
        }else if(Percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < width ; j++){
                    colorGray = writableRaster.getSample(j, i, 0);
                    colorGray = calculateLessBright(colorGray);
                    writableRasterNewImage.setSample(j, i, 0, colorGray);
                }
            }
        }

        bufferedNewImage.setData(writableRasterNewImage);
        return bufferedNewImage;
    }
}

