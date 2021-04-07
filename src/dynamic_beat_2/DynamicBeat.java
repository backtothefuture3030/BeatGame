package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame { //gui 프로그램을 하기위해 무조건 상속받아야하는 JFrame 이미 존재하는 라이브러리
	
	private Image screenImage;			// 아래와 지금 두 인스턴스는 더블버퍼링을 위해서 전체화면에 대한 이미지를 담는것
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	
	public DynamicBeat() {	//생성자  
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);	//화면 조정불가
		setLocationRelativeTo(null);	// 게임창을 화면 정중앙에 놓게한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 게임창을 종료했을때 프로그램 전체가 종료된다. 반드시필요!
		setVisible(true); //게임창이 정상적으로 화면에 출력되도록하는것 
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage(); 
		// Main 클래스의 위치를 기반으로 해서 image 파일안의 사진을 얻어온후 그것의 이미지 인스턴스를 introBackground 변수안에 넣어 초기화 시켜주겠다는 의미
	}
	
	public void paint(Graphics g) { // paint는 JFrame을 상속받은 이러한 gui 게임에서 가장 첫번쨰로 화면을 그려주는 함수
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);	// 일단 걍 틀만 짜놓는것 밑에 drawimage가 사진을 가져옴
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);	// screenDraw를 이용해서 화면을 그린다.
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);	// introBackground를 즉 전체 screenImage에 그려줄수있도록 하는것.
		this.repaint(); 	// repaint 함수로 다시 paint함수를 불러옴 즉 전체 화면 이미지를 매 순간마다 프로그램이 종료되는 순간까지 반복되면서 그려준다. 그래야 안 버벅거림 '더블버퍼링'
	}

}
