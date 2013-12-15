package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Player;

public class Torchlight {
	static Random random = new Random();
	static int flicker = 0;
	static int dif = 0;
	public static void render(Graphics g){
		int a = 255 - (int)(240*((double)Game.torchTimeLeft/Game.timeLimit));
		if(flicker == 0){
			dif = random.nextInt(40) - 20;
			flicker = 5;
		}
		flicker--;
		a += dif;
		if(a < 15){
			a = 15;
		}
		else if(a > 255){
			a = 255;
		}
		g.setColor(new Color(0, 0, 0, a));
		g.fillRect(0, 0, Game.width, Game.height);
		g.drawImage(Images.light, Player.xp*64 + Player.xo - Game.povx - 224, Player.yp*64 + Player.yo - Game.povy - 224, null);
		g.setColor(new Color(0, 0, 0, 240));
		if(Player.yp*64 + Player.yo - Game.povy - 224 > 0){
			g.fillRect(0, 0, Game.width, Player.yp*64 + Player.yo - Game.povy - 224);
		}
		if(Player.yp*64 + Player.yo - Game.povy + 288 < Game.height){
			g.fillRect(0, Player.yp*64 + Player.yo - Game.povy + 288, Game.width, Game.height - (Player.yp*64 + Player.yo - Game.povy + 288));
		}
		if(Player.xp*64 + Player.xo - Game.povx - 224 > 0){
			g.fillRect(0, Player.yp*64 + Player.yo - Game.povy - 224, Player.xp*64 + Player.xo - Game.povx - 224, 512);
		}
		if(Player.xp*64 + Player.xo - Game.povx + 288 < Game.width){
			g.fillRect(Player.xp*64 + Player.xo - Game.povx + 288, Player.yp*64 + Player.yo - Game.povy - 224, Game.width - (Player.xp*64 + Player.xo - Game.povx + 288), 512);
		}
	}
}
