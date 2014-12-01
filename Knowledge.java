package jpml;

/**
 * MyClass - a class by (your name here)
 */
public class Knowledge
{
	
	private	HashSet<RobotSnapshot> knownRobots;
	private PersonalSpaceInvader parentRobotReference;	


	public Knowledge(PersonalSpaceInvader parentRobot){
		parentRobotReference = parentRobot;
	}

}
