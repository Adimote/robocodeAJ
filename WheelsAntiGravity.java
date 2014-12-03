package PirateBot;

import robocode.util.Utils;

import java.util.ArrayList;

/**
 * Created by abs1g14 on 02/12/14.
 */
public class WheelsAntiGravity extends Wheels {

    private static double ROT_MULTIPLIER = 10;
    private static double VEL_MULTIPLIER = 8000;

    private boolean reverse = false;
    
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
        double x = k.getRobotParent().getX();
        double y = k.getRobotParent().getY();
        Point motionVector = antiGravity.getAntigravityForce(x, y);
        double angleoffset = Utils.normalRelativeAngle(motionVector.getHeading(k.getRobotParent().getHeadingRadians()));

        this.rotationRate = angleoffset * ROT_MULTIPLIER;
        this.forward = motionVector.getMagnitude() * VEL_MULTIPLIER / Math.abs(rotationRate);
    }

}
