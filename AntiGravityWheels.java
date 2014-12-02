package jpml;

import robocode.util.Utils;

/**
 * Created by abs1g14 on 02/12/14.
 */
public class AntiGravityWheels extends Wheels {

    public AntiGravityWheels(Knowledge k) {
        super(k);
    }

    @Override
    public void execute() {
        Point motionVector = k.calculateAntigravity();
        this.rotation = Utils.normalRelativeAngle(motionVector.getBearing());
        this.forward = motionVector.getMagnitude();
    }

}
