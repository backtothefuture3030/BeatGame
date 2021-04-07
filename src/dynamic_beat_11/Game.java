package dynamic_beat_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread {	// 전반적인 게임틀안에서 하나의 게임이 하나의 단위로 동작하므로 쓰레드를 이용해야한다.
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage(); // 판정바
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage(); // 게임바
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 428, 30, null);
		g.drawImage(noteRouteDImage, 532, 30, null);
		g.drawImage(noteRouteFImage, 636, 30, null);
		g.drawImage(noteRouteSpace1Image, 740, 30, null);	// 스페이스가 길게만들어져서 두개합쳐서 하려고
		g.drawImage(noteRouteSpace2Image, 840, 30, null);
		g.drawImage(noteRouteJImage, 944, 30, null);
		g.drawImage(noteRouteKImage, 1048, 30, null);
		g.drawImage(noteRouteLImage, 1152, 30, null);
		g.drawImage(noteRouteLineImage, 424, 30, null);
		g.drawImage(noteRouteLineImage, 528, 30, null);
		g.drawImage(noteRouteLineImage, 632, 30, null);
		g.drawImage(noteRouteLineImage, 736, 30, null);
		g.drawImage(noteRouteLineImage, 940, 30, null);
		g.drawImage(noteRouteLineImage, 1044, 30, null);
		g.drawImage(noteRouteLineImage, 1148, 30, null);
		g.drawImage(noteRouteLineImage, 1252, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		g.drawImage(noteBasicImage, 428, 120, null);
		g.drawImage(noteBasicImage, 532, 580, null);
		g.drawImage(noteBasicImage, 636, 500, null);
		g.drawImage(noteBasicImage, 740, 340, null);
		g.drawImage(noteBasicImage, 840, 340, null);
		g.drawImage(noteBasicImage, 944, 325, null);
		g.drawImage(noteBasicImage, 1048, 305, null);
		g.drawImage(noteBasicImage, 1152, 305, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //글자 깨짐방지
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("LeeHi - Skyfall", 20, 702);
		g.drawString("Easy",1190,702);
		g.setFont(new Font("Arial",Font.PLAIN,26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 472, 609);
		g.drawString("D", 576, 609);
		g.drawString("F", 678, 609);
		g.drawString("Space Bar", 782, 609);
		g.drawString("J", 986, 609);
		g.drawString("K", 1092, 609);
		g.drawString("L", 1194, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant",Font.BOLD,30));
		g.drawString("000000", 565, 702);

	}
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumBig1.mp3",false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	
	
	
	 
	
	
	@Override
	public void run() {
		
	}

	
	
	
	
	
	
	
	
}
