package PirateBot;

/**
 * Created by andy on 03/12/14.
 */
public class TurretSimple extends Turret {
    public TurretSimple(Knowledge k) {
        super(k);
    }

    @Override
    public void execute() {
        this.bulletPower = getBulletPower();
        this.rotationRate = getRotationSpeed();
    }

    public double getBulletPower() {
        return 0;
        //TODO this
    }

    public double getRotationSpeed() {
        return 0;
    }
}
