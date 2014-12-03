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
        antiGravity = new AntiGravity(
            k.getRobotParent().getBattleFieldWidth(),
            k.getRobotParent().getBattleFieldHeight()
        );
    }

    @Override
    public void execute() {
        double x = k.getRobotParent().getX();
        double y = k.getRobotParent().getY();

        ArrayList<Point> robotLocations = new ArrayList<Point>();

        for (OtherRobot otherRobot : k.getKnownRobots().values()) {
            robotLocations.add(otherRobot.getPrediction(k.getTick()).getLocation());
        }
        Point motionVector = antiGravity.getAntigravityForce(robotLocations, x, y);
        double angleoffset = Utils.normalRelativeAngle(motionVector.getHeading(k.getRobotParent().getHeadingRadians()));

        this.rotationRate = angleoffset * ROT_MULTIPLIER;
        this.forward = motionVector.getMagnitude() * VEL_MULTIPLIER / Math.abs(rotationRate);
        //TODO make this random
        //TODO add automatic reversing
        //TODO add proper slowdown for moving
    }

}
