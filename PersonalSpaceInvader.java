package jpml;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.HashMap;
import java.awt.Graphics2D; 
import java.awt.Font;
import java.util.Random;

/**
 * PersonalSpaceInvader - a robot by JPML
 */
public class PersonalSpaceInvader extends AdvancedRobot
{

	private double previousRobotScannedDistance;
	private HashSet<String> detectedRobots;
	private HashMap<String, Integer> repressedTrauma;
	private boolean hasWon;	

	private Knowledge k;
	private Radar radar;
	private Wheels wheels;

	public void run() {
		setColors(new Color(163,73,164),Color.green,Color.yellow,new Color(163,73,164),new Color(163,73,164));
		k = new Knowledge();
		radar = new Radar(k);
		wheels = new Wheels(k);
		//detectedRobots = new HashSet<String>();
		repressedTrauma = new HashMap<String, Integer>();
		hasWon = false;
		try {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(getDataFile("brain.trauma")));
				String line;			
				while((line = br.readLine()) != null){
					String[] splitLine = line.split(",");
					repressedTrauma.put(splitLine[0],Integer.parseInt(splitLine[1]));
				}
			} finally {
				if(br!=null) br.close();
			}
		} catch(Exception e){
			//if head injury then amnesia
		}
		setAdjustRadarForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		turnRadarRightRadians(Math.PI * 2);
		while(true){
        	setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
			scan();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
			radar.onScannedRobot(e);
			boolean weakestEnemy = true;
			if(repressedTrauma.containsKey(e.getName())) for(String r : detectedRobots){
				if(!repressedTrauma.containsKey(r) || (!r.equals(e.getName()) && detectedRobots.contains(r) && repressedTrauma.get(r) < repressedTrauma.get(e.getName()))){
					weakestEnemy = false;
 					break;	
				}
			}
			if(weakestEnemy || !repressedTrauma.containsKey(e.getName())){
				double radarTurn = getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians();
		    	setTurnRadarRightRadians(Utils.normalRelativeAngle(radarTurn));
				double gunTurn = getHeadingRadians() + e.getBearingRadians() - getGunHeadingRadians();
				setTurnGunRightRadians(Utils.normalRelativeAngle(gunTurn));
				fire(Math.abs(1 - (e.getDistance() / getBattleFieldHeight())) * 3);
				//old code: turn directly towards the robot:
				//double botTurn = e.getBearingRadians();
				wheels.getNextMotion();
				/* more old code
				setTurnRightRadians(Utils.normalRelativeAngle(botTurn));
				if(e.getEnergy() < getEnergy() || previousRobotScannedDistance < e.getDistance()){
					setAhead(100);
				}else{
					if(getDistanceRemaining() >= 0 && (e.getDistance() > 20 || getEnergy() > 10)) setAhead(10);
				}
				*/
				previousRobotScannedDistance = e.getDistance(); 
			}
		}

	public void onHitByBullet(HitByBulletEvent e) {
		if(repressedTrauma.containsKey(e.getName())){
			repressedTrauma.put(e.getName(),repressedTrauma.get(e.getName())+1);
		}else{
			repressedTrauma.put(e.getName(),1);
		}
	}
	
	public void onHitWall(HitWallEvent e) {
		if(Math.abs(e.getBearingRadians()) < Math.PI){
			setTurnLeft(180);
			setAhead(100);
		}
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		if(e.getEnergy() >= getEnergy() || getEnergy() < 20){
			back(20);
		}
	}
	
	public void onRobotDeath(RobotDeathEvent e){
		if(detectedRobots.contains(e.getName())) {
			detectedRobots.remove(e.getName());
			System.out.println("Robot " + e.getName() + "'s death detected");
		}else{
			System.out.println("Unlisted robot " + e.getName() + "'s death detected");
		}
	}

	public void outputTrauma(){
		if(repressedTrauma.keySet().size() > 1){
		PrintStream w = null;
		try {
			w = new PrintStream(new RobocodeFileOutputStream(getDataFile("brain.trauma")));
			for(String s : repressedTrauma.keySet()){
				w.println(s + "," + repressedTrauma.get(s));
			}
		} catch (Exception e) {

		} finally {
			if (w != null) {
				w.close();
			}
		}
		}
	}

	public void onDeath(DeathEvent e){
		outputTrauma();
	}

	

	public void onWin(WinEvent e){
		hasWon = true;
		outputTrauma();
		setTurnRadarLeftRadians(Double.POSITIVE_INFINITY);
		setTurnGunRightRadians(Double.POSITIVE_INFINITY);
		turnLeftRadians(Double.POSITIVE_INFINITY);
		setAhead(Double.POSITIVE_INFINITY);
	}
	
	public void onBattleEnded(BattleEndedEvent e){
		getDataFile("brain.trauma").delete();
	}
	
	public void onPaint(Graphics2D g){
		//for(
		if(hasWon){
			for(int i=0;i<3;i++){
				Random r = new Random();
				g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
				g.setFont(new Font("Wingdings",Font.PLAIN,144));
				g.drawString(Character.toString('\uF0FF'),r.nextInt((int)getBattleFieldWidth()),r.nextInt((int)getBattleFieldHeight()));
			}
		}
	}
}
