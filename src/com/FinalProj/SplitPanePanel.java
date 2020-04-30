package com.FinalProj;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SplitPanePanel extends JPanel implements ListSelectionListener {
    
    JLabel picture;
    JSplitPane splitPane1,LeftSplitPane ;
   JScrollPane LeftScrollPane, pictureScrollPane, toppScrollPane, bottommScrollPane;
    public SplitPanePanel(DigitalImageProcessing digitalImageProcessing) {

        LeftSplitPane = new JSplitPane();
        toppScrollPane = new JScrollPane();
        toppScrollPane.setBorder(BorderFactory.createTitledBorder("Original Image"));
        bottommScrollPane = new JScrollPane();
        bottommScrollPane.setBorder(BorderFactory.createTitledBorder("Operation Chart"));
        LeftSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, toppScrollPane, bottommScrollPane );
        LeftSplitPane.setOneTouchExpandable(true);
        LeftSplitPane.setDividerLocation(330);

        LeftScrollPane = new JScrollPane(LeftSplitPane);

        picture = new JLabel("The Image That we will work on it");
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);

        pictureScrollPane = new JScrollPane(picture);



        splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftScrollPane, pictureScrollPane );
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setDividerLocation(350);


        Dimension minimumSize = new Dimension(100, 50);
        LeftScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);

        splitPane1.setPreferredSize(new Dimension(400, 200));

    }


    public JSplitPane getSplitPane() {
        return splitPane1;
    }



    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = SplitPanePanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}


