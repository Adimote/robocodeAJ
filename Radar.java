package jpml;

import robocode.ScannedRobotEvent;

/**
 * Created by abs1g14 on 02/12/14.
 */
public abstract class Radar {

    private Knowledge k;
    private double rotationSpeed;

    public Radar(Knowledge k){
        this.k = k;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public abstract void execute();

}
