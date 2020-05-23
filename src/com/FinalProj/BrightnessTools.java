package FrameComponent;





import MathematicalOperations.Brightness;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.ChangeEvent;





public class BrightnessTools extends JPanel {

    private JSlider sliderBlue;
    private JSlider sliderBright;
    private JSlider sliderGreen;
    private JSlider sliderRed;



    public BrightnessTools() {
        initComponents();
    }

    private void initComponents() {

        JPanel Panel1 = new   JPanel();
        JLabel Label2 = new   JLabel();
        sliderBright = new   JSlider();
        JLabel Label1 = new   JLabel();
        sliderRed = new   JSlider();
        JLabel Label3 = new   JLabel();
        sliderGreen = new   JSlider();
        JLabel Label4 = new   JLabel();
        sliderBlue = new   JSlider();
        JLabel Label5 = new   JLabel();


        setSize(350, 450);


        Label2.setFont(new   Font("Times", Font.PLAIN, 18));
        Label2.setHorizontalAlignment(  SwingConstants.CENTER);
        Label2.setText("Brightness");

        sliderBright.setMajorTickSpacing(50);
        sliderBright.setMaximum(200);
        sliderBright.setMinorTickSpacing(5);
        sliderBright.setPaintLabels(true);
        sliderBright.setPaintTicks(true);
        sliderBright.setToolTipText("");
        sliderBright.setValue(100);
        sliderBright.setFocusable(false);
        sliderBright.addChangeListener(this::BrightSliderStateChanged);

        Label1.setFont(new   Font("Times", Font.PLAIN, 18));
        Label1.setHorizontalAlignment(SwingConstants.CENTER);
        Label1.setText("RGB");

        sliderRed.setMajorTickSpacing(50);
        sliderRed.setMaximum(200);
        sliderRed.setMinorTickSpacing(5);
        sliderRed.setPaintLabels(true);
        sliderRed.setPaintTicks(true);
        sliderRed.setToolTipText("");
        sliderRed.setValue(100);
        sliderRed.setFocusable(false);
        sliderRed.addChangeListener(this::RedSliderStateChanged);

        Label3.setFont(new   Font("Times", Font.PLAIN, 18));
        Label3.setHorizontalAlignment(SwingConstants.CENTER);
        Label3.setText("RED");

        sliderGreen.setMajorTickSpacing(50);
        sliderGreen.setMaximum(200);
        sliderGreen.setMinorTickSpacing(5);
        sliderGreen.setPaintLabels(true);
        sliderGreen.setPaintTicks(true);
        sliderGreen.setToolTipText("");
        sliderGreen.setValue(100);
        sliderGreen.setFocusable(false);
        sliderGreen.addChangeListener(this::GreenSliderStateChanged);

        Label4.setFont(new   Font("Times", Font.PLAIN, 18));
        Label4.setHorizontalAlignment(SwingConstants.CENTER);
        Label4.setText("GREEN");

        sliderBlue.setMajorTickSpacing(50);
        sliderBlue.setMaximum(200);
        sliderBlue.setMinorTickSpacing(5);
        sliderBlue.setPaintLabels(true);
        sliderBlue.setPaintTicks(true);
        sliderBlue.setToolTipText("");
        sliderBlue.setValue(100);
        sliderBlue.setFocusable(false);
        sliderBlue.addChangeListener(this::BlueSliderStateChanged);

        Label5.setFont(new   Font("Times", Font.PLAIN, 18));
        Label5.setHorizontalAlignment(SwingConstants.CENTER);
        Label5.setText("BLUE");

        GroupLayout Panel1Layout = new   GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
                Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(Label2,   GroupLayout.Alignment.TRAILING,   GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGroup(Panel1Layout.createSequentialGroup()
                                .addGroup(Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                        .addGroup(Panel1Layout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addComponent(Label1,   GroupLayout.PREFERRED_SIZE, 75,   GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Panel1Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                                        .addComponent(sliderBright,   GroupLayout.PREFERRED_SIZE, 260,   GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sliderRed,   GroupLayout.PREFERRED_SIZE, 260,   GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sliderGreen,   GroupLayout.PREFERRED_SIZE, 260,   GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sliderBlue,   GroupLayout.PREFERRED_SIZE, 260,   GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(Panel1Layout.createSequentialGroup()
                                                                .addGap(93, 93, 93)
                                                                .addGroup(Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Label3,   GroupLayout.PREFERRED_SIZE, 75,   GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Label4,   GroupLayout.PREFERRED_SIZE, 75,   GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Label5,   GroupLayout.PREFERRED_SIZE, 75,   GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
                Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(Panel1Layout.createSequentialGroup()
                                .addComponent(Label2)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Label1,   GroupLayout.PREFERRED_SIZE, 29,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderBright,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Label3,   GroupLayout.PREFERRED_SIZE, 29,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderRed,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Label4,   GroupLayout.PREFERRED_SIZE, 29,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderGreen,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Label5,   GroupLayout.PREFERRED_SIZE, 29,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderBlue,   GroupLayout.PREFERRED_SIZE,   GroupLayout.DEFAULT_SIZE,   GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 31, Short.MAX_VALUE))
        );
        GroupLayout layoutLayout = new   GroupLayout(this);
        this.setLayout(layoutLayout);
        layoutLayout.setHorizontalGroup(
                layoutLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(Panel1,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutLayout.setVerticalGroup(
                layoutLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(Panel1,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void BrightSliderStateChanged(  ChangeEvent evt) {
        BufferedImage bufferedImage = new Brightness(this.sliderBright.getValue(),0).getNewImage();
        DigitalImageProcessing.LabelImageActual.setIcon(new ImageIcon(bufferedImage));
        DigitalImageProcessing.bufferedActualImage = bufferedImage;
        DigitalImageProcessing.bufferedActualImageCopy = bufferedImage;
    }
    private void RedSliderStateChanged(  ChangeEvent evt) {
        BufferedImage bufferedImage = new Brightness(this.sliderRed.getValue(),1).getNewImage();
        DigitalImageProcessing.LabelImageActual.setIcon(new ImageIcon(bufferedImage));
        DigitalImageProcessing.bufferedActualImage = bufferedImage;
        DigitalImageProcessing.bufferedActualImageCopy = bufferedImage;
    }
    private void GreenSliderStateChanged(  ChangeEvent evt) {
        BufferedImage bufferedImage = new Brightness(this.sliderGreen.getValue(),2).getNewImage();
        DigitalImageProcessing.LabelImageActual.setIcon(new ImageIcon(bufferedImage));
        DigitalImageProcessing.bufferedActualImage = bufferedImage;
        DigitalImageProcessing.bufferedActualImageCopy = bufferedImage;
    }
    private void BlueSliderStateChanged(  ChangeEvent evt) {
        BufferedImage bufferedImage = new Brightness(this.sliderBlue.getValue(),3).getNewImage();
        DigitalImageProcessing.LabelImageActual.setIcon(new ImageIcon(bufferedImage));
        DigitalImageProcessing.bufferedActualImage = bufferedImage;
        DigitalImageProcessing.bufferedActualImageCopy = bufferedImage;
    }
}
