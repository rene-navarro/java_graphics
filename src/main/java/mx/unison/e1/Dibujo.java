package mx.unison.e1;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JPanel {

    public void paint(Graphics g) {
        System.out.println("paint");
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.fillOval(10, 10, 50, 50);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(10, 10, 50, 50);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        System.out.println("paintComponent");

        g2d.setColor(Color.BLACK);
        g2d.drawRect(10, 10, 50, 50);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dibujo");
        frame.setSize(640,480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Dibujo());
    }

}
