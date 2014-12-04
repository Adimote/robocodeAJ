package PirateBot;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

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


    /**
     * Supposed to return true if the turret is pointing at the target which has just been scanned. +/- 5 degrees.
     * target is the nearest last known position of an enemy.
     * UNTESTED
     * @return true, if the turret is pointing at the enemy +/- 5 deg. false otherwise.
     */
    public boolean canFire() {
        OtherRobot enemy = k.getNearestRobot()._1;
        double enemyBearing =  enemy.getPrediction(k.getTick()).getBearing();
        if (Math.abs(Utils.normalAbsoluteAngle(k.getRobotParent().getGunHeadingRadians() - enemyBearing)) <= (Math.PI/36)) {
            return true;
        } else {
            return false;
        }

    }

    public double getRotationSpeed() {
        Tuple<OtherRobot,Double> otherRobot = k.getNearestRobot();
        if (otherRobot == null) {
            return 20;
        }
        double enemyBearing = otherRobot._1.getPrediction(k.getTick()).getBearing();
        AdvancedRobot me = k.getRobotParent();
        return enemyBearing-me.getGunHeading();
    }
}
