package FrameComponent;






import FrameComponent.RangeFilterTools;

import javax.swing.*;

public class FilterRange extends JFrame {


    RangeFilterTools rf= new RangeFilterTools();

    public FilterRange() {

        setTitle("FilterRange Tools");
        setSize(350, 250);
        add(rf);
        setVisible(true);

    }
}
