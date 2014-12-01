package jpml;

import java.util.ArrayList;
import java.util.HashMap;

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
    private static final int OTHER_ROBOT_FORCE = 5;
    private static final int WALL_FORCE = 10;


    private HashMap<String,RobotSnapshot> otherRobots;

    public AntiGravity(HashMap<String,RobotSnapshot> otherRobots) {
        this.otherRobots = otherRobots;
    }

    private class PointWithPower {
        Point point;
        int power;
        public PointWithPower(Point point, int power) {
            this.point = point;
            this.power = power;
        }
    }

    public Point getAntigravityForce(Point point) {
        return getAntigravityForce(point.x,point.y);
    }

    private ArrayList<PointWithPower> getRobotPoints(HashMap<String,RobotSnapshot> otherRobots) {
        ArrayList<PointWithPower> antiGravityPoints = new ArrayList<PointWithPower>();
        // Add all robots to the list
        for (String robotName : otherRobots.keySet()) {
            RobotSnapshot robot = otherRobots.get(robotName);
            Point robotLoc = robot.getLocation();
            antiGravityPoints.add(new PointWithPower(robotLoc,OTHER_ROBOT_FORCE));
        }
        return antiGravityPoints;
    }

    public Point getAntigravityForce(double x, double y) {
        double xForce=0, yForce=0;
        for (PointWithPower robotPoints: getRobotPoints(otherRobots)) {

        }

        return new Point(0,0);
    }

}
