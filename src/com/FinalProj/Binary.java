package FrameComponent;



import javax.swing.*;

public class Binary extends JFrame {


     BinarizationTools bb= new BinarizationTools();

    public Binary() {

        setTitle("Binarization Tools");
        //setBackground(Color.BLACK);
        setSize(350, 420);
        add(bb);
        setVisible(true);

    }


}
