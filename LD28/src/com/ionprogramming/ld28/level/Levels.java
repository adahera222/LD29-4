package com.ionprogramming.ld28.level;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Pit;
import com.ionprogramming.ld28.entities.Player;
import com.ionprogramming.ld28.entities.PressurePlate;
import com.ionprogramming.ld28.entities.WinBlock;
import com.ionprogramming.ld28.gfx.Cutscenes;
import com.ionprogramming.ld28.gfx.Images;

public class Levels {

	public static void init(int level){
		Game.entities.clear();
		
		if(level == 1){
			Game.torchTimeLeft = Game.timeLimit;
			
			Game.entities.add(new PressurePlate(1, 2, 5));
			Game.entities.add(new Pit(1, 3, 5));
			
			Game.entities.add(new PressurePlate(4, 2, 6));
			Game.entities.add(new Pit(11, 6, 6));
			
			Game.entities.add(new PressurePlate(12, 4, 7));
			Game.entities.add(new Pit(1, 9, 7));
			
			Game.entities.add(new PressurePlate(12, 3, 8));
			Game.entities.add(new Pit(1, 10, 8));
			
			Game.entities.add(new PressurePlate(12, 2, 9));
			Game.entities.add(new Pit(1, 11, 9));
			
			Game.entities.add(new PressurePlate(5, 13, 10));
			Game.entities.add(new Pit(15, 1, 10));

			Game.entities.add(new PressurePlate(17, 2, 11));
			Game.entities.add(new Pit(5, 21, 11));

			Game.entities.add(new PressurePlate(14, 21, 12));
			Game.entities.add(new Pit(42, 29, 12));

			Game.entities.add(new PressurePlate(24, 21, 13));
			Game.entities.add(new Pit(46, 19, 13));

			Game.entities.add(new PressurePlate(30,21, 14));
			Game.entities.add(new Pit(47, 14, 14));

			Game.entities.add(new PressurePlate(69, 40, 15));
			Game.entities.add(new Pit(69, 44, 15));

			Game.entities.add(new PressurePlate(71,40, 16));
			Game.entities.add(new Pit(71, 44, 16));

			Game.entities.add(new PressurePlate(73, 40, 17));
			Game.entities.add(new Pit(73, 44, 17));

			Game.entities.add(new PressurePlate(75, 40, 18));
			Game.entities.add(new Pit(75, 40, 18));
			
			Game.entities.add(new PressurePlate(77, 40, 19));
			Game.entities.add(new Pit(77, 8, 19));
			
			Game.entities.add(new PressurePlate(56, 55, 20));
			Game.entities.add(new Pit(77, 44, 20));
			
			Game.entities.add(new PressurePlate(96, 8, 21));
			Game.entities.add(new Pit(98, 8, 21));
			
			Game.entities.add(new PressurePlate(91, 58, 22));
			Game.entities.add(new Pit(89, 58, 22));
			
			Game.entities.add(new PressurePlate(25, 44, 23));
			Game.entities.add(new Pit(17, 44, 23));
			
			Game.entities.add(new PressurePlate(16, 44, 24));
			Game.entities.add(new Pit(14, 52, 24));
			
			Game.entities.add(new PressurePlate(5, 43, 25));
			Game.entities.add(new Pit(8, 44, 25));
			
			Game.entities.add(new PressurePlate(3, 24, 26));
			Game.entities.add(new Pit(3, 23, 26));
			
			Game.entities.add(new PressurePlate(3, 33, 27));
			Game.entities.add(new Pit(10, 23, 27));
			
			Game.entities.add(new PressurePlate(32, 31, 28));
			Game.entities.add(new Pit(45, 31, 28));
			
			Game.entities.add(new WinBlock(52, 56));
			
			Game.entities.add(new Player(1, 1));
			Map.map = Map.format(load(Images.map1));
			Minimap.map = new int[Map.map.length][Map.map[0].length];
			

			

			Cutscenes.trig(1);

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
