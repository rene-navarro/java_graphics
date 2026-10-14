package mx.unison.escalar;

import javax.swing.*;
import java.awt.*;

public class Dibujo extends JPanel {

    Dimension dimension;
    public static final int YCENTER = 240;
    public static final int XCENTER = 320;

    private final int radio;
    private double scaleFactor = 1.0;

    public Dibujo() {
        super();
        dimension = new Dimension(640, 480);
        radio = 50;
    }

    public Dibujo(int width, int height) {
        super();
        dimension = new Dimension(width, height);
        radio = 50;
    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    public void paint(Graphics g) {
        System.out.println("paint");
        Graphics2D g2d = (Graphics2D) g;

       int r = (int) (radio * scaleFactor);
        System.out.println(r);
        g2d.setColor(Color.RED);
        g2d.fillOval(10, 10, r, r);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(10, 10, r, r);
    }



    public static void main(String[] args) {

        JFrame frame = new JFrame("Dibujo");
        frame.setSize(640,480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(new Dibujo());
    }

    public void scaleUp() {
        scaleFactor = scaleFactor + 0.10;
    }

    public void scaleDown() {
        scaleFactor = scaleFactor - 0.10;
    }
}
