package PirateBot;
import robocode.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;

/**
 * PirateBot, a robot based on +U_1F47B
 */
public class PirateBot extends RateControlRobot
{
	private Knowledge k;
	private RadarSimple radar;
	private TurretSimple turret;
	private Wheels wheels;

	/**
	 * Called once, put a while true loop in it
	 */
	public void run() {

		printPirate("Started");

		k = new Knowledge(this);
		radar = new RadarSimple(k);
		turret = new TurretSimple(k);
		wheels = new WheelsAntiGravity(k);

		// Colour it up
		//TODO colour it up
		setColors(new Color(0, 255, 43),
				new Color(0, 100, 102),
				new Color(0, 255, 128));

		// Colour the bullets
		//TODO colour the bullets too
		setBulletColor(new Color(255, 0, 0));

		this.getOthers();

		// Turn off all the fixed turning
		this.setAdjustGunForRobotTurn(true);
		this.setAdjustRadarForGunTurn(true);
		this.setAdjustGunForRobotTurn(true);

		while (true) {
			// tell them all to execute
			k.execute();
			radar.execute();
			turret.execute();
			wheels.execute();

			// Set the rotations
			this.setRadarRotationRate(radar.getRotationRate());
			this.setGunRotationRate(turret.getRotationRate());
			this.setTurnRate(wheels.getRotationRate());
			this.setVelocityRate(wheels.getForward());

			//firing
			try {
				if (turret.canFire()) {
					fire(turret.getBulletPower());
				}
			} catch (NullPointerException e) {
				printPirate("No last robot snapshot.");
			}

			// moves set, execute them
			this.execute();
		}

	}

	public void onScannedRobot(ScannedRobotEvent e) {
		radar.onScannedRobot(e);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		printPirate("Been hit!");
//		wheels.randomMove(1);
	}
	
	public void onHitWall(HitWallEvent e) {
		printPirate("Bumped into a wall");
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		printPirate("I've hit someone");
	}
	
	public void onRobotDeath(RobotDeathEvent e) {
		radar.doRescan();
		printPirate("someone died");
	}

	public void onDeath(DeathEvent e){
		printPirate("I Died");
	}

	public void onWin(WinEvent e){
		printPirate("We won!");
	}
	
	public void onBattleEnded(BattleEndedEvent e){
		printPirate("Battle finished");
	}

	public void printPirate(String string) {
		System.out.println("☠ "+string+" ☠");
	}
	
	public void onPaint(Graphics2D g){
		g.setColor(new Color(255,0,0));
		g.setFont(new Font("Arial",Font.PLAIN,144));
		g.drawString(Character.toString('☠'),(int)this.getX()-30,(int)this.getY()-30);

		g.setFont(new Font("Arial",Font.PLAIN,44));
		Point nearestRobotLocation = k.getNearestRobot()._1.getLastSnapshot().getLocation();
		g.drawString(Character.toString('.'),(int)nearestRobotLocation.x,(int)nearestRobotLocation.y);
	}
}
