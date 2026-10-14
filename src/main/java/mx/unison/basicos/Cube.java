package mx.unison.basicos;



import javax.swing.*;
import java.awt.*;

public class Cube extends JPanel {

    public void paint(Graphics g) {
        System.out.println("paint");
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.drawLine(0,0,50,0);
        g2d.drawLine(0,0,0,50);
        g2d.drawLine(0,50,50,50);
        g2d.drawLine(50,0,50,50);

        g2d.setColor(Color.BLUE);
        g2d.drawLine(25,25,75,25);
        g2d.drawLine(25,25,25,75);
        g2d.drawLine(25,75,75,75);
        g2d.drawLine(75,25,75,75);

        g2d.setColor(Color.black);
        g2d.drawLine(0,0,25,25);
        g2d.drawLine(50,0,75,25);
        g2d.drawLine(0,50,25,75);
        g2d.drawLine(50,50,75,75);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cube");
        frame.setSize(640,480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Cube());
        frame.validate();
    }

}
