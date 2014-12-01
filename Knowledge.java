package jpml;
import java.util.HashMap;

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

}
