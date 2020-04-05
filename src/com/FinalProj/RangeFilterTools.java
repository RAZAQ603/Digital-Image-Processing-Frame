package com.FinalProj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RangeFilterTools extends JFrame {

    public JButton Result;
    public JLabel title;
    public JTextField txtRange;

    public RangeFilterTools(DigitalImageProcessing DigitalImageProcessing )  {

        setTitle("Binarization Tools");
        setSize(350, 250);
        JPanel Range1 = new JPanel();
        add(Range1);
        title = new JLabel();
        txtRange = new JTextField();
        Result = new JButton();

        title.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Range Filter");
        title.setOpaque(true);

        txtRange.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtRange.setHorizontalAlignment(JTextField.CENTER);

        Result.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Result.setText("APPLY");
        Result.setFocusPainted(false);
        Result.setFocusable(false);

        Result.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ResultActionPerformed(evt);
            }
            private void ResultActionPerformed(ActionEvent evt) {
            }
        });

        GroupLayout Layout5 = new GroupLayout(Range1);
        Range1.setLayout(Layout5);
        Layout5.setHorizontalGroup(
                Layout5.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, Layout5.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRange, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))
                        .addGroup(Layout5.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(Result, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Layout5.setVerticalGroup(
                Layout5.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout5.createSequentialGroup()
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRange, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Result, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 269, Short.MAX_VALUE))
        );
    }
}
