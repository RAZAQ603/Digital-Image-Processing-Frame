package FrameComponent;


import javax.swing.*;

public class Bright extends JFrame {


    BrightnessTools br= new BrightnessTools();

    public Bright() {

        setTitle("Brightness Tools");
        //setBackground(Color.BLACK);
        setSize(350, 450);
        add(br);
        setVisible(true);

    }
}
