package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.gfx.Images;
import com.ionprogramming.ld28.sfx.Sounds;

public class PressurePlate extends Entity {

	public PressurePlate(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 0;
		this.id = id;
	}
	
	boolean in = false;
	boolean out = true;
	@Override
	public void ai(){
		if(Player.xp == xpos && Player.yp == ypos && !in){
			Sounds.play(Sounds.pp);
			in = true;
			out = false;
		}
		else if(Player.xp != xpos && Player.yp != ypos && !out){
			Sounds.play(Sounds.pp);
			out = true;
			in = false;
		}
		
		if(Player.xp == xpos && Player.yp == ypos){
			currentImage = 1;
		}
		else{
			currentImage = 0;
		}
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
