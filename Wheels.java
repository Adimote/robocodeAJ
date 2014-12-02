package jpml;

import robocode.util.Utils;

/**
 * MyClass - a class by (your name here)
 */
public abstract class Wheels
{
	protected Knowledge k;
	protected double forward;
	protected double rotation;

	public Wheels(Knowledge k){
		this.k = k;
	}

	public double getNextForward() {
		return this.forward;
	}

	public double getNextRotation() {
		return this.rotation;
	}

	public abstract void execute();


}
