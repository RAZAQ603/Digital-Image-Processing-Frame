package FrameComponent;






import MathematicalOperations.ImagePixels;
import MathematicalOperations.RangeFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class RangeFilterTools extends JPanel {

    private ImagePixels myImage;

    public RangeFilterTools() {
        initComponents();
    }


    private void initComponents() {

        JPanel Panel1 = new JPanel();
        JLabel title = new JLabel();
        txtRange = new  JTextField();
        JButton ApplyButton = new JButton();

        setPreferredSize(new Dimension(350, 420));


        title.setFont(new  Font("Times", Font.PLAIN, 18));
        title.setHorizontalAlignment(  SwingConstants.CENTER);
        title.setText("Filter Per Range");

        txtRange.setFont(new  Font("Times", Font.PLAIN, 14));
        txtRange.setHorizontalAlignment(  JTextField.CENTER);

        ApplyButton.setFont(new  Font("Times", Font.PLAIN, 12));
        ApplyButton.setText("APPLY");
        ApplyButton.setFocusPainted(false);
        ApplyButton.setFocusable(false);
        ApplyButton.addActionListener(this::ApplyButtonActionPerformed);

        GroupLayout Panel1Layout = new   GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
                Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(title,   GroupLayout.Alignment.TRAILING,   GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGroup(  GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRange,   GroupLayout.PREFERRED_SIZE, 160,GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))
                        .addGroup(Panel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(ApplyButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
                Panel1Layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(Panel1Layout.createSequentialGroup()
                                .addComponent(title,   GroupLayout.PREFERRED_SIZE, 49,   GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRange,   GroupLayout.PREFERRED_SIZE, 30,   GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ApplyButton, GroupLayout.PREFERRED_SIZE, 36,   GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 269, Short.MAX_VALUE))
        );


        GroupLayout layoutLayout = new   GroupLayout(this);
        this.setLayout(layoutLayout);
        layoutLayout.setHorizontalGroup(
                layoutLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(Panel1, GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutLayout.setVerticalGroup(
                layoutLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(Panel1, GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


    }


    private void ApplyButtonActionPerformed( ActionEvent evt) {
        BufferedImage image = new RangeFilter(DigitalImageProcessing.bufferedActualImage, Integer.parseInt(txtRange.getText())).applyToGray();
        DigitalImageProcessing.bufferedActualImage = image;
        DigitalImageProcessing.LabelImageActual.setIcon(new ImageIcon(image));
    }


    private JTextField txtRange;
}
