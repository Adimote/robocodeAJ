package jpml;

/**
 * MyClass - a class by (your name here)
 */
public class Line
{
	private Point initialPoint;
	private double bearing;
	private int timeout;	

	public Line(Point initialPoint, double bearing, int timeout){
		this.initialPoint = initialPoint;
		this.bearing = bearing;
		this.timeout = timeout;
	}
	
	public Point getClosestPoint(Point myRobotPoint){
		double perpendicularBearing = Utils.normalRelativeAngle(bearing);
		
	}
	
	

}
