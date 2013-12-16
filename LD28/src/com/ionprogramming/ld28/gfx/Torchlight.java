package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Player;
import com.ionprogramming.ld28.level.Minimap;

public class Torchlight {
	
	static Random random = new Random();
	static int flicker = 0;
	static int dif = 0;
	static Color c = new Color(0, 0, 0);
	static int a;
	
	public static void render(Graphics g){
		g.drawImage(Images.light, Player.xp*64 + Player.xo - Game.povx - 518, Player.yp*64 + Player.yo - Game.povy - 328, null);
		Minimap.update(g);
		if(flicker == 0){
			a = 255 - (int)(240*((double)Game.torchTimeLeft/Game.timeLimit));
			dif = random.nextInt(40) - 20;
			flicker = 5;
			a += dif;
			if(a < 15){
				a = 15;
			}
			else if(a > 255){
				a = 255;
			}
			c = new Color(0, 0, 0, a);
		}
		flicker--;
		g.setColor(c);
		g.fillRect(0, 0, Game.width, Game.height);
	}
}
