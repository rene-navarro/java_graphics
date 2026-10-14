package mx.unison.e1;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JPanel {

    Dimension dimension;

    public Dibujo() {
        super();
        dimension = new Dimension(640, 480);
    }
    public Dibujo(int width, int height) {
        super();
        dimension = new Dimension(width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    public void paint(Graphics g) {
        System.out.println("paint");
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar ciclo de 50 pixeles de diametro rojo relleno con borde azul
        g2d.setColor(Color.RED);
        g2d.fillOval(10, 10, 50, 50);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(10, 10, 50, 50);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent");
        Graphics2D g2d = (Graphics2D) g;


        g2d.setColor(Color.BLACK);
        g2d.drawRect(10, 10, 50, 50);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dibujo");
        frame.setSize(640,480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Dibujo());
        frame.setResizable(false);
        frame.pack();
    }

}
