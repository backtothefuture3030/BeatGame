package dynamic_beat_14test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	
	private int x,y =580-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED)*Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	
	public Note( String noteType) {
		if(noteType.equals("S")) {
			x=428;
		}
		else if(noteType.equals("D")) {
			x=532;
		}
		else if(noteType.equals("F")) {
			x=636;
		}
		else if(noteType.equals("Space")) {
			x=740;
		}
		else if(noteType.equals("J")) {
			x=944;
		}
		else if(noteType.equals("K")) {
			x=1048;
		}
		else if(noteType.equals("L")) {
			x=1152;
		}
		this.noteType=noteType;
		

	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage, x ,y, null);
		}
		else  {	// 스페이스바에서 쓰는 바
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null); // 두개만큼의 공간을 얻기위해 100을더해 연결
		}
	}
	
	public void drop() {
		y+=Main.NOTE_SPEED;
		if(y>620) {
			System.out.println("Miss");
			close();
		}
	}
	
	
	@Override
	public void run() {	//스레드가 실행되는 함수
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME); // 0.01초 멈추고 떨어뜨림
				}
				else {
					interrupt();
					break;
				}
				  
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
			

}
