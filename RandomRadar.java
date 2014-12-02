package jpml;

import robocode.ScannedRobotEvent;

import java.util.Random;

/**
 * MyClass - a class by (your name here)
 */
public class RandomRadar
{
	private Knowledge k;
	private Random random;

	public RandomRadar(Knowledge k){
		this.k = k;
	}

	public double getRotationSpeed() {
		return random.nextDouble()*360 - 180;
	}
	 
	public void onScannedRobot(ScannedRobotEvent e){
		k.updateRobotLocation(e.getName(), e.getBearingRadians(), e.getDistance());
	}
}
