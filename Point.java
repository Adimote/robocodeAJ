package jpml;

import robocode.util.Utils;

/**
 * Created by abs1g14 on 01/12/14.
 */
public class Point {
    double x=0,y=0;
    public Point(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return distance(point.x,point.y);
    }

    public double distance(double x, double y) {
        return Math.sqrt((x*x)+(y*y));
    }

    public double getBearing() {
        return Utils.normalAbsoluteAngle(Math.atan2(this.x - x, this.y - y));
    }

    public double getMagnitude() {
        return distance(0,0);
    }
}
