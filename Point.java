package PirateBot;

import robocode.util.Utils;

/**
 * Created by abs1g14 on 01/12/14.
 */
public class Point {
    double x,y;
    public Point(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return distance(point.x,point.y);
    }

    public double distance(double x, double y) {
        double xd = this.x - x;
        double yd = this.y - y;
        return Math.sqrt((xd*xd)+(yd*yd));
    }

    public double getHeading(double angle) {
        return Utils.normalAbsoluteAngle(Math.atan2(this.x, this.y) - angle);
    }

    public double getHeading() {
        return Utils.normalAbsoluteAngle(Math.atan2(this.x, this.y));
    }

    public double getMagnitude() {
        return distance(0,0);
    }
}
