package com.ionprogramming.ld28.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Player;

public class Minimap {
	
	static int ms = 5;
	static int[][] map;
	public static boolean show = false;
	static BufferedImage disp;
	static int tick = 20;
	
	static Color c1 = new Color(255, 240, 190, 150);
	static Color c2 = new Color(130, 110, 90, 150);
	static Color c3 = new Color(200, 50, 50, 150);
	
	public static void update(Graphics g){
		for(int y = -5; y < 6; y++){
			for(int x = -5; x < 6; x++){
				if(y + Player.yp >= 0 && x + Player.xp >= 0 && y + Player.yp < Map.map.length && x + Player.xp < Map.map[0].length){
					if(Map.map[y + Player.yp][x + Player.xp] != 0){
						map[y + Player.yp][x + Player.xp] = 1;
					}
				}
			}
		}
		if(show){
			render(g);
		}
	}
	
	public static void render(Graphics g){
		int xc = (Game.width - map[0].length*ms)/2;
		int yc = (Game.height - map.length*ms)/2;
		if(tick >= 20){
			tick = 0;
			disp = new BufferedImage(map[0].length*ms, map.length*ms, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = disp.createGraphics();
			g2.setColor(c1);
			g2.fillRect(0, 0, map[0].length*ms, map.length*ms);
			g2.setColor(c2);
			for(int y = 0; y < map.length; y++){
				for(int x = 0; x < map[y].length; x++){
					if(map[y][x] != 0){
						g2.fillRect(ms*x, ms*y, ms, ms);
					}
				}
			}
			g2.dispose();
		}
		tick++;
		g.drawImage(disp, xc, yc, null);
		g.setColor(c3);
		g.fillRect(Player.xp*ms + xc, Player.yp*ms + yc, ms, ms);
	}
}
