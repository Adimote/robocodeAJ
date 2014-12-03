package PirateBot;

/**
 * MyClass - a class by (your name here)
 */
public class RobotSnapshot
{
	private Point currentLocation;
	private double currentBearing;
	private double currentDistance;
	private double heading;
	private double velocity;
	private int tick;
	private boolean isActive;

	public RobotSnapshot(int tick, Point location, double heading, double velocity, double bearing, double distance) {
		this.tick = tick;
		this.currentLocation = location;
		this.heading = heading;
		this.velocity = velocity;
		this.currentBearing = bearing;
		this.currentDistance = distance;
	}
	
	public Point getLocation(){
		return currentLocation;
	}
	
	public Point setLocation(Point p){
		currentLocation = p;
		return currentLocation;
	}

	public double getBearing() {
		return this.currentBearing;
	}

	public double getDistance() {
		return this.currentDistance;
	}

	public boolean getActive(){
		return isActive;
	}
	
	public void setActive(boolean active){
		isActive = active;
	}

	/**
	 * Get the tick the snapshot was taken at
	 * @return the tick the snapshot was taken at
	 */
	public int getTick() {
		return tick;
	}

	public double getHeading() {
		return heading;
	}

	public double getVelocity() {
		return velocity;
	}
}
