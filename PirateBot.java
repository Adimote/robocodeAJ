package jpml;
import robocode.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.Random;

/**
 * PersonalSpaceInvader - a robot by JPML
 */
public class PirateBot extends AdvancedRobot
{
	private Knowledge k;
	private RandomRadar radar;
	private Wheels wheels;

	public void run() {

	}

	public void onScannedRobot(ScannedRobotEvent e) {
		radar.onScannedRobot(e);
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
