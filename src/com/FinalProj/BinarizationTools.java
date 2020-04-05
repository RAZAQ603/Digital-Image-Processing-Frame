package com.FinalProj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinarizationTools extends JFrame {


    public BinarizationTools(DigitalImageProcessing DigitalImageProcessing ) {

        setTitle("Binarization Tools");
        setSize(330, 350);
        JPanel Binary= new JPanel();
        add(Binary);
        JLabel Label2 = new JLabel();
        JLabel Label1 = new JLabel();
        JTextField txtRed = new JTextField();
        JLabel Label5 = new JLabel();
        JLabel Label6 = new JLabel();
        JTextField txtBlue = new JTextField();
        JTextField txtGreen = new JTextField();

        setPreferredSize(new Dimension(350, 420));
        Label2.setFont(new Font("Times", Font.PLAIN, 18)); // NOI18N
        Label2.setHorizontalAlignment(SwingConstants.CENTER);
        Label2.setText("Binarization");

        Label1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        Label1.setText("Red");

        Label5.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        Label5.setText("Green");

        Label6.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        Label6.setText("Blue");

        txtRed.setHorizontalAlignment(JTextField.CENTER);
        txtBlue.setHorizontalAlignment(JTextField.CENTER);
        txtGreen.setHorizontalAlignment(JTextField.CENTER);

        JButton Result = new JButton();
        //  Result.setBackground(new Color(207, 216, 220));
        Result.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        //  Result.setForeground(new Color(84, 110, 122));
        Result.setText("Result");
        Result.setFocusPainted(false);
        Result.setFocusable(false);
        Result.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ResultActionPerformed(evt);
            }
            private void ResultActionPerformed(ActionEvent evt) {
            }
        });

        GroupLayout Layout1 = new GroupLayout(Binary);
        Binary.setLayout(Layout1);

        Layout1.setHorizontalGroup(Layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, Layout1.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, Layout1.createSequentialGroup()
                                        .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(Layout1.createSequentialGroup()
                                                        .addComponent(Label1)
                                                        .addGap(17, 17, 17)
                                                        .addComponent(txtRed))
                                                .addGroup(Layout1.createSequentialGroup()
                                                        .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(Label5)
                                                                .addComponent(Label6))
                                                        .addGap(5, 5, 5)
                                                        .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtBlue)
                                                                .addComponent(txtGreen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
                                        .addGap(30, 30, 30))
                                .addGroup(GroupLayout.Alignment.TRAILING, Layout1.createSequentialGroup()
                                        .addComponent(Result, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))))
        );

        Layout1.setVerticalGroup(
                Layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout1.createSequentialGroup()
                                .addComponent(Label2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Label1)
                                        .addComponent(txtRed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Label5)
                                        .addComponent(txtGreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(Layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Label6)
                                        .addComponent(txtBlue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(Result, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
    }
}
