package PirateBot;

/**
 * Created by abs1g14 on 02/12/14.
 */
public abstract class Turret {
    protected Knowledge k;
    protected double bulletPower;
    protected double rotationRate;

    public Turret(Knowledge k){
        this.k = k;
    }

    public double getBulletPower() {
        return this.bulletPower;
    }

    public abstract void execute();

    public double getRotationRate() {
        return rotationRate;
    }
}
