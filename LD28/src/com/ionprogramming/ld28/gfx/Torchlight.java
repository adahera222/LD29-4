package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.ionprogramming.ld28.Game;

public class Torchlight {
	static Random random = new Random();
	static int flicker = 0;
	static int dif = 0;
	public static void render(Graphics g){
		int a = 255 - (int)(255*((double)Game.torchTimeLeft/Game.timeLimit));
		if(flicker == 0){
			dif = random.nextInt(20) - 10;
			flicker = 5;
		}
		flicker--;
		a += dif;
		if(a < 0){
			a = 0;
		}
		else if(a > 255){
			a = 255;
		}
		g.setColor(new Color(0, 0, 0, a));
		g.fillRect(0, 0, Game.width, Game.height);
	}
}
