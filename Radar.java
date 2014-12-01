package jpml;

import robocode.ScannedRobotEvent;

/**
 * MyClass - a class by (your name here)
 */
public class Radar
{
	private Knowledge k;

	public Radar(Knowledge k){
		this.k = k;
	}
	 
	public void onScannedRobot(ScannedRobotEvent e){
		k.updateRobotLocation(e.getName(), e.getBearingRadians(), e.getDistance());
	}
	
}
