package com.ionprogramming.ld28.input;

import java.awt.event.KeyEvent;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Player;
import com.ionprogramming.ld28.level.Levels;
import com.ionprogramming.ld28.level.Minimap;
import com.ionprogramming.ld28.sfx.Sounds;

public class Keys {
	
	public static int dir = 5;
	
	public static void keyPressed(KeyEvent e) {
		if(Game.titleScreen){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				Game.titleScreen = false;
				Sounds.getPlayer(Sounds.title).stop();
				Sounds.playMusic(Sounds.s1);
				Levels.init(1);
			}
		}
		else if(Game.won){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				Game.won = false;
				Levels.init(1);

			}
		}
		else if(!Player.die){
			if(e.getKeyCode() == KeyEvent.VK_W){
				dir = 0;
			}
			if(e.getKeyCode() == KeyEvent.VK_S){
				dir = 2;
			}
			if(e.getKeyCode() == KeyEvent.VK_A){
				dir = 3;
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				dir = 1;
			}
			if(e.getKeyCode() == KeyEvent.VK_M){
				Minimap.show = !Minimap.show;
			}
		}
	}


	public static void keyReleased(KeyEvent e) {
		if(Game.titleScreen){
			
		}
		else if(Game.won){
			
		}
		else if(!Player.die){
			if(e.getKeyCode() == KeyEvent.VK_W && dir == 0){
				dir = 5;
			}
			if(e.getKeyCode() == KeyEvent.VK_S && dir == 2){
				dir = 5;
			}
			if(e.getKeyCode() == KeyEvent.VK_A && dir == 3){
				dir = 5;
			}
			if(e.getKeyCode() == KeyEvent.VK_D && dir == 1){
				dir = 5;
			}
		}
	}


	public static void keyTyped(KeyEvent e) {
		//Do Nothing...
	}
}
