package FrameComponent;


import MathematicalOperations.Binarization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;


class BinarizationTools extends JPanel {

    private JTextField txtBlue;
    private JTextField txtGreen;
    private JTextField txtRed;

    public BinarizationTools() {
        initComponents();
    }

    private void initComponents() {


        JPanel Panel1 = new JPanel();
        JLabel Label2 = new JLabel();
        JLabel Label1 = new JLabel();
        txtRed = new JTextField();
        JLabel Label5 = new JLabel();
        JLabel Label6 = new JLabel();
        txtBlue = new JTextField();
        txtGreen = new JTextField();

        setBackground(Color.BLACK);
        //setSize(350, 420);



        Label2.setFont(new Font("Times", Font.PLAIN, 18));
        Label2.setHorizontalAlignment(SwingConstants.CENTER);
        Label2.setText("Channel Binarization");

        Label1.setFont(new Font("Times", Font.PLAIN, 14));
        Label1.setText("Red Channel");


        Label5.setFont(new Font("Times", Font.PLAIN, 14));
        Label5.setText("Green Channel");

        Label6.setFont(new Font("Times", Font.PLAIN, 14));
        Label6.setText("Blue channel");


        txtRed.setHorizontalAlignment(JTextField.CENTER);
        txtBlue.setHorizontalAlignment(JTextField.CENTER);
        txtGreen.setHorizontalAlignment(JTextField.CENTER);



        JButton ApplyButton = new JButton();

        ApplyButton.setFont(new Font("Times", Font.PLAIN, 14));
        ApplyButton.setText("Apply");
        ApplyButton.setFocusPainted(false);
        ApplyButton.setFocusable(false);

        ApplyButton.addActionListener(this::ApplyButtonActionPerformed);



        GroupLayout Panel1Layout = new GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);


        Panel1Layout.setHorizontalGroup(
                Panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(Panel1Layout.createSequentialGroup()
                                                                .addComponent(Label1)
                                                                .addGap(24, 24, 24)
                                                                .addComponent(txtRed))
                                                        .addGroup(Panel1Layout.createSequentialGroup()
                                                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Label5)
                                                                        .addComponent(Label6))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtBlue)
                                                                        .addComponent(txtGreen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(44, 44, 44))
                                        .addGroup(GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                                                .addComponent(ApplyButton, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                .addGap(87, 87, 87))))
        );

        Panel1Layout.setVerticalGroup(
                Panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Panel1Layout.createSequentialGroup()
                                .addComponent(Label2, GroupLayout.PREFERRED_SIZE, 49,GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Label1)
                                        .addComponent(txtRed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Label5)
                                        .addComponent(txtGreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Label6)
                                        .addComponent(txtBlue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(ApplyButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE))
        );


        GroupLayout layoutLayout = new GroupLayout(this);
        this.setLayout(layoutLayout);
        layoutLayout.setHorizontalGroup(
                layoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutLayout.setVerticalGroup(
                layoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }





    private void ApplyButtonActionPerformed(ActionEvent evt) {

        if(DigitalImageProcessing.modeGray){
            JOptionPane.showMessageDialog(null, "Only applicable to RGB");
            return;
        }
        String ThresholdRedString = txtRed.getText();
        String ThresholdGreenString = txtGreen.getText();
        String ThresholdBlueString = txtBlue.getText();
        if(ThresholdRedString.equals("")){
            ThresholdRedString = "130";
        }
        if(ThresholdGreenString.equals("")){
            ThresholdGreenString = "130";
        }
        if(ThresholdBlueString.equals("")){
            ThresholdBlueString = "130";
        }
        int ThresholdRed, ThresholdGreen, ThresholdBlue;
        try{
            ThresholdRed = Integer.parseInt(ThresholdRedString);
            ThresholdGreen = Integer.parseInt(ThresholdGreenString);
            ThresholdBlue = Integer.parseInt(ThresholdBlueString);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter Only Numbers");
            return;
        }
        if(ThresholdRed < 256 && ThresholdRed > -1 && ThresholdGreen < 256 && ThresholdBlue < 256 && ThresholdBlue > -1){
            BufferedImage image = new Binarization(DigitalImageProcessing.bufferedActualImage)
                    .apply(ThresholdRed,ThresholdGreen,ThresholdBlue);
            DigitalImageProcessing.LabelImageActual.setIcon(new ImageIcon(image));
            DigitalImageProcessing.bufferedActualImage = image;
        }
        else{
            JOptionPane.showMessageDialog(null, "Out Of Range");
        }
    }





}
