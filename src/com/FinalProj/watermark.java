package MathematicalOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class watermark {



    private final BufferedImage image;

    public watermark (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage apply(){

        BufferedImage temp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics graphics = temp.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        graphics.setFont(new Font("Arial", Font.PLAIN, 80));
        graphics.setColor(new Color(255, 0, 0, 40));
        String watermark = "ABDUL RAZAQ";
        graphics.drawString(watermark, image.getWidth()/5, image.getHeight()/3);
        graphics.dispose();
        return temp;
    }

}
