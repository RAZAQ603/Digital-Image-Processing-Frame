package com.FinalProj;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

    public class BrightnessTools extends JFrame {

        public JSlider sliderBlue;
        public JSlider sliderBright;
        public JSlider sliderGreen;
        public JSlider sliderRed;

        public BrightnessTools(DigitalImageProcessing DigitalImageProcessing ) {

            setTitle("Binarization Tools");
            setSize(350, 450);
             JPanel Bright = new JPanel();
             add(Bright);
            JLabel Label22 = new JLabel();
            sliderBright = new JSlider();
            JLabel Label11 = new JLabel();
            sliderRed = new JSlider();
            JLabel Label3 = new JLabel();
            sliderGreen = new JSlider();
            JLabel Label4 = new JLabel();
            sliderBlue = new JSlider();
            JLabel Label55 = new JLabel();
            Label22.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            Label22.setHorizontalAlignment(SwingConstants.CENTER);
            Label22.setText("Brightness");
            sliderBright.setMajorTickSpacing(50);
            sliderBright.setMaximum(200);
            sliderBright.setMinorTickSpacing(5);
            sliderBright.setPaintLabels(true);
            sliderBright.setPaintTicks(true);
            sliderBright.setToolTipText("");
            sliderBright.setValue(100);
            sliderBright.setFocusable(false);

            sliderBright.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    sliderBrightStateChanged(e);
                }
                private  void sliderBrightStateChanged(ChangeEvent e){
                }
            });

            Label11.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Label11.setHorizontalAlignment(SwingConstants.CENTER);
            Label11.setText("RGB");
            sliderRed.setMajorTickSpacing(50);
            sliderRed.setMaximum(200);
            sliderRed.setMinorTickSpacing(5);
            sliderRed.setPaintLabels(true);
            sliderRed.setPaintTicks(true);
            sliderRed.setToolTipText("");
            sliderRed.setValue(100);
            sliderRed.setFocusable(false);

            sliderRed.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    sliderRedStateChanged(e);
                }
                private  void sliderRedStateChanged(ChangeEvent e){

                }
            });

            Label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
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

            sliderGreen.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    sliderGreenStateChanged(e);
                }
                private  void sliderGreenStateChanged(ChangeEvent e){
                }
            });

            Label4.setFont(new Font("Tahoma", Font.PLAIN, 18));
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

            sliderBlue.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    sliderBlueStateChanged(e);
                }
                private  void sliderBlueStateChanged(ChangeEvent e){
                }
            });
            Label55.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
            Label55.setHorizontalAlignment(SwingConstants.CENTER);
            Label55.setText("BLUE");

            GroupLayout Layout4 = new GroupLayout(Bright);
            Bright.setLayout(Layout4);
            Layout4.setHorizontalGroup(
                    Layout4.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(Label22, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addGroup(Layout4.createSequentialGroup()
                                    .addGroup(Layout4.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(Layout4.createSequentialGroup()
                                                    .addGap(136, 136, 136)
                                                    .addComponent(Label11, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Layout4.createSequentialGroup()
                                                    .addGap(43, 43, 43)
                                                    .addGroup(Layout4.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(sliderBright, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(sliderRed, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(sliderGreen, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(sliderBlue, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(Layout4.createSequentialGroup()
                                                                    .addGap(93, 93, 93)
                                                                    .addGroup(Layout4.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                            .addComponent(Label3,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(Label4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(Label55, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            Layout4.setVerticalGroup(
                    Layout4.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(Layout4.createSequentialGroup()
                                    .addComponent(Label22)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Label11, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderBright, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)

                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderRed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderGreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Label55, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderBlue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 31, Short.MAX_VALUE))
            );
        }
    }




