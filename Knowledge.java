package jpml;

import java.util.HashSet;

/**
 * MyClass - a class by (your name here)
 */
public class Knowledge
{

    private HashSet<RobotSnapshot> knownRobots;
    private PersonalSpaceInvader parentRobotReference;


    public Knowledge(PersonalSpaceInvader parentRobot){
        parentRobotReference = parentRobot;
    }
    
    public Point getMyLocation() {
        //TODO make this get the robot's location
        return new Point(0,0);
    }

    public double getMyBearing() {
        //TODO make this get the robot's bearing from north
        return 90;
    }
    public Point polarToCartesian(double distance,double bearing) {
        double offsetx = distance * Math.sin(Math.toRadians(bearing+getMyBearing()));
        double offsety = distance * Math.cos(Math.toRadians(bearing + getMyBearing()));
        return  new Point(getMyLocation().x+offsetx,getMyLocation().y+offsety);
    }
}
