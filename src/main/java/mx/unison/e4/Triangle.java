package mx.unison.e4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Triangle extends JComponent {

    // dimensiones del componente
    private Dimension preferredSize = null;

    // coordenadas del centro
    private int yCenter;
    private int xCenter;

    private final ArrayList<Shape> shapes;

    private final Color[] colors={Color.red,Color.green,Color.blue};

    public Triangle() {
        super();
        xCenter = getWidth() / 2;
        yCenter = getHeight() / 2;

        // Agregar formas básicas a dibujar
        shapes = new ArrayList<>();
        shapes.add(new Line2D.Double(270, 300, 370,300) );
        shapes.add(new Line2D.Double(320, 200, 370,300) );
        shapes.add(new Line2D.Double(270, 300, 320,200) );


    }
    public Triangle(int width, int height  ) {
        super();
        setPreferredSize(new Dimension(width, height));

        shapes = new ArrayList<>();
        shapes.add(new Line2D.Double(270, 300, 370,300) );
        shapes.add(new Line2D.Double(320, 200, 370,300) );
        shapes.add(new Line2D.Double(270, 300, 320,200) );

    }

    public Dimension getPreferredSize() {
        if (preferredSize == null) {
            return new Dimension(250, 100);
        } else {
            return super.getPreferredSize();
        }
    }

    public void setPreferredSize(Dimension newPrefSize) {
        preferredSize = newPrefSize;
        super.setPreferredSize(newPrefSize);
        xCenter = preferredSize.width / 2;
        yCenter = preferredSize.height / 2;
    }

    protected void paintComponent(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(getForeground());
        }

        Graphics2D g2 = (Graphics2D) g;
        // Definir ripo de linea para los ejes
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0, new float[]{9}, 0);

        // Cambiar tipo de linea
        g2.setStroke(dashed);

       // g2.draw(new Line2D.Double(xCenter, 0, xCenter,getHeight()) );
      //  g2.draw(new Line2D.Double(0, yCenter, getWidth(),yCenter) );

        g2.draw(new Line2D.Double(getWidth()/2, 0, getWidth()/2, getHeight()) );
        g2.draw(new Line2D.Double(0, getHeight()/2, getWidth(), getHeight()/2) );

        g2.setStroke(new BasicStroke(2));
        int i = 0;
        for (Shape shape : shapes) {
            g2.setColor(colors[i++]);
            g2.draw(shape);
        }

    }

    public void rotateClockwise() {
        for (Shape shape : shapes) {
            Line2D.Double line = (Line2D.Double) shape;
            Point p = Geometry.toPoint(line.getP1());
            Point q = Geometry.toPoint(line.getP2());

            Geometry.rotate(p, new Point(xCenter,yCenter) ,10.0);

            Geometry.rotate(q, new Point(xCenter,yCenter) ,10.0);
            line.setLine(p,q);
        }
        repaint();
    }
    public void rotateCountClockwise() {
        for (Shape shape : shapes) {
            Line2D.Double line = (Line2D.Double) shape;
            Point p = Geometry.toPoint(line.getP1());
            Point q = Geometry.toPoint(line.getP2());

            Geometry.rotate(p, new Point(xCenter,yCenter) ,-10.0);

            Geometry.rotate(q, new Point(xCenter,yCenter) ,-10.0);
            line.setLine(p,q);
        }
        repaint();
    }



    public static void main(String[] args) {
        JFrame f = new JFrame("Triangulo");
        Triangle t = new Triangle(640,480);
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                Logger.getGlobal().info("KEY");
                char key = e.getKeyChar();
                switch (key) {
                    case 'r':
                    case 'R':
                        t.rotateClockwise();
                        break;
                    case 'l':
                    case 'L':
                        t.rotateCountClockwise();
                        break;
            }
        }});

        JPanel p = new JPanel(new BorderLayout());
        p.add(t, BorderLayout.CENTER);

        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}
