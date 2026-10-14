package mx.unison.basicos;

import java.awt.*;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circulo extends JPanel {
    public static final Logger LOG = Logger.getLogger(Circulo.class.getName());

    Dimension dimension;

    public Circulo() {
        super();
        dimension = new Dimension(640, 480);
    }
    public Circulo(int width, int height) {
        super();
        dimension = new Dimension(width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    public void paint(Graphics g) {
       LOG.info("paint");
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
        LOG.info("paintComponent");
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.drawRect(10, 10, 50, 50);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dibujo");
        frame.setSize(640,480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Circulo());
        frame.setResizable(false);
        frame.pack();
    }

}
