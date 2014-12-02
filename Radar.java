package PirateBot;

/**
 * Created by abs1g14 on 02/12/14.
 */
public abstract class Radar {

    private Knowledge k;
    protected double rotationRate;

    public Radar(Knowledge k){
        this.k = k;
    }

    public double getRotationRate() {
        return rotationRate;
    }

    public abstract void execute();

}
