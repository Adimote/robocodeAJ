package PirateBot;

import robocode.ScannedRobotEvent;

/**
 * MyClass - a class by (your name here)
 */
public class RobotSnapshot
{
	private Point currentLocation;
	private double bearingFromNorth;
	private double currentDistance;
	private double heading;
	private double velocity;
	private int tick;
	private boolean isActive;
	private ScannedRobotEvent event;

	public RobotSnapshot(int tick, Point location, double heading, double velocity, double bearingFromNorth, double distance) {
		this.tick = tick;
		this.currentLocation = location;
		this.heading = heading;
		this.velocity = velocity;
		this.bearingFromNorth = bearingFromNorth;
		this.currentDistance = distance;
	}

	public RobotSnapshot(int tick, Point location, double heading, double velocity, double bearingFromNorth, double distance, ScannedRobotEvent event) {
		this(tick, location, heading, velocity, bearingFromNorth, distance);
		this.event = event;
	}

	public ScannedRobotEvent getEvent() {
		return event;
	}

	public Point getLocation(){
		return currentLocation;
	}
	
	public Point setLocation(Point p){
		currentLocation = p;
		return currentLocation;
	}

	public double getBearingFromNorth() {
		return this.bearingFromNorth;
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
