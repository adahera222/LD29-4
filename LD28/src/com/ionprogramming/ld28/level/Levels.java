package com.ionprogramming.ld28.level;

import com.ionprogramming.ld28.Game;

public class Levels {

	public static void init(int level){
		if(level == 1){
//			Game.entities.add(new Player(100, 100));
			Map.map = Map.map1;
		}
	}
}
