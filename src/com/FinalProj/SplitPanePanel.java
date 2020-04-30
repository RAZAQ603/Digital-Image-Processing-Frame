package com.FinalProj;






import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class SplitPanePanel extends JPanel implements ListSelectionListener {



    JLabel picture;
   // JList<String> list;
    JSplitPane splitPane1,LeftSplitPane ;
   // String[] imageNames = {"Bird", "Cat", "Dog", "Rabbit", "Pig", "dukeWaveRed"};
   JScrollPane LeftScrollPane, pictureScrollPane, toppScrollPane, bottommScrollPane;


    public SplitPanePanel(DigitalImageProcessing digitalImageProcessing) {
       // list = new JList<>(imageNames);
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //list.setSelectedIndex(0);
        //list.addListSelectionListener(this);

        //JScrollPane listScrollPane = new JScrollPane(list);

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

        //updateLabel(imageNames[list.getSelectedIndex()]);
    }


    /**
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        updateLabel(imageNames[list.getSelectedIndex()]);
    }


    protected void updateLabel(String name) {
        ImageIcon icon = createImageIcon("images/" + name + ".gif");
        picture.setIcon(icon);
        if (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }

    public JList<String> getImageList() {
        return list;
    }
     **/


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


