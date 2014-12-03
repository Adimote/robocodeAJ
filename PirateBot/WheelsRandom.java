package PirateBot;

import java.util.Random;

/**
 * Created by abs1g14 on 02/12/14.
 */
public class WheelsRandom extends Wheels {
    private Random random = new Random();

    public WheelsRandom(Knowledge k) {
        super(k);
    }

    @Override
    public void execute() {
        this.rotationRate = random.nextDouble()*360 - 180;
        this.forward = random.nextDouble()*6 - 3;
    }
}
