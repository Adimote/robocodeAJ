package jpml;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * MyClass - a class by (your name here)
 */
public class Knowledge
{
	private	HashMap<String, RobotSnapshot> knownRobots;
	private PersonalSpaceInvader parentRobotReference;
	private AntiGravity antigravity;

    public Knowledge(PersonalSpaceInvader parentRobot){
        parentRobotReference = parentRobot;
		knownRobots = new HashMap<String, RobotSnapshot>();
		antigravity = new AntiGravity(knownRobots, parentRobot.getBattleFieldWidth(), parentRobot.getBattleFieldHeight());
    }

	private RobotSnapshot getRobotSnapshot(String name){
		if(!knownRobots.keySet().contains(name)){knownRobots.put(name, new RobotSnapshot());}
		return knownRobots.get(name);
	}

	public void updateRobotHits(String name, int hits){
		getRobotSnapshot(name).setBulletHits(hits);
	}

	public void updateRobotLocation(String name, double bearing, double distance){
		getRobotSnapshot(name).setLocation(polarToCartesian(bearing, distance));
	}

    public Point polarToCartesian(double bearing,double distance) {
        Point myLocation = new Point(parentRobotReference.getX(),parentRobotReference.getY());
        double myHeading = parentRobotReference.getHeading();
        double offsetX = distance * Math.sin(bearing + myHeading);
        double offsetY = distance * Math.cos(bearing + myHeading);
        return new Point(myLocation.x+offsetX,myLocation.y+offsetY);
    }
	
	public Point calculateAntigravity(){
		return antigravity.getAntiGravityForce(parentRobotReference.x, parentRobotReference.y);
	}
	
	public PersonalSpaceInvader getParent(){
		return parentRobotReference;
	}
}

