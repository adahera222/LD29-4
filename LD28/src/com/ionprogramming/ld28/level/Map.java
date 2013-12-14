package com.ionprogramming.ld28.level;

import java.awt.Graphics;

import com.ionprogramming.ld28.gfx.Images;

public class Map {

	public static int[][] map;
	
	public static int[][] map1 = new int[][] {{1, 2, 2}, {1, 2, 1}};
	
	public static void render(Graphics g){
		for(int y = 0; y < map.length; y++){
			for(int x = 0; x < map[y].length; x++){
				g.drawImage(Images.tiles[map[y][x]], x*64, y*64, null);
			}
		}
	}
}
