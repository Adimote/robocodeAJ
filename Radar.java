package jpml;

/**
 * MyClass - a class by (your name here)
 */
public class Radar
{
	private Knowledge k;
	
	public Radar(Knowledge k){
		this.k = k;
	}
	 
	public onScannedRobot(ScannedRobotEvent e){
		k.updateRobot(e.getName(), e.getBearingRadians(), e.getDistance());
	}
	
}
