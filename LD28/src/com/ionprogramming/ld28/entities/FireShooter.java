package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.gfx.Images;

public class FireShooter extends Entity {

	public FireShooter(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 3;
		this.id = id;
	}
	
	@Override
	public void ai(){
		
	}
	
	@Override
	public void trigger(int id){
		if(id == this.id){
			this.destroy();	
		}
		
	}
}
