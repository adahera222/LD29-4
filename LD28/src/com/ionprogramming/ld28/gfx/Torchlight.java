package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.ionprogramming.ld28.Game;

public class Torchlight {
	public static void render(Graphics g){
		g.setColor(new Color(0, 0, 0, 255 - (int)(255*((double)Game.torchTimeLeft/Game.timeLimit))));
		g.fillRect(0, 0, Game.width, Game.height);
	}
}
