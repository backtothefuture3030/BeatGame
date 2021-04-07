  package dynamic_beat_14some;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	
	public static final int NOTE_SPEED= 3;
	public static final int SLEEP_TIME= 10;	// 엄청나게 빨리떨어지므로 sleep time을 만들어서 잠재워줌
	
	public static final int REACH_TIME=2;	//노트가 생성되고 판정바에 도달하는 시간

	public static void main(String[] args) {
		
		new DynamicBeat();

	}

}
 