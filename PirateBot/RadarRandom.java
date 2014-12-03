package PirateBot;

import java.util.Random;

/**
 * MyClass - a class by (your name here)
 */
public class RadarRandom extends Radar
{
	private Random random;

	public RadarRandom(Knowledge k) {
		super(k);
	}

	@Override
	public void execute() {
		this.rotationRate = random.nextDouble()*360 - 180;
	}

}
