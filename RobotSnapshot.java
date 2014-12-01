package jpml;

/**
 * MyClass - a class by (your name here)
 */
public class RobotSnapshot
{	
	private int bulletHits;
	private Point currentCoordinates;
	private boolean isActive;

	public RobotSnapshot(){
		bulletHits = 0; 
		isActive = true;
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
	
	public int getBulletHits(){
		return bulletHits;
	}
	
	public void setBulletHits(int hits){
		bulletHits = hits;
	}

}
