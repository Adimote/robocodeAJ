package PirateBot;

import java.util.ArrayList;

/**
 * Created by abs1g14 on 01/12/14.
 *
 * Usage:
 * AntiGravity ag = new AntiGravity(knownRobots)
 * ag.getAntigravityForce(parentRobotReference.getX(),parentRobotReference.getY())
 *
 */
public class AntiGravity {
    // Avoidance Multipliers
    private static final int OTHER_ROBOT_FORCE = 500;
    private static final int WALL_FORCE = 100;

    private double arenaHeight, arenaWidth;

    public AntiGravity(double arenaWidth, double arenaHeight) {
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
    }

    private class PointWithPower {
        Point point;
        int power;
        public PointWithPower(Point point, int power) {
            this.point = point;
            this.power = power;
        }
    }

    public Point getAntigravityForce(ArrayList<Point> otherRobots, Point point) {
        return getAntigravityForce(otherRobots, point.x, point.y);
    }

    private ArrayList<PointWithPower> getRobotPoints(ArrayList<Point> otherRobots) {
        ArrayList<PointWithPower> antiGravityPoints = new ArrayList<PointWithPower>();
        // Add all robots to the list
        for (Point robot : otherRobots) {
            antiGravityPoints.add(new PointWithPower(robot,OTHER_ROBOT_FORCE));
        }
        return antiGravityPoints;
    }

    public Point getAntigravityForce(ArrayList<Point> otherRobots, double x, double y) {
        double xForce=0, yForce=0;
        // Calculate forces for other Robots
        for (PointWithPower robotPoint: getRobotPoints(otherRobots)) {
            //calculates bearing and distance
            double absBearing = robotPoint.point.getHeading();
            double distance = robotPoint.point.distance(x,y);
            xForce -= (Math.sin(absBearing)*robotPoint.power) / (distance * distance);
            yForce -= (Math.cos(absBearing)*robotPoint.power) / (distance * distance);
        }

        // Calculate forces for Walls

        //East
        double east = WALL_FORCE/(x*x);
        xForce += east;
        //South
        double south = WALL_FORCE/(y*y);
        yForce += south;
        //North
        double north = WALL_FORCE/((arenaHeight-y)*(arenaHeight-y));
        yForce -= north;
        //West
        double west = WALL_FORCE/((arenaWidth-x)*(arenaWidth-x));
        xForce -= west;

        return new Point(xForce,yForce);
    }

}
