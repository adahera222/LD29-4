package com.ionprogramming.ld28.input;

import java.awt.event.KeyEvent;

public class Keys {
	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean canPunch = true;
	
	public static void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = true;
		}
	}


	public static void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = false;
		}
	}


	public static void keyTyped(KeyEvent e) {
		
	}
}
