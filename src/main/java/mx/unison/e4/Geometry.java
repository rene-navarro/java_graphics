package mx.unison.e4;

import java.awt.*;
import java.awt.geom.Point2D;

public class Geometry {


    public static Point toPoint(Point2D point2D) {
        int x = (int) point2D.getX();
        int y = (int) point2D.getY();
        return new Point(x,y);
    }



    public static double m(Point p, Point q) {
        double m = 0.0;

        m = (q.getY() - p.getY()) /
                (q.getX() - p.getX());

        return m;
    }

    public static double distance( Point p, Point q) {
         return p.distance(q);
    }

    public static double distance( double x1, double y1,
                                   double x2, double y2) {
        return Point.distance(x1,y1,x2,y2);
    }


    public static void rotate(Point point, double degrees) {
        double newX = point.getX() * Math.cos(Math.toRadians(degrees)) -
                point.getY() * Math.sin(Math.toRadians(degrees));

        double newY = point.getX() * Math.sin(Math.toRadians(degrees)) +
                point.getY() * Math.cos(Math.toRadians(degrees));

        point.setLocation(newX, newY);
    }

    // rotar punto p, con respecto al c
    public static void rotate(Point p, Point c, double degrees) {
        p.x -= c.x;
        p.y -= c.y;

        double newX = p.x * Math.cos( Math.toRadians(degrees) ) -
                p.y * Math.sin( Math.toRadians(degrees) );

        double newY = p.x * Math.sin( Math.toRadians(degrees) ) +
                p.y * Math.cos( Math.toRadians(degrees) );

        p.setLocation(newX+c.x, newY+c.y);
    }

    // rotar punto p, con respecto al c
    public static void rotation(Point p, Point c, double degrees) {

        double angle = Math.toRadians(degrees);
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        p.x -= c.x;
        p.y -= c.y;

        double newX = +p.x * cos - p.y * sin + c.x;

        double newY = +p.x *sin +  p.y * cos + c.y;
        p.setLocation(newX, newY);
    }
}
