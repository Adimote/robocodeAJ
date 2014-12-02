package PirateBot;

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
	
	public Point setLocation(Point p){
		currentCoordinates = p;
		return currentCoordinates;
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
