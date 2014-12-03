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
        target = null;

        while (true) {
            turnGunRight(360);
            turns ++;
            if (turns > 2) {
                turnGunLeft(10);
            }
            if (turns > 5) {
                turnGunRight(10);
            }
            if (turns > 12) {
                target = null;
                turns = 0;
                turnGunLeft(360);
            }
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        target = e.getName();
        System.out.println("Tracking "+e.getName());

        if (e.getDistance() > 150) {
            gunTurnAmount = normalRelativeAngleDegrees(getGunHeading() - getHeading() + e.getBearing());
            setTurnGunRight(gunTurnAmount);
            turnRight(e.getBearing());
            ahead(e.getDistance() - 100);
            return;
        }

        gunTurnAmount = normalRelativeAngleDegrees(getGunHeading() - getHeading() + e.getBearing());
        turnGunRight(gunTurnAmount);
        fire(1);

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
}
