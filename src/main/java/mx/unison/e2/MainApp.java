package mx.unison.e2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainApp extends javax.swing.JFrame {
    Dibujo dibujo;
    public MainApp() {
        super("Dibujo");
        dibujo = new Dibujo();
        add(dibujo);
    }
    public static void main(String[] args) {
        /*
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainApp().show();
            }
        });*/
        MainApp m = new MainApp();
        m.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();
                switch (key) {
                    case 'i':
                    case 'I':
                        m.scaleUp();
                        break;
                    case 'o':
                    case 'O':
                        m.scaleDown();
                        break;
                }
            }
        });
        m.setSize(640, 480);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void scaleDown() {
        dibujo.scaleDown();
        repaint();
    }

    private void scaleUp() {
        dibujo.scaleUp();
        repaint();
    }
}
