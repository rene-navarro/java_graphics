package mx.unison.basicos;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Canvas extends JComponent {

    public static final Logger LOG = Logger.getLogger(Canvas.class.getName());

    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 480;

    // Atributo para almacenar las medidas del canvas
    private Dimension medidas ;

    public Canvas() {
        super();
        this.medidas = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Canvas(int w, int h) {
        super();
        this.medidas = new Dimension(w, h);
    }

    // Método para establecer las medidas del canvas.
    // Siempre que se cambien las medidas, se debe llamar a revalidate() para que el
    // contenedor padre actualice su layout.
    public Dimension getPreferredSize() {
        return medidas ;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        LOG.info("Pintando componente");

        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Hola mundo", 10, 40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dibujo");

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Canvas());
        frame.setResizable(true);
        frame.pack();
    }

}
