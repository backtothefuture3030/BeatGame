package dynamic_beat_14some;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game==null) {	// 게임이 실행중이지않는다면 어떠한 키보드를 눌러도 암것도없음 걍 리턴
			return;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) { // 현재 키 값이 S라면
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D) { 
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode()==KeyEvent.VK_F) { 
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) { 
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode()==KeyEvent.VK_J) { 
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode()==KeyEvent.VK_K) { 
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode()==KeyEvent.VK_L ) { 
			DynamicBeat.game.pressL();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {	// 키를 땠을때
		if(DynamicBeat.game==null) {	// 게임이 실행중이지않는다면 어떠한 키보드를 눌러도 암것도없음 걍 리턴
			return;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) { // 현재 키 값이 S라면
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D) { 
			DynamicBeat.game.releaseD();
		}
		else if(e.getKeyCode()==KeyEvent.VK_F) { 
			DynamicBeat.game.releaseF();
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) { 
			DynamicBeat.game.releaseSpace();;
		}
		else if(e.getKeyCode()==KeyEvent.VK_J) { 
			DynamicBeat.game.releaseJ();
		}
		else if(e.getKeyCode()==KeyEvent.VK_K) { 
			DynamicBeat.game.releaseK();
		}
		else if(e.getKeyCode()==KeyEvent.VK_L ) { 
			DynamicBeat.game.releaseL();
		}
	}

}
