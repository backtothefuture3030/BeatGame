package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame { //gui 프로그램을 하기위해 무조건 상속받아야하는 JFrame 이미 존재하는 라이브러리
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);	// 게임창을 화면 정중앙에 놓게한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 게임창을 종료했을때 프로그램 전체가 종료된다. 반드시필요!
		setVisible(true); //게임창이 정상적으로 화면에 출력되도록하는것 
		
	}

}
