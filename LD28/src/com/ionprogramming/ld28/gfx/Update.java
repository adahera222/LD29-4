package com.ionprogramming.ld28.gfx;

import java.awt.Graphics;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.level.Map;
import com.ionprogramming.ld28.level.Minimap;


public class Update {

	public static void update(Graphics g){
		Map.render(g);
		for(int n = 0; n < Game.entities.size(); n++){
			Game.entities.get(n).update(g);
		}
		Torchlight.render(g);
		HUD.render(g);
		Minimap.update(g);
	}

}
