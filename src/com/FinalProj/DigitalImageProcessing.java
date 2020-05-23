package FrameComponent;


import MathematicalOperations.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DigitalImageProcessing extends JFrame  implements ActionListener {


     JMenuBar MB;
     JMenu M1, M2, M3, M4, m11SaveAs;
     JMenuItem V2Reset,m22Open, m33Save, m55Close,
            E1Brightness, E2Histogram, E3Binarization, E4Contrast,E5,
            E01Median, E03Range, V1HSL, H1, V3Undo,V4Redo ,jpg,gif, png,tif,bmp,tiff,jpeg;



    String fileType;



    JSplitPane splitPane1,LeftSplitPane ;
    JScrollPane LeftScrollPane, pictureScrollPane, ScrollPaneTop1, ScrollPaneBottom1;
    JLabel LabelOfSmallImage;

    //JPanel ChartPanel;
    public static JLabel LabelImageActual;





    public static BufferedImage bufferedOriginalImage = null;
    public static BufferedImage bufferedActualImage = null;
    public static BufferedImage bufferedActualImageCopy = null;


    public static boolean modeRGB = false;
    public static boolean modeGray = false;

    public static boolean modeRGBefore = false;
    public static boolean modeGrayBefore = false;


    public String pathImage;
    public ImagePixels originalImage = null;

    private static final long serialVersionUID = 1L;

    public DigitalImageProcessing(String Path) {

        initUI();
        initBufferedImage(Path);
        listeners();


        setTitle("Digital Image Processing");
        setSize(2000, 2000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

    }





    public void listeners(){
        ListenerKey listenerKey = new ListenerKey();
        this.addKeyListener(listenerKey);
        LabelImageActual.addKeyListener(listenerKey);
        LabelOfSmallImage.addKeyListener(listenerKey);
        MB.addKeyListener(listenerKey);
        M1.addKeyListener(listenerKey);
        V2Reset.addKeyListener(listenerKey);
        M2.addKeyListener(listenerKey);
    }


    public void initUI() {
        FrameComponent();
    }


    public void initBufferedImage(String path) {

        this.pathImage = path;
        this.originalImage = new ImagePixels(pathImage);
        bufferedOriginalImage = this.originalImage.getImg();
        bufferedActualImage = this.originalImage.getImg();
        bufferedActualImageCopy = bufferedActualImage;
        showImageOnlyOriginalImage();
        showImageOnlyImageActual();

        if(this.originalImage.getNumberOfChannels() == 3) {
            modeRGB = true;
        } else {
            modeGray = true;
        }

    }


    public void showImageOnlyOriginalImage(){
        int [] dimensions;
        dimensions = resizeOriginalImageToLabel(350,180);

        LabelOfSmallImage.setIcon(new ImageIcon(
                new ImageIcon(pathImage).getImage().getScaledInstance(dimensions[0],dimensions[1], Image.SCALE_DEFAULT)));
        LabelOfSmallImage.setHorizontalAlignment(SwingConstants.CENTER);
        LabelOfSmallImage.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void showImageOnlyImageActual(){
        LabelImageActual.setIcon(new ImageIcon(bufferedOriginalImage));
    }


    public int [] resizeOriginalImageToLabel(int widthLabel, int heightLabel){
        int percentage = 1;
        int widthOriginal = this.originalImage.getColumns();
        int heightOriginalImage = this.originalImage.getRows();
        int width = getNewSizeByPercentage(widthOriginal, percentage);
        int height = getNewSizeByPercentage(heightOriginalImage, percentage);
        int [] dimensions = new int [2];

        while(width < widthLabel && height < heightLabel){
            dimensions[0] = width;
            dimensions[1] = height;
            percentage = percentage + 1;
            width = getNewSizeByPercentage(widthOriginal, percentage);
            height = getNewSizeByPercentage(heightOriginalImage, percentage);
        }
        return dimensions;
    }


    public int getNewSizeByPercentage(int number, int percentage) {
        return (number * percentage) / 100;
    }



    public void FrameComponent() {

        this.MB = new JMenuBar();


        this.M1 = new JMenu("File");
        M1.setForeground(new Color(32, 135, 103));
        this.M2 = new JMenu("Edit");
        M2.setForeground(new Color(32, 135, 103));
        this.M3 = new JMenu("view");
        M3.setBackground(new Color(32, 135, 103));
        this.M4 = new JMenu("Help");
        M4.setBackground(new Color(32, 135, 103));

        this.MB.add(M1);
        this.MB.add(M2);
        this.MB.add(M3);
        this.MB.add(M4);


        this.m22Open = new JMenuItem("Open");
        this.m33Save = new JMenuItem("Save");
        m11SaveAs = new JMenu("Save Image As...");
        this.m55Close = new JMenuItem("Close");


        m22Open.addActionListener(this);
        m33Save.addActionListener(this);
        m55Close.addActionListener(this);


        this.M1.add(m22Open);
        this.M1.add(m33Save);
        M1.add(m11SaveAs);
        this.M1.add(m55Close);

        this.jpg = new JMenuItem("jpg");
        this.gif = new JMenuItem("gif");
        this.png = new JMenuItem("png");
        this.tif = new JMenuItem("tif");
        this.bmp = new JMenuItem("bmp");
        this.tiff = new JMenuItem("tiff");
        this.jpeg = new JMenuItem("jpeg");

        jpg.addActionListener(this);
        gif.addActionListener(this);
        png.addActionListener(this);
        tif.addActionListener(this);
        bmp.addActionListener(this);
        tiff.addActionListener(this);
        jpeg.addActionListener(this);

        this.m11SaveAs.add(jpg);
        this.m11SaveAs.add(gif);
        this.m11SaveAs.add(png);
        this.m11SaveAs.add(tif);
        this.m11SaveAs.add(bmp);
        this.m11SaveAs.add(tiff);
        this.m11SaveAs.add(jpeg);


        //Creating the MenuBar and adding components (Edit)
        this.E1Brightness = new JMenuItem("Brightness");
        this.E2Histogram = new JMenuItem("Histogram");
        this.E3Binarization = new JMenuItem("Binarization");
        this.E4Contrast = new JMenuItem("Contrast");
        this.E5 = new JMenu("Filters");

        E1Brightness.addActionListener(this);
        E2Histogram.addActionListener(this);
        E3Binarization.addActionListener(this);
        E4Contrast.addActionListener(this);

        this.M2.add(E1Brightness);
        this.M2.add(E2Histogram);
        this.M2.add(E3Binarization);
        this.M2.add(E4Contrast);
        this.M2.add(E5);

        this.E01Median = new JMenuItem("Median");
        this.E03Range = new JMenuItem("Range");
        E01Median.addActionListener(this);
        E03Range.addActionListener(this);

        this.E5.add(E01Median);
        this.E5.add(E03Range);

        //Creating the MenuBar and adding components (View)
        this.V1HSL = new JMenuItem("HSL");
        this.V2Reset = new JMenuItem("Reset");
        this.V3Undo = new JMenuItem("Undo");
        this.V4Redo = new JMenuItem("Redo");

        V1HSL.addActionListener(this);
        V2Reset.addActionListener(this);
        V3Undo.addActionListener(this);
        V4Redo.addActionListener(this);

        this.M3.add(V1HSL);
        this.M3.add(V2Reset);
        this.M3.add(V3Undo);
        this.M3.add(V4Redo);

        //Creating the MenuBar and adding components (Help)
        this.H1 = new JMenuItem("About");
        H1.addActionListener(this);
        this.M4.add(H1);
        this.add(MB);
        setJMenuBar(MB);


        /**********************************************************************/


        LabelOfSmallImage = new JLabel();
        LabelOfSmallImage.setBorder(  BorderFactory.createBevelBorder(BevelBorder.RAISED));
        LabelOfSmallImage.setBounds(895, 895, 660, 660);

        LabelImageActual = new JLabel();
        LabelImageActual.setBorder(  BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        //" In The Future" + "This Place is for Cross-Section" + "Chart of the Apply Operation" + " on the Image"

        JLabel testLabel = new JLabel("This Place is for Cross-Section" , SwingConstants.CENTER);
        testLabel.setFont(new Font("Times", Font.PLAIN, 14));
        testLabel.setText("This Place is for Cross-Section");



        //ChartPanel = new JPanel();
        testLabel.setBorder(  BorderFactory.createBevelBorder(BevelBorder.RAISED));
        testLabel.setFocusable(false);
        testLabel.setLayout(null);
        testLabel.setBounds(895, 895, 660, 660);


        LeftSplitPane = new JSplitPane();
        LeftSplitPane.setBackground(new Color(32, 135, 103));
        ScrollPaneTop1 = new JScrollPane(LabelOfSmallImage);
        ScrollPaneTop1.setBorder(BorderFactory.createTitledBorder("Original Image"));
        ScrollPaneTop1.setBackground(new Color(32, 135, 103));
        ScrollPaneBottom1 = new JScrollPane(testLabel);
        ScrollPaneBottom1.setBorder(BorderFactory.createTitledBorder("Operation Chart"));
        ScrollPaneBottom1.setBackground(new Color(32, 135, 103));
        LeftSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ScrollPaneTop1, ScrollPaneBottom1);
        LeftSplitPane.setOneTouchExpandable(true);
        LeftSplitPane.setDividerLocation(330);
        LeftScrollPane = new JScrollPane(LeftSplitPane);

        pictureScrollPane = new JScrollPane();
        pictureScrollPane.setViewportView(LabelImageActual);
        pictureScrollPane.setBackground(new Color(32, 135, 103));


        splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftScrollPane, pictureScrollPane );
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setDividerLocation(350);
        splitPane1.setBackground(new Color(24, 92, 71));

        Dimension minimumSize = new Dimension(100, 50);
        LeftScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);
        splitPane1.setPreferredSize(new Dimension(400, 200));

        add(splitPane1);

        /*****************************************************/

    }


    @Override
    public void actionPerformed(ActionEvent evt) {


        if(evt.getSource() == this.m22Open) {

            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("extensions jpg","jpg","gif", "png","tif","bmp","tiff","jpeg","All"));
            int n = chooser.showOpenDialog(null);
            if(n == JFileChooser.APPROVE_OPTION){
                int accept = JOptionPane.showConfirmDialog
                        (null,"You will lose everything, are you sure?","Close",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if( accept == JOptionPane.YES_OPTION){
                    File file = chooser.getSelectedFile();
                    initBufferedImage(file.getAbsolutePath());
                    ImagePixels imageOpened = new ImagePixels(file.getAbsolutePath());
                    int numBands = imageOpened.getNumberOfChannels();
                    if(numBands == 3){
                        modeRGB = true;
                        modeGray = false;
                    }
                    else{
                        modeRGB = false;
                        modeGray = true;
                    }
                    modeGrayBefore = false;
                    modeRGBefore = false;

                }
            }


        }
        else
        if(evt.getSource() == this.m33Save) {

            try {
                ImageIO.write(bufferedActualImage,"jpg",new File("Image.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        if(evt.getSource() == this.jpg) {


            File saveFile = new File("ImageName.jpg");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rval = chooser.showSaveDialog(null);
            if (rval == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();

                try {
                    ImageIO.write(bufferedActualImage, "jpg", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        else
        if(evt.getSource() == this.gif) {

            File saveFile = new File("ImageName.gif");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rval = chooser.showSaveDialog(null);
            if (rval == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();

                try {
                    ImageIO.write(bufferedActualImage, "gif", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }else
        if(evt.getSource() == this.png) {

            File saveFile = new File("ImageName.png");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rival = chooser.showSaveDialog(null);
            if (rival == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();

                try {
                    ImageIO.write(bufferedActualImage, "png", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }else
        if(evt.getSource() == this.bmp) {

            File saveFile = new File("ImageName.bmp");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rival = chooser.showSaveDialog(null);
            if (rival == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();


                try {
                    ImageIO.write(bufferedActualImage, "bmp", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }else
        if(evt.getSource() == this.tif) {

            File saveFile = new File("ImageName.tif");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rval = chooser.showSaveDialog(null);
            if (rval == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();

                try {
                    ImageIO.write(bufferedActualImage, "tif", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }else
        if(evt.getSource() == this.tiff) {

            File saveFile = new File("ImageName.tiff");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rval = chooser.showSaveDialog(null);
            if (rval == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();
                try {
                    ImageIO.write(bufferedActualImage, "tiff", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }else
        if(evt.getSource() == this.jpeg) {

            File saveFile = new File("ImageName.jpeg");
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rval = chooser.showSaveDialog(null);
            if (rval == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();

                try {
                    ImageIO.write(bufferedActualImage, "jpeg", saveFile);
                } catch (IOException ex) {
                    Logger.getLogger(DigitalImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        else
        if(evt.getSource() == this.V3Undo) {


        }
        else
        if(evt.getSource() == this.V4Redo) {


        }
        else
        if(evt.getSource() == this.V2Reset) {
            LabelImageActual.setIcon(new ImageIcon(bufferedOriginalImage));
            DigitalImageProcessing.bufferedActualImage = bufferedOriginalImage;
            bufferedActualImageCopy = bufferedOriginalImage;
            if(modeGrayBefore){
                modeGray = true;
            }
        }
        else

        if(evt.getSource() == this.E1Brightness) {
            Bright BT = new Bright();
        }
        else
        if(evt.getSource() == this.E2Histogram) {

            BufferedImage image = new Histogram11(bufferedActualImage).apply();
            bufferedActualImageCopy = bufferedActualImage;
            bufferedActualImage = image;
            LabelImageActual.setIcon(new ImageIcon(image));

        }
        else
        if(evt.getSource() == this.E3Binarization) {
            Binary bf = new Binary();
        }
        else
        if(evt.getSource() == this.E4Contrast) {
            BufferedImage bi = new Contrast(bufferedActualImage).contrast();
            LabelImageActual.setIcon(new ImageIcon(bi));
            DigitalImageProcessing.bufferedActualImage = bi;
        }
        else
        if(evt.getSource() == this.E01Median) {

            BufferedImage image = null;
            if(DigitalImageProcessing.modeRGB){
                image = new MedianFilter(DigitalImageProcessing.bufferedActualImage).applyToRGB();
            }
            else if(DigitalImageProcessing.modeGray){
                image = new MedianFilter(DigitalImageProcessing.bufferedActualImage).applyToGray();
            }
            bufferedActualImageCopy = bufferedActualImage;
            bufferedActualImage = image;
            LabelImageActual.setIcon(new ImageIcon(image));
        }
        else
        if(evt.getSource() == this.E03Range) {
            FilterRange RT = new FilterRange();
        }
        else
        if(evt.getSource() == this.V1HSL) {

                if(modeRGB){
                    BufferedImage bufferedImage = new HSL(bufferedActualImage).apply();
                    LabelImageActual.setIcon(new ImageIcon(bufferedImage));
                    bufferedActualImage = bufferedImage;
                    bufferedActualImageCopy = bufferedImage;
                    JOptionPane.showMessageDialog(null,"HSL Mode was Applied");
                }else{
                    JOptionPane.showMessageDialog(null,"Only Apply For RGB Images");
                }

        }
        else
        if(evt.getSource() == this.m55Close) {
            exit();
            System.exit(0);
        }
        else
        if(evt.getSource() == this.H1)
            JOptionPane.showMessageDialog(null, "         Image Processing \n\n Create by ABDUL RAZAAK ABDUL NABI \n\n Photonics Specialize \n\n IRAQ", "About Me", JOptionPane.INFORMATION_MESSAGE);
    }




    public void exit(){
        int option = JOptionPane.showConfirmDialog(null,
                "The changes will be lost, Are you sure?","Close",JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION){
            new LOGOProgram().setVisible(true);
            this.dispose();
        }
    }


    class ListenerKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            if((int)e.getKeyChar() == KeyEvent.VK_ESCAPE){
                exit();
            }
        }
        @Override
        public void keyPressed(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

}

