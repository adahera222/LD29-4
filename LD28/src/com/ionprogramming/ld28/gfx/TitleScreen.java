package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.ionprogramming.ld28.Game;

public class TitleScreen {

	
	public static void renderScreen(Graphics g){
		g.setColor(Color.red);
		
		g.drawImage(Images.titleScreen, Game.width / 2 - Images.titleScreen.getWidth() / 2, 50, null);

		g.drawImage(Images.playButton, Game.width / 2 - Images.playButton.getWidth() / 2, Game.height - 150, null);
		
	}
}
