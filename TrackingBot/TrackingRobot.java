package TrackingBot;

import robocode.*;

import static robocode.util.Utils.normalRelativeAngleDegrees;

/**
 * Created by spd2g14 on 03/12/14.
 * To be used only for 1v1.
 */
public class TrackingRobot extends AdvancedRobot {
    String target;
    int turns = 0;
    double gunTurnAmount;

    public void run() {
        setAdjustGunForRobotTurn(true);
        //setAdjustRadarForGunTurn(true);
        //setAdjustRadarForRobotTurn(true);

        //turnGunRight(360);

        while (true) {
            turnGunRight(360);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        double power = 500/e.getDistance();
        fire(power);

        if (e.getDistance() > 150) {
            gunTurnAmount = normalRelativeAngleDegrees(getGunHeading() - getHeading() + e.getBearing());
            turnRight(e.getBearing());
            ahead(e.getDistance() - 80);
            setFire(power);
            turnGunRight(gunTurnAmount);

        }

        gunTurnAmount = normalRelativeAngleDegrees(getGunHeading() - getHeading() + e.getBearing());
        turnGunRight(gunTurnAmount);
        fire(power);

        scan();
    }

    @Override
    public void onHitWall(HitWallEvent w) {
        back(150);
    }

    @Override
    public void onHitRobot(HitRobotEvent h) {
        target = h.getName();
        gunTurnAmount = normalRelativeAngleDegrees(getGunHeading() - getHeading() + h.getBearing());
        turnGunRight(gunTurnAmount);
        fire(3);
        back(150);
    }

    //@Override
    /*public void onHitByBullet(HitByBulletEvent b) {
        double x=getX(), y=getY();
        setTurnLeft(30);
        back(100);
        if (x == getX() || y == getY()) {
            setTurnRight(60);
            ahead(200);
        }
    }*/
}
