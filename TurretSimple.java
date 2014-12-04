package PirateBot;

import robocode.ScannedRobotEvent;

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

    public boolean canFire(ScannedRobotEvent e) {
        double enemyBearing = e.getBearing();
        if (Math.abs(k.getRobotParent().getGunHeading() - (k.getRobotParent().getHeading() + enemyBearing)) <= 5) {
            return true;
        } else {
            return false;
        }

    }

    public double getRotationSpeed() {
        return 10;
    }
}
