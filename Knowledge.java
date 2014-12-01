package jpml;
import java.util.HashMap;

import java.util.HashSet;

/**
 * MyClass - a class by (your name here)
 */
public class Knowledge
{
	private	HashMap<String, RobotSnapshot> knownRobots;
	private PersonalSpaceInvader parentRobotReference;	

    public Knowledge(PersonalSpaceInvader parentRobot){
        parentRobotReference = parentRobot;
    }

	private RobotSnapshot getRobotSnapshot(String name){
		if(knownRobots.keySet().contains
	}

	public void updateRobotHits(String name, int hits){
		
	}

	public void updateRobotLocation(String name, double bearing, double distance){
		
	}

    public Point polarToCartesian(double distance,double bearing) {
        Point myLocation = new Point(parentRobotReference.getX(),parentRobotReference.getY());
        double myHeading = parentRobotReference.getHeading();
        double offsetX = distance * Math.sin(bearing + myHeading);
        double offsetY = distance * Math.cos(bearing + myHeading);
        return  new Point(myLocation.x+offsetX,myLocation.y+offsetY);
    }
}

