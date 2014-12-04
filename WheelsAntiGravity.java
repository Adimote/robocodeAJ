package PirateBot;

import robocode.util.Utils;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by abs1g14 on 02/12/14.
 */
public class WheelsAntiGravity extends Wheels {

    private Random random = new Random();
    private static double ROT_MULTIPLIER = 10;
    private static double VEL_MULTIPLIER = 7000;
    private Random r = new Random();

    private AntiGravity antiGravity ;
    private int reverseTimeout = 0;

    private boolean reverse = false;

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
        double reverseConstant = reverse ? Math.PI : 0;
        double angleoffset = Utils.normalRelativeAngle(
                motionVector.getHeading(k.getRobotParent().getHeadingRadians()+reverseConstant)
                        );


        double forwardsAmount = motionVector.getMagnitude();

        double forwards = forwardsAmount * VEL_MULTIPLIER / Math.abs(rotationRate);

        // Random dodging technique
        if (forwardsAmount < 0.003 && r.nextInt(10) > 1) {
            forwards += 5;
            OtherRobot enemy = k.getNearestRobot()._1;
            if (enemy != null) {
                double otherRobotBearing = new Point(x,y).cartesianToPolar(enemy.getPrediction(k.getTick()).getLocation())._1;
                angleoffset = Utils.normalRelativeAngle(otherRobotBearing-k.getRobotParent().getHeadingRadians() + Math.PI / 2 + reverseConstant);
            }
        }

        double rotationRate = angleoffset * ROT_MULTIPLIER;

        // Add reversing
        if (reverse) {
            forwards = -forwards;
        }

        reverseTimeout --;
        if (Math.abs(angleoffset) > Math.PI/2){
            reverseTimeout = 5;
            reverse = !reverse;
        }

        this.forward = forwards;
        this.rotationRate = rotationRate;

        //TODO make this random
        //TODO add automatic reversing
        //TODO add proper slowdown for moving
    }

}
