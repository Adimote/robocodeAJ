package PirateBot;

/**
 * MyClass - a class by (your name here)
 */
public abstract class Wheels
{
	protected Knowledge k;
	protected double forward;
	protected double rotationRate;

	public Wheels(Knowledge k){
		this.k = k;
	}

	public double getForward() {
		return this.forward;
	}

	public double getRotationRate() {
		return this.rotationRate;
	}

	public abstract void execute();


}
