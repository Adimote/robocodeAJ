package PirateBot;

import robocode.AdvancedRobot;
import robocode.util.Utils;

import java.util.Random;

/**
 * Created by andy on 03/12/14.
 */
public class TurretSimple extends Turret {
    public Random r = new Random();

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
        AdvancedRobot me = k.getRobotParent();
        double enemyBearing =  enemy.getPrediction(k.getTick()).getBearingFromNorth();
        if (Math.abs(Utils.normalRelativeAngle(enemyBearing - me.getGunHeadingRadians())) <= (Math.PI/36)) {
            return true;
        } else {
            return false;
        }

    }

    public double getRotationSpeed() {
        Tuple<OtherRobot,Double> otherRobot = k.getNearestRobot();
        AdvancedRobot me = k.getRobotParent();
        if (otherRobot._1 == null) {
            return 20;
        }
        double enemyBearing = new Point(me.getX(),me.getY()).cartesianToPolar(otherRobot._1.getPrediction(k.getTick()).getLocation())._1;
        return Utils.normalRelativeAngle(enemyBearing - me.getGunHeadingRadians())*30;
    }
}
