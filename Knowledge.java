package PirateBot;
import robocode.ScannedRobotEvent;

import java.util.HashMap;

/**
 * Knowledge:
 * Keeps track of the knowledge of the robot at the given time
 *
 */
public class Knowledge
{
	private	HashMap<String, OtherRobot> knownRobots;
	private PirateBot robotParent;
	private int tick = 0;

    public Knowledge(PirateBot parentRobot){
        robotParent = parentRobot;
		knownRobots = new HashMap<String, OtherRobot>();
    }

	public HashMap<String,OtherRobot> getKnownRobots() {
		return this.knownRobots;
	}

	public PirateBot getRobotParent(){
		return robotParent;
	}

	public int getTick() {
		return tick;
	}

	public OtherRobot getOtherRobot(String name) {
		// if it doesn't exist, add it.
		if (!knownRobots.containsKey(name)) {
			knownRobots.put(name, new OtherRobot());
		}
		return knownRobots.get(name);
	}

    public Point polarToCartesian(double bearing,double distance) {
        Point myLocation = new Point(robotParent.getX(), robotParent.getY());
        double myHeading = robotParent.getHeading();
        double offsetX = distance * Math.sin(bearing + myHeading);
        double offsetY = distance * Math.cos(bearing + myHeading);
        return new Point(myLocation.x+offsetX,myLocation.y+offsetY);
    }

	public void onScannedRobot(ScannedRobotEvent e){
		RobotSnapshot snapshot = new RobotSnapshot(
				tick,
				polarToCartesian(e.getBearing(), e.getDistance()),
				e.getHeading(),
				e.getVelocity()
		);
		getOtherRobot(e.getName()).addSnapshot(snapshot);
	}

	public void execute() {
		tick ++;
		// Probably need to put stuff here.
	}
}

