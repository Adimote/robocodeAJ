package PirateBot;

import java.util.ArrayList;

/**
 * Created by andy on 03/12/14.
 */
public class OtherRobot {
    ArrayList<RobotSnapshot> snapshots = new ArrayList<RobotSnapshot>();

    public RobotSnapshot addSnapshot(RobotSnapshot snapshot) {
        snapshots.add(snapshot);
        return snapshot;
    }

    public RobotSnapshot getLastSnapshot() {
        return snapshots.get(snapshots.size()-1);
    }

    public RobotSnapshot getPrediction(int tick) {
        RobotSnapshot prediction = new RobotSnapshot(tick,predictLocation(),predictHeading(), predictVelocity(), predictBearingFromNorth(), predictDistance());
        return prediction;
    }

    private Point predictLocation() {
        //TODO make this predict.
        return getLastSnapshot().getLocation();
    }

    private double predictHeading() {
        //TODO make this predict.
        return getLastSnapshot().getHeading();
    }

    private double predictVelocity() {
        //TODO make this predict.
        return getLastSnapshot().getVelocity();
    }

    private double predictBearingFromNorth() {
        //TODO make this predict.
        return getLastSnapshot().getBearingFromNorth();
    }

    private double predictDistance() {
        //TODO make this predict.
        return getLastSnapshot().getDistance();
    }
}

