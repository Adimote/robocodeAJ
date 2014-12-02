package jpml;
import java.util.HashMap;

/**
 * Knowledge:
 * Keeps track of the knowledge of the robot at the given time
 *
 */
public class Knowledge
{
	private	HashMap<String, RobotSnapshot> knownRobots;
	private jpml.PirateBot parentRobotReference;
	private AntiGravity antigravity;

    public Knowledge(jpml.PirateBot parentRobot){
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
        Point myLocation = new Point(parentRobotReference.getX(), parentRobotReference.getY());
        double myHeading = parentRobotReference.getHeading();
        double offsetX = distance * Math.sin(bearing + myHeading);
        double offsetY = distance * Math.cos(bearing + myHeading);
        return new Point(myLocation.x+offsetX,myLocation.y+offsetY);
    }
	
	public Point calculateAntigravity(){
		return antigravity.getAntigravityForce(parentRobotReference.getX(), parentRobotReference.getY());
	}
	
	public jpml.PirateBot getParent(){
		return parentRobotReference;
	}
}

