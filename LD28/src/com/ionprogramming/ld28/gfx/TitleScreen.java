package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.ionprogramming.ld28.Game;

public class TitleScreen {
	
	static Color c = new Color(0, 0, 0, 150);
	static int tick = 0;
	
	public static void renderScreen(Graphics g){
		g.drawImage(Images.bg, Game.width / 2 - Images.titleScreen.getWidth() / 2, 50, null);
		if(tick <= 0){
			tick = 5;
			c = new Color(0, 0, 0, Torchlight.random.nextInt(30) + 150);
		}
		tick--;
		g.setColor(c);
		g.fillRect(Game.width / 2 - Images.titleScreen.getWidth() / 2, 50, Images.titleScreen.getWidth(), Images.titleScreen.getHeight());
		g.drawImage(Images.titleScreen, Game.width / 2 - Images.titleScreen.getWidth() / 2, 50, null);
		g.drawImage(Images.playButton, Game.width / 2 - Images.playButton.getWidth() / 2, Game.height - 150, null);
	}
}
