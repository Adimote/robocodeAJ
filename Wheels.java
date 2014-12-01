package jpml;

/**
 * MyClass - a class by (your name here)
 */
public class Wheels
{

	Knowledge k;	

	public Wheels(k){
		this.k = k;
	}

	public void doNextMotion(){
		Point motionVector = k.calculateAntigravity();
		setTurnRightRadians(Utils.normalRelativeAngle(motionVector.getBearing()));
		setAhead(botForward.getMagnitude());
	}

}
