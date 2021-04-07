package dynamic_beat_14make;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {	// 전반적인 게임틀안에서 하나의 게임이 하나의 단위로 동작하므로 쓰레드를 이용해야한다.
	
	
	private boolean gameMaker=true; 
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
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle ) {
		this.titleName=titleName;
		this.difficulty=difficulty;
		this.musicTitle=musicTitle;
		gameMusic = new Music(this.musicTitle,false);
		
		
	}
	
	
	
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
		for(int i = 0; i<noteList.size();i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		
	
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //글자 깨짐방지
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString(titleName, 20, 702);	// 제목
		g.drawString(difficulty,1190,702);
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
		g.drawString("000000", 565, 702);	// 점수
		
	}
	public void pressS() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" S");
		}
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressD() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" D");
		}
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressF() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" F");
		}
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressSpace() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" Space");
		}
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumBig1.mp3",false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressJ() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" J");
		}
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressK() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" K");
		}
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressL() {
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime()+" L");
		}
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	
	
	@Override
	public void run() {
		dropNotes();
		
	}
	public void close() {
		gameMusic.close();
		this.interrupt();	// 지금 실행되고있는 스레드 game을 종료시켜준다 
	}
	
	public void dropNotes() {
		Beat beats[] = null;
		if(titleName.equals("LeeHi-SkyFall.mp3")) {
			int startTime=4460 - Main.REACH_TIME*1000;  // 처음시작을 약 4.46초로 마춤
			int gap = 125;	// 최소박자의 간격
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime+gap*2, "S"),
					new Beat(startTime+gap*4, "D"),
					new Beat(startTime+gap*6, "F"),
					new Beat(startTime+gap*8, "Space"),
					new Beat(startTime+gap*10, "J"),
					new Beat(startTime+gap*12, "K"),
					new Beat(startTime+gap*14, "L"),
					new Beat(startTime+gap*16, "Space")
			};
		}
		else if(titleName.equals("BlackPink-PrettySavage.mp3")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("LeeHi-Rose.mp3")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i =0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped =false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped=true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	}


	
	
	
	
	
	
	
	
}