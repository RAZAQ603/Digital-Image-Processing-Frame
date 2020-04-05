package com.FinalProj;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalImageProcessing extends JFrame {

    public JMenuBar MB;
    public JMenuItem V2Reset;
    public JMenu M1;
    public JMenu M2;
    public JMenu M3;
    public JMenuItem m11New;
    public JMenuItem m22Open;
    public JMenuItem m33Save;
    public JMenuItem m55Close;
    public JMenuItem E1Brightness;
    public JMenuItem E2Histogram;
    public JMenuItem E3Binarization;
    public JMenuItem E4Contrast;
    public JMenuItem E5;
    public JMenuItem E01Median;
    public JMenuItem E03Range;
    public JMenuItem V1HSL;
    public JMenuItem H1;
    public JPanel panel;
    public JPanel topPanel;
    public JPanel bottomPanel;
    public  JPanel panell;
    public JLabel ImageLabelOriginal;
    public JLabel MainLabel;


    public DigitalImageProcessing() {
        initUI();
    }

    public void initUI() {
        FrameComponent();
        setTitle("Digital Image Processing");
        setSize(2000, 2000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void FrameComponent() {

        //Creating the MenuBar and adding components (File)
         MB = new JMenuBar();
         M1 = new JMenu("File");
         M2 = new JMenu("Edit");
         M3 = new JMenu("view");
        JMenu M4 = new JMenu("Help");
        MB.add(M1);
        MB.add(M2);
        MB.add(M3);
        MB.add(M4);
         m11New = new JMenuItem("New");
         m22Open = new JMenuItem("Open");
         m33Save = new JMenuItem("Save");
         m55Close = new JMenuItem("Close");
        M1.add(m11New);
        M1.add(m22Open);
        M1.add(m33Save);
        M1.add(m55Close);
        //Creating the MenuBar and adding components (Edit)
         E1Brightness = new JMenuItem("Brightness");
         E2Histogram = new JMenuItem("Histogram");
         E3Binarization = new JMenuItem("Binarization");
         E4Contrast = new JMenuItem("Contrast");
         E5 = new JMenu("Filters");
        M2.add(E1Brightness);
        M2.add(E2Histogram);
        M2.add(E3Binarization);
        M2.add(E4Contrast);
        M2.add(E5);
         E01Median = new JMenuItem("Median");
         E03Range = new JMenuItem("Range");
        E5.add(E01Median);
        E5.add(E03Range);
        //Creating the MenuBar and adding components (View)
         V1HSL = new JMenuItem("HSL");
         V2Reset = new JMenuItem("Reset");
        M3.add(V1HSL);
        M3.add(V2Reset);
        //Creating the MenuBar and adding components (Help)
         H1 = new JMenuItem("About");
        M4.add(H1);
        setJMenuBar(MB);
        m55Close.addActionListener((event) -> System.exit(0));

        BinarizationTools bf = new BinarizationTools(this);
        E3Binarization.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                E3BinarizationActionPerformed(evt);
            }
            private void E3BinarizationActionPerformed(ActionEvent evt) {
                bf.setVisible(true);
            }
        });

        BrightnessTools BT = new BrightnessTools(this);
        E1Brightness.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                E1BrightnessActionPerformed(evt);
            }
            private void E1BrightnessActionPerformed(ActionEvent evt) {
                BT.setVisible(true);
            }
        });

        RangeFilterTools RT = new RangeFilterTools(this);
        E03Range.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                E03RangeActionPerformed(evt);
            }
            private void E03RangeActionPerformed(ActionEvent evt) {
                RT.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> {
        });
        EventQueue.invokeLater(() -> {

            var ex = new DigitalImageProcessing();
            ex. setVisible(true);
        });
    }
}
