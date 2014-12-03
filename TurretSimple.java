package PirateBot;

import javax.print.attribute.standard.MediaSize;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by andy on 03/12/14.
 */
public class TurretSimple extends Turret {
    public TurretSimple(Knowledge k) {
        super(k);
    }

    @Override
    public void execute() {
        this.bulletPower = getBulletPower();
        this.rotationRate = getRotationSpeed();
    }

    /**
     * Get bullet power for the nearest robot.
     * @return
     */
    public double getBulletPower() {
        double distance = k.getNearestRobot()._2;
        return 500/distance; // choose better value for bullet power.
    }

    public double getRotationSpeed() {
        return 0;
    }
}
