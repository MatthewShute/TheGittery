package gameStuff;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[120];
	public boolean one, two, three, four, five, six, seven, eight, nine, up, down, left, right, e, n, s, g, l, i, w, enter, space, esc;

	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		n = keys[KeyEvent.VK_N]; s = keys[KeyEvent.VK_S];
		g = keys[KeyEvent.VK_G]; l = keys[KeyEvent.VK_L];
		e = keys[KeyEvent.VK_E];
		enter = keys[KeyEvent.VK_ENTER]; space = keys[KeyEvent.VK_SPACE];
		esc = keys[KeyEvent.VK_ESCAPE];
		one = keys[KeyEvent.VK_1]; two = keys[KeyEvent.VK_2];
		three = keys[KeyEvent.VK_3]; four = keys[KeyEvent.VK_4];
		five = keys[KeyEvent.VK_5]; six = keys[KeyEvent.VK_6];
		seven = keys[KeyEvent.VK_7]; eight = keys[KeyEvent.VK_8];
		nine = keys[KeyEvent.VK_9]; i = keys[KeyEvent.VK_I];
		w = keys[KeyEvent.VK_W];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
