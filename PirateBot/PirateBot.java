package PirateBot;
import robocode.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.Random;

/**
 * PirateBot, a robot based on +U_1F47B
 */
public class PirateBot extends RateControlRobot
{
	private Knowledge k;
	private Radar radar;
	private Turret turret;
	private Wheels wheels;

	/**
	 * Called once, put a while true loop in it
	 */
	public void run() {

		Knowledge k = new Knowledge(this);
		Radar radar = new RadarRandom(k);
		Turret turret = new TurretRandom(k);
		Wheels wheels  = new WheelsRandom(k);

		// Colour it up
		//TODO colour it up
		setColors(new Color(0, 255, 43),
				new Color(0, 100, 102),
				new Color(0, 255, 128));

		// Colour the bullets
		//TODO colour the bullets too
		setBulletColor(new Color(255, 0, 0));

		// Turn off all the fixed turning
		this.setAdjustGunForRobotTurn(true);
		this.setAdjustRadarForGunTurn(true);
		this.setAdjustGunForRobotTurn(true);

		while (true) {
			// tell them all to execute
			radar.execute();
			turret.execute();
			wheels.execute();

			// Set the rotations
			this.setTurnRate(wheels.getRotationRate());
			this.setRadarRotationRate(radar.getRotationRate());
			this.setGunRotationRate(turret.getRotationRate());

			// Do all the things
			this.execute();
		}

	}

	public void onScannedRobot(ScannedRobotEvent e) {
		k.onScannedRobot(e);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		printPirate("Been hit!");
	}
	
	public void onHitWall(HitWallEvent e) {
		printPirate("Bumped into a wall");
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		printPirate("I've hit someone");
	}
	
	public void onRobotDeath(RobotDeathEvent e) {
		printPirate("Killed someone");
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
		System.out.println("☠"+string+"☠");
	}
	
	public void onPaint(Graphics2D g){
		Random r = new Random();
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.setFont(new Font("Wingdings",Font.PLAIN,144));
		g.drawString(Character.toString('N'),(int)this.getX(),(int)this.getY());
	}
}