package jpml;

/**
 * MyClass - a class by (your name here)
 */
public class RobotSnapshot
{
	private String name;	
	private int bulletHits;
	private Point currentCoordinates;
	private boolean isActive;

	public Robot(String name, int priorBulletHits){
		this.name = name;
		bulletHits = priorBulletHits; 
	}
	
	public Point getLocation(){
		return currentCoordinates;
	}
	
	public Point setLocation(double x, double y){
		currentCoordinates.x = x;
		currentCoordinates.y = y;
	}

	public boolean getActive(){
		return isActive;
	}
	
	public void setActive(boolean active){
		isActive = active;
	}

}
