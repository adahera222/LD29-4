package com.ionprogramming.ld28.level;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.FireShooter;
import com.ionprogramming.ld28.entities.Player;
import com.ionprogramming.ld28.entities.PressurePlate;
import com.ionprogramming.ld28.gfx.Images;

public class Levels {

	public static void init(int level){
		if(level == 1){
			

			Game.entities.add(new PressurePlate(5, 5, 5));
			Game.entities.add(new FireShooter(5, 7, 5));
			
			
			Game.entities.add(new Player(1, 1));
			
			
			Map.map = Map.format(load(Images.map1));
		}
	}
	
	public static int[][] load(BufferedImage in) {
		
		int[][] out = new int[in.getHeight()][in.getWidth()];
		
		for(int y = 0; y < in.getHeight(); y++){
			for(int x = 0; x < in.getWidth(); x++){
				if(in.getRGB(x, y) == Color.black.getRGB()){
					out[y][x] = 1;
				}
				else{
					out[y][x] = 0;
				}
			}
		}
		
		return out;
		
	}
	
}
