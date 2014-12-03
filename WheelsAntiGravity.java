package PirateBot;

import robocode.util.Utils;

import java.util.ArrayList;

/**
 * Created by abs1g14 on 02/12/14.
 */
public class WheelsAntiGravity extends Wheels {

    private AntiGravity antiGravity ;

    public WheelsAntiGravity(Knowledge k) {
        super(k);
        ArrayList<Point> robotLocations = new ArrayList<Point>();
        for (OtherRobot otherRobot : k.getKnownRobots().values()) {
            robotLocations.add(otherRobot.getPrediction(k.getTick()).getLocation());
        }

        antiGravity = new AntiGravity(
                robotLocations,
                k.getRobotParent().getBattleFieldWidth(),
                k.getRobotParent().getBattleFieldHeight()
            );
    }

    @Override
    public void execute() {
        Point motionVector = antiGravity.getAntigravityForce(k.getRobotParent().getX(),k.getRobotParent().getY());
        this.rotationRate = Utils.normalRelativeAngle(motionVector.getBearing());
        this.forward = motionVector.getMagnitude();
    }

}
