package jpml;

import java.util.Random;

/**
 * Created by abs1g14 on 01/12/14.
 */
public class RandomTurret {
    private Knowledge k;
    private Random random;
    private double bulletPower = 3.0;
    private double rotation = 0;

    public RandomTurret(Knowledge k){
        this.k = k;
    }

    public double getBulletPower() {
        return this.bulletPower;
    }

    public double getRotation() {
        return random.nextDouble()*360 - 180;
    }
}
