package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.gfx.Images;

public class PressurePlate extends Entity {

	public PressurePlate(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 2;
		this.id = id;
	}
	
	@Override
	public void ai(){
		
	}
	
	@Override
	public void trigger(int id){
		if(id == 1){
			for(int e = 0; e < Game.entities.size(); e++){
				if(Game.entities.get(e).id == this.id && Game.entities.get(e).getClass() != PressurePlate.class){
					Game.entities.get(e).trigger(this.id);
				}
			}
		}
	}
}
