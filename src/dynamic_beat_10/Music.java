package dynamic_beat_10;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{  // 쓰레드란 하나의 작은프로그램, 프로그램안의 작은 프로그램임
	
	private Player player;	// Player가  다운받았던 라이브러리중하나
	private boolean isLoop;	// 현재 재생곡이 무한반복인지 아니면 꺼지는지 판단
	private File file; 
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());  // toURL로 해당파일의 위치를 가져올수있게한다 음악파일.
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop=false;
		player.close();
		this.interrupt(); // interrupt라는것은 해당 스레드 즉 곡을  중지상태로 만든다.
	}
	@Override
	public void run() {
		try {
			do {
				
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				player.play();
				
			}while (isLoop);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
