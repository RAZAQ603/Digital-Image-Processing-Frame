package FrameComponent;





import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LOGOProgram extends JFrame {

    private  JPasswordField passwordField;
    private static final String OK = "ok";
    private int x, y;


    public LOGOProgram() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(passwordField);
        panel.setBackground(new Color(24, 92, 71));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        panel.setBorder(  BorderFactory.createBevelBorder(  BevelBorder.RAISED));
        panel.setDoubleBuffered(false);
        panel.setFocusable(false);
        panel.addMouseMotionListener(new   MouseMotionAdapter() {
            public void mouseDragged(  MouseEvent evt) {
                panelMouseDragged(evt);
            }
        });
        panel.addMouseListener(new   MouseAdapter() {
            public void mousePressed(  MouseEvent evt) {
                panelMousePressed(evt);
            }
        });

        //jLabel1.setIcon(new ImageIcon(getClass().getResource("/ImageLogo/T6.gif")));
        jLabel1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/ImageLogo/T6.gif")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));

        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this::passwordFieldImageActionPerformed);
        passwordField.addMouseListener(new   MouseAdapter() {
            public void mousePressed(  MouseEvent evt) {
                passwordFieldImageMousePressed(evt);
            }
            public void mouseReleased(  MouseEvent evt) {
                passwordFieldImageMouseReleased(evt);
            }
        });

        GroupLayout panelLayout = new   GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)  // Change the Gap between the two button
                                .addComponent(jLabel1,   GroupLayout.PREFERRED_SIZE, 389,   GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(  GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label,   GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                        .addComponent(passwordField,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 48, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addGroup(  GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addContainerGap(  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label,   GroupLayout.PREFERRED_SIZE, 20,   GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(passwordField,   GroupLayout.PREFERRED_SIZE, 20,   GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1,   GroupLayout.PREFERRED_SIZE, 343,   GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        GroupLayout layout = new   GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(panel,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                        .addComponent(panel,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                resetFocus();
            }
        });

        pack();
    }
    private void passwordFieldImageActionPerformed(  ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (OK.equals(cmd)) {
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("JPG","jpg","gif", "png","tif","bmp","tiff","jpeg","All"));
                int open = chooser.showOpenDialog(null);
                if(open == JFileChooser.APPROVE_OPTION){
                    try {
                        File file = chooser.getSelectedFile();
                        new DigitalImageProcessing(file.getCanonicalPath()).setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(LOGOProgram.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
            Arrays.fill(input, '0');
            passwordField.selectAll();
        }
    }
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect;
        char[] correctPassword = {'A', 'B', 'D', 'U', 'L', 'R', 'A', 'Z', 'A','Q'};
        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }
        Arrays.fill(correctPassword,'0');
        return isCorrect;
    }
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }






    private void panelMousePressed(MouseEvent evt) {
        this.x = evt.getX();
        this.y = evt.getY();
    }
    private void panelMouseDragged(MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - this.x, this.getLocation().y + evt.getY() - this.y);
    }

    private void passwordFieldImageMousePressed(  MouseEvent evt) {
        Object object = evt.getSource();
        if(object instanceof Component){
            ((Component)object).setForeground(new Color(4, 64, 243));
        }
    }
    private void passwordFieldImageMouseReleased(  MouseEvent evt) {
        Object object = evt.getSource();
        if(object instanceof Component){
            ((Component)object).setForeground(Color.BLACK);
        }
    }
}
