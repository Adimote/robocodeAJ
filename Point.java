package jpml;

/**
 * Created by abs1g14 on 01/12/14.
 */
public class Point {
    double x=0,y=0;
    public Point(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(double x, double y) {
        return Math.sqrt((x*x)+(y*y));
    }
}
