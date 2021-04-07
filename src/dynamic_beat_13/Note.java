package dynamic_beat_13;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	
	private int x,y =580-1000/Main.SLEEP_TIME*Main.NOTE_SPEED;
	private String noteType;
	
	public Note(int x, String noteType) {
		this.x = x;
		
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("short"))
		{
			g.drawImage(noteBasicImage, x ,y, null);
		}
		else if(noteType.equals("long")) {	// 스페이스바에서 쓰는 바
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null); // 두개만큼의 공간을 얻기위해 100을더해 연결
		}
	}
	
	public void drop() {
		y+=Main.NOTE_SPEED;
	}
	
	
	@Override
	public void run() {	//스레드가 실행되는 함수
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);  // 0.01초 멈추고 떨어뜨림
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
			

}
