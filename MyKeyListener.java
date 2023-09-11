import javax.swing.*;
import java.awt.event.*;

public class MyKeyListener implements KeyListener {
    JLabel label;

    public MyKeyListener(JLabel label) {
        this.label = label;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        label.setText("Key pressed: ");
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        label.setText("Key released: ");
    }

    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        label.setText("Key typed: ");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Listener Example");
        JLabel label = new JLabel("Press a key");
        frame.add(label);
        frame.pack();
        frame.setSize(200,200);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new MyKeyListener(label));
    }
}

