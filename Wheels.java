package jpml;

import robocode.util.Utils;

/**
 * MyClass - a class by (your name here)
 */
public class Wheels
{

	Knowledge k;

	public Wheels(Knowledge k){
		this.k = k;
	}

	public void doNextMotion(){
		Point motionVector = k.calculateAntigravity();
		k.getParent().setTurnRightRadians(Utils.normalRelativeAngle(motionVector.getBearing()));
		k.getParent().setAhead(motionVector.getMagnitude());
	}

}
