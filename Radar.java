package PirateBot;

import robocode.ScannedRobotEvent;
import robocode.util.Utils;

/**
 * Created by abs1g14 on 02/12/14.
 */
public abstract class Radar {

    protected Knowledge k;
    protected double rotationRate;

    public Radar(Knowledge k){
        this.k = k;
    }

    public double getRotationRate() {
        return rotationRate;
    }

    public abstract void execute();

}
