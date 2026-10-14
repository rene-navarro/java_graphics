package mx.unison.transformaciones;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Sketch extends JPanel {

    public void paint(Graphics g) {
        System.out.println("paint");
        Graphics2D g2d = (Graphics2D) g;

         int yCenter  = 240;
         int xCenter = 320;

        int final_x = 20;
        int final_y = 20;

        double angle = 45;

        String text = "Hello World";

        g2d.setColor(Color.RED);
        g2d.fillRect(10, 10, 50, 50);
        g2d.setColor(Color.BLUE);
        g2d.drawRect(10, 10, 50, 50);
        g2d.drawString(text, 100, 100);

        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0, new float[]{9}, 0);

        // Cambiar tipo de linea
        g2d.setStroke(dashed);
        g2d.draw(new Line2D.Double(getWidth()/2, 0, getWidth()/2, getHeight()) );
        g2d.draw(new Line2D.Double(0, getHeight()/2, getWidth(), getHeight()/2) );
        g2d.setStroke(new BasicStroke(1));


        g2d.setColor(Color.MAGENTA);
        Rectangle2D r = g.getFontMetrics().getStringBounds(text, g);
        g2d.translate(final_x, final_y);
        g2d.rotate(Math.toRadians(angle));
        g2d.translate(-r.getCenterX(), -r.getCenterY());
        g2d.drawString(text, 100, 100);

        // Cambiar tipo de linea
        g2d.setStroke(dashed);
        g2d.draw(new Line2D.Double(getWidth()/2, 0, getWidth()/2, getHeight()) );
        g2d.draw(new Line2D.Double(0, getHeight()/2, getWidth(), getHeight()/2) );
        g2d.setStroke(new BasicStroke(1));
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dibujo");
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Sketch());
    }
}
