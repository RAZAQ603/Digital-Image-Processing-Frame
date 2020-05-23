package com.FinalProj;



import FrameComponent.LOGOProgram;

import javax.swing.*;
import java.awt.*;

public class MainClassMain {



    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> {
        });
        EventQueue.invokeLater(() -> {
            var ex = new LOGOProgram();
            ex. setVisible(true);
        });
    }



}
