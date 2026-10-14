package mx.unison.basicos;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class PlanoCartesiano extends JComponent {

    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 480;

    private Dimension medidas;
    private Point origen;

    public PlanoCartesiano() {
        super();
        this.medidas = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.origen = new Point(DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2);
    }

    public PlanoCartesiano(int w, int h) {
        super();
        this.medidas = new Dimension(w, h);
        this.origen = new Point(w / 2, h / 2);
    }

    @Override
    public Dimension getPreferredSize() {
        return medidas;
    }

    public Point getOrigen() {
        return new Point(origen.x, origen.y);
    }


    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Aquí puedes agregar el código para dibujar el plano cartesiano
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); // Eje X
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // Eje Y

        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i <= getWidth() / 2; i += 10) {
            g.drawLine(getWidth() / 2 + i, getHeight() / 2 - 5, getWidth() / 2 + i, getHeight() / 2 + 5); // Marcas positivas en X
            g.drawLine(getWidth() / 2 - i, getHeight() / 2 - 5, getWidth() / 2 - i, getHeight() / 2 + 5); // Marcas negativas en X

        }

        for (int i = 0; i <= getHeight() / 2; i += 10) {
            g.drawLine(getWidth() / 2 - 5, getHeight() / 2 + i, getWidth() / 2 + 5, getHeight() / 2 + i); // Marcas positivas en Y
            g.drawLine(getWidth() / 2 - 5, getHeight() / 2 - i, getWidth() / 2 + 5, getHeight() / 2 - i); // Marcas negativas en Y
        }

        g.setColor(Color.RED);
        Point origen = getOrigen();
        int x0 = origen.x;
        int y0 = origen.y;
        int y1 = y0;
        for(int x=0; x <= getWidth(); x += 2) {
            int y = (int) (Math.sin((x - x0) * 0.1) * 50 + y0);
            g.drawRect(x, y, 1, 1);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dibujo");

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PlanoCartesiano());
        frame.setResizable(true);
        frame.pack();
    }
}
