package PirateBot;

import robocode.AdvancedRobot;

/**
 * Created by abs1g14 on 02/12/14.
 */
public abstract class Turret {
    protected Knowledge k;
    protected double bulletPower;
    protected double rotationRate;

    public Turret(Knowledge k){
        this.k = k;
    }

    public double getBulletPower() {
        return this.bulletPower;
    }

    public boolean canFire() { return true; }

    public abstract void execute();

    public double getRotationRate() {
        Tuple<OtherRobot,Double> otherRobot = k.getNearestRobot();
        if (otherRobot == null) {
            return 20;
        }
        double enemyBearing = otherRobot._1.getPrediction(k.getTick()).getBearing();
        AdvancedRobot me = k.getRobotParent();
        return enemyBearing-me.getGunHeading();
    }
}
