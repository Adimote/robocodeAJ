package jpml;

import java.util.Random;

/**
 * Created by abs1g14 on 01/12/14.
 */
public class TurretRandom extends Turret {

    public TurretRandom(Knowledge k) {
        super(k);
    }

    public double getRotation() {
        Random random = new Random();
        return random.nextDouble()*360 - 180;
    }

    @Override
    public void execute() {

    }
}
