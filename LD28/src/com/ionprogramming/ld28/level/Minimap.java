package com.ionprogramming.ld28.level;

import java.awt.Color;
import java.awt.Graphics;

import com.ionprogramming.ld28.Game;

public class Minimap {
	
	static int[][] map;
	public static boolean show = false;
	
	public static void update(Graphics g){
		
		if(show){
			render(g);
		}
	}
	
	public static void render(Graphics g){
		g.setColor(new Color(255, 240, 190, 150));
		g.fillRect(120, 56, Game.width - 192, Game.height - 192);
	}
}
