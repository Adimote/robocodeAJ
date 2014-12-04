package PirateBot;

import robocode.ScannedRobotEvent;
import robocode.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by andy on 03/12/14.
 */
public class RadarSimple extends Radar {

    public RadarSimple(Knowledge k) {
        super(k);
    }

    private boolean rescan = false;
    private int rescanCount = 0;
    private HashSet<String> rescanMembers = new HashSet<String>();

    public void onScannedRobot(ScannedRobotEvent e){
        RobotSnapshot snapshot = new RobotSnapshot(
                k.getTick(),
                new Point(
                        k.getRobotParent().getX(),
                        k.getRobotParent().getY()
                ).polarToCartesian(
                        e.getBearingRadians(),
                        e.getDistance(),
                        k.getRobotParent().getHeadingRadians()
                ),
                e.getHeadingRadians(),
                e.getVelocity(),
                Utils.normalRelativeAngle(e.getBearingRadians() + k.getRobotParent().getHeadingRadians()),
                e.getDistance(),
                e
        );
        k.getOtherRobot(e.getName()).addSnapshot(snapshot);
        if (rescan) {
            rescanMembers.add(e.getName());
        }
    }

    public void doRescan() {
        this.rescan = true;
        this.rescanCount = 0;
    }

    public void removeDuplicates() {
        ArrayList<String> toRemove = new ArrayList<String>();
        for (String knownRobot : k.getKnownRobots().keySet()) {
            boolean found = false;
            for (String foundRobot : rescanMembers) {
                if (knownRobot.equals(foundRobot)) {
                    found = true;
                    break;
                }
            }
            if ( !found ) {
                toRemove.add(knownRobot);
            }
        }
        for (String s : toRemove) {
            k.getKnownRobots().remove(s);
        }
    }

    @Override
    public void execute() {
        if (this.rescan) {
            this.rotationRate = 45;
            if (this.rescanCount > 8) {
                this.rescanCount = 0;
                this.rescan = false;
                removeDuplicates();
            }
            this.rescanCount++;
        } else {
            // Put clever code here
            this.rotationRate = 45;
        }
    }
}
