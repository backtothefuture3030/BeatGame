package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {	// 전반적인 게임틀안에서 하나의 게임이 하나의 단위로 동작하므로 쓰레드를 이용해야한다.
	
	
	
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
	
	private Image blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
	
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
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}else {
				note.screenDraw(g);
			}
			
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
		g.drawImage(blueFlareImage, 320, 782, null);
		
	}
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumBig1.mp3",false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); 
	}
	
	
	@Override
	public void run() { 
		dropNotes(this.titleName);
		
	}
	public void close() {
		gameMusic.close();
		this.interrupt();	// 지금 실행되고있는 스레드 game을 종료시켜준다 
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("LeeHi-Skyfall") && difficulty.equals("Easy")) {
			int startTime=14000 - Main.REACH_TIME*1000;  // 처음시작을 약 4.46초로 마춤
			int gap = 125;	// 최소박자의 간격
			beats = new Beat[] {
					new Beat(2000, "Space"),
					new Beat(2750, "Space"),
					new Beat(3570, "Space"),
					new Beat(4390, "Space"),
					new Beat(5170, "Space"),
					new Beat(5880, "Space"),
					new Beat(6850, "Space"),
					new Beat(7570, "Space"),
					new Beat(8360, "S"),
					new Beat(8670, "D"),
					new Beat(9050, "F"),
					new Beat(9860, "J"),
					new Beat(10220, "K"),
					new Beat(10590, "L"),
					new Beat(11420, "S"),
					new Beat(11760, "D"),
					new Beat(12190, "F"),
					new Beat(13040, "S"),
					new Beat(13460, "D"),
					new Beat(13860, "F"),
					new Beat(14710, "J"),
					new Beat(15120, "K"),
					new Beat(15510, "L"),
					new Beat(16390, "S"),
					new Beat(16410, "D"),
					new Beat(16450, "F"),
					new Beat(17090, "J"),
					new Beat(17130, "K"),
					new Beat(17190, "L"),
					new Beat(17940, "Space"),
					new Beat(18730, "Space"),
					new Beat(19520, "J"),
					new Beat(20670, "K"),
					new Beat(20990, "L"),
					new Beat(21890, "S"),
					new Beat(22670, "D"),
					new Beat(23520, "F"),
					new Beat(24390, "Space"),
			};
		}
		else if(titleName.equals("LeeHi-Skyfall")&& difficulty.equals("Hard")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("BlackPink-PrettySavage")&& difficulty.equals("Easy")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(1770,"S"),
					new Beat(1830,"D"),
					new Beat(1860,"F"),
					new Beat(2200,"Space"),
					new Beat(2700,"Space"),
					new Beat(7040,"J"),
					new Beat(7070,"K"),
					new Beat(7240,"L"),
					new Beat(7460,"L"),
					new Beat(7790,"L"),
					new Beat(8200,"S"),
					new Beat(8260,"D"),
					new Beat(8390,"F"),
					new Beat(8610,"J"),
					new Beat(8970,"K"),
					new Beat(9370,"L"),
					new Beat(9820,"Space"),
					new Beat(10240,"S"),
					new Beat(10270,"J"),
					new Beat(10430,"D"),
					new Beat(10460,"K"),
					new Beat(10600,"F"),
					new Beat(10630,"L"),
					new Beat(10900,"D"),
					new Beat(10910,"K"),
					new Beat(11340,"S"),
					new Beat(11340,"J"),
					new Beat(12990,"S"),
					new Beat(13320,"D"),
					new Beat(13530,"F"),
					new Beat(13700,"D"),
					new Beat(14070,"F"),
					new Beat(14530,"K"),
					new Beat(14900,"L"),
					new Beat(15090,"K"),
					new Beat(15260,"J"),
					new Beat(15480,"K"),
					new Beat(15700,"L"),
					new Beat(16070,"Space"),
					new Beat(16490,"Space"),
					new Beat(16900,"F"),
					new Beat(16900,"S"),
					new Beat(16940,"L"),
					new Beat(16940,"D"),
					new Beat(16940,"J"),
					new Beat(16940,"K"),
					new Beat(17290,"F"),
					new Beat(17290,"L")
			};
		}
		else if(titleName.equals("BlackPink-PrettySavage")&& difficulty.equals("Hard")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("LeeHi-Rose")&& difficulty.equals("Easy")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("BlackPink-PrettySavage")&& difficulty.equals("Hard")) {
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
	public void judge(String input) {
		for(int i =0; i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
	
	
}
