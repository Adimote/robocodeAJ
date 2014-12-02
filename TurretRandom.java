package jpml;

import java.util.Random;

/**
 * Created by abs1g14 on 01/12/14.
 */
public class TurretRandom extends Turret {

    private Random random = new Random();

    public TurretRandom(Knowledge k) {
        super(k);
        this.bulletPower = 3;

    }

    @Override
    public void execute() {
        this.rotation = random.nextDouble()*360 - 180;
    }
}
