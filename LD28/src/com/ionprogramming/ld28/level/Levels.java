package com.ionprogramming.ld28.level;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Player;

public class Levels {

	public static void init(int level){
		if(level == 1){
			Game.entities.add(new Player(1, 1));
			Map.map = Map.format(Map.map1);
		}
	}
	
}
