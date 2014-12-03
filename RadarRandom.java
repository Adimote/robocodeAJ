package PirateBot;

import java.util.Random;

/**
 * MyClass - a class by (your name here)
 */
public class RadarRandom extends Radar
{
	private Random random = new Random();

	public RadarRandom(Knowledge k) {
		super(k);
	}

	@Override
	public void execute() {
		this.rotationRate = random.nextDouble()*360 - 180;
	}

}
