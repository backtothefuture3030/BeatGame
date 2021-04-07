package dynamic_beat_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame { // gui 프로그램을 하기위해 무조건 상속받아야하는 JFrame 이미 존재하는 라이브러리

	private Image screenImage; // 아래와 지금 두 인스턴스는 더블버퍼링을 위해서 전체화면에 대한 이미지를 담는것
	private Graphics screenGraphic;

	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	// Main 클래스의 위치를 기반으로 해서 image 파일안의 사진을 얻어온후 그것의 이미지 인스턴스를 background 변수안에
	// 넣어 초기화 시켜주겠다는 의미

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/MENUBAR.png")));
	// menu바 생성
	
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));	//종료버튼
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.jpg"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.jpg"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.jpg"));	
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.jpg"));	// 메뉴들
	
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));	
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));	// 게임안 화살표
	
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));	
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));	// 레벨표
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	
	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();	//어떠한 변수를 담을수있는 하나의 배열
	
	private Image titleImage ;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected =0;
	
	
	public DynamicBeat() { // 생성자
		setUndecorated(true); // 실행했을때 기본적으로 메뉴바가 보이지 않는다.
		setTitle("007 Bond Missons");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 화면 조정불가
		setLocationRelativeTo(null); // 게임창을 화면 정중앙에 놓게한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 종료했을때 프로그램 전체가 종료된다. 반드시필요!
		setVisible(true); // 게임창이 정상적으로 화면에 출력되도록하는것
		setBackground(new Color(0, 0, 0, 0)); // 아래에 paintComponents를 했을때 색이 전부 하얀색으로 나온다
		setLayout(null); // 이렇게 해주면 버튼이나, JLabel 같은걸 넣으면 그위치에 굳혀짐
		
		Music introMusic = new Music("INTROMUSIC.MP3", true); // 시작음악 설정
		introMusic.start();
		trackList.add(new Track("PrettySavage Title Image.png","PrettySavage Start Image.jpg",
				"PrettySavage Game Image.jpg","PrettySavage Selected.mp3","BlackPink-PrettySavage.mp3"));
		trackList.add(new Track("Skyfall Title Image.png","Skyfall Start Image.jpg",
				"Skyfall Game Image.jpg","Skyfall Selected.mp3","LeeHi-Skyfall.mp3"));
		trackList.add(new Track("Rose Title Image.png","Rose Start Image.jpg",
				"Rose Game Image.jpg","Rose Selected.mp3","LeeHi-Rose.mp3"));
		

		
		exitButton.setBounds(1232, 0, 50, 50);
		exitButton.setBorderPainted(false);		// 지금줄 포함 아래 두줄은 자신이 불러온사진 그대로 표현하게 하는것이다, 버튼모양을 커스텀할수있게 하는것.
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				try {			
					Thread.sleep(350);
				} catch(InterruptedException ex) {		// 종료 버튼 클릭후 바로꺼지는걸 방지하고자 만든 제어문
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		add(exitButton);
		
		startButton.setBounds(40,200, 400, 100);
		startButton.setBorderPainted(false);		// 지금줄 포함 아래 두줄은 자신이 불러온사진 그대로 표현하게 하는것이다, 버튼모양을 커스텀할수있게 하는것.
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				introMusic.close();
				selectTrack(0);

				startButton.setVisible(false); // 시작버튼을 안보이게 만든다
				quitButton.setVisible(false); // 종료버튼을 안보이게 만든다
				leftButton.setVisible(true); // 곡 넘기는 버튼은 보이게 만든다
				rightButton.setVisible(true); 
				easyButton.setVisible(true); // 레벨 버튼은 보이게 만든다
				hardButton.setVisible(true); 
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;

			}
		});
		
		add(startButton);
		
		quitButton.setBounds(40, 330,400, 100);
		quitButton.setBorderPainted(false);		// 지금줄 포함 아래 두줄은 자신이 불러온사진 그대로 표현하게 하는것이다, 버튼모양을 커스텀할수있게 하는것.
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				try {			
					Thread.sleep(350);
				} catch(InterruptedException ex) {		// 종료 버튼 클릭후 바로꺼지는걸 방지하고자 만든 제어문
					ex.printStackTrace();
				}
				System.exit(0);	//어차피 quit버튼은 종료기때문에 그대로 똑같이쓴다

			}
		});
		
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310,60, 60);
		leftButton.setBorderPainted(false);		// 지금줄 포함 아래 두줄은 자신이 불러온사진 그대로 표현하게 하는것이다, 버튼모양을 커스텀할수있게 하는것.
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				selectLeft();

			}
		});
		
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310,60, 60);
		rightButton.setBorderPainted(false);		// 지금줄 포함 아래 두줄은 자신이 불러온사진 그대로 표현하게 하는것이다, 버튼모양을 커스텀할수있게 하는것.
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				selectRight();

			}
		});
		
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375,580,250, 67);
		easyButton.setBorderPainted(false);		
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"easy");
				

			}
		});
		
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655,580,250, 67);
		hardButton.setBorderPainted(false);		
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("BUTTONENTEREDMUSIC.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("BUTTONPRESSEDMUSIC.mp3",false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"hard");
				

			}
		});
		
		add(hardButton);
		
		
		
		
		menuBar.setBounds(0, 0, 1280, 30); // 위치와 크기를 설정함
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {	// 마우스로 해당 객체를 눌렀을떄 일어나는 일
				mouseX=e.getX();
				mouseY=e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {	// 드래그있는데가 발생한곳에 내용 메뉴창을 드래그하면 화면이 움직임
				int x = e.getXOnScreen();	// 현재 화면에 x좌표
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);	// JFrame(게임창)의 위치를 바꿔준다
			}
			
			
		});
		add(menuBar); // JFrame의 menuBar가 추가가된다.

		


	}

	public void paint(Graphics g) { // paint는 JFrame을 상속받은 이러한 gui 게임에서 가장 첫번쨰로 화면을 그려주는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 일단 걍 틀만 짜놓는것 밑에 drawimage가 사진을 가져옴
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // screenDraw를 이용해서 화면을 그린다.
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // background를 즉 전체 screenImage에 그려줄수있도록 하는것.
		paintComponents(g); // 이미지를 단순하게 해당 screenImage변수안에 그려주는거 이외에 따로 메뉴바, JLabel같은것들을 그려준다, 메뉴바는 항상존재하는
							// 이미지라서 고정되야하므로 paintcomponet 이용
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 0, null);
		}
		
		this.repaint(); // repaint 함수로 다시 paint함수를 불러옴 즉 전체 화면 이미지를 매 순간마다 프로그램이 종료되는 순간까지 반복되면서 그려준다.
						// 그래야 안 버벅거림 '더블버퍼링'
	}
	

	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;  // 0번째 즉 첫번쨰 곡일때 왼쪽으로 누르게되면 가장 오른쪽으로 되는 곡이 선택된다.
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() { // 선택된 곡이 만약 가장 오른쪽에있는 곡이라면 첫번째 곡으로 이동하게 한다
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage())).getImage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
