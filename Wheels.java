package PirateBot;
import java.util.Random;

/**
 * MyClass - a class by (your name here)
 */
public abstract class Wheels
{
	protected Knowledge k;
	protected double forward;
	protected double rotationRate;
	private Random r = new Random();

	public Wheels(Knowledge k){
		this.k = k;
	}

	public double getForward() {
		return this.forward;
	}

	public double getRotationRate() {
		return this.rotationRate;
	}

	public void randomMove(int direction) {
		k.getRobotParent().setVelocityRate(10.0);
		k.getRobotParent().setTurnLeft(r.nextInt(30)+60.0);
		if (direction > 1) {
			k.getRobotParent().ahead(r.nextInt(150)+50.0);
		} else {
			k.getRobotParent().back(r.nextInt(150)+50.0);
		}
	}

	public abstract void execute();

}
