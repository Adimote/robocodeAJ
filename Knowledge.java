package PirateBot;
import robocode.ScannedRobotEvent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Knowledge:
 * Keeps track of the knowledge of the robot at the given time
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

	public void onScannedRobot(ScannedRobotEvent e){
		RobotSnapshot snapshot = new RobotSnapshot(
				tick,
				new Point(robotParent.getX(),robotParent.getY()).polarToCartesian(e.getBearingRadians(), e.getDistance(), robotParent.getHeadingRadians()),
				e.getHeading(),
				e.getVelocity(),
				e.getBearing(),
				e.getDistance()
		);
		getOtherRobot(e.getName()).addSnapshot(snapshot);
	}

	/**
	 * Tuple of closest OtherRobot and it's distance
	 * @return Tuple of closest OtherRobot and it's distance from the current location of PirateBot
	 */
	public Tuple<OtherRobot,Double> getNearestRobot() {
		Iterator it = getKnownRobots().entrySet().iterator();
		Double distance = 10000.0;
		OtherRobot closest = null;
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			OtherRobot enemy = (OtherRobot)pairs.getValue();
			RobotSnapshot lastEnemySnapshot = enemy.getPrediction(getTick());
			Point currentLocation = new Point(robotParent.getX(), robotParent.getY());
			double possibleMinDistance = currentLocation.distance(lastEnemySnapshot.getLocation());
			if (possibleMinDistance < distance) {
				distance = possibleMinDistance;
				closest = enemy;
			}
		}
		return new Tuple<OtherRobot, Double>(closest, distance);
	}



	public void execute() {
		tick ++;
		// Probably need to put stuff here.
	}
}

