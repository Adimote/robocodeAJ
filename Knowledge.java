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
		if(!knownRobots.keySet().contains(name)){knownRobots.put(name, new RobotSnapshot())}
		return knownRobots.get(name);
	}

	public void updateRobotHits(String name, int hits){
		getRobotSnapshot(name).setBulletHits(hits)
	}

	public void updateRobotLocation(String name, double bearing, double distance){
		getRobotSnapshot(name).setLocation(polarToCartesian(bearing, distance));
	}

    public Point polarToCartesian(double bearing,double distance) {
        double offsetx = distance * Math.sin(Math.toRadians(bearing+getMyBearing()));
        double offsety = distance * Math.cos(Math.toRadians(bearing + getMyBearing()));
        return  new Point(getMyLocation().x+offsetx,getMyLocation().y+offsety);
    }
}
