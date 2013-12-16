package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.gfx.Cutscenes;
import com.ionprogramming.ld28.gfx.Images;

public class WinBlock extends Entity {

	public WinBlock(int x, int y){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 9;
	}
	
	@Override
	public void ai(){
		
	}
	
	@Override
	public void trigger(int id){
		if(id == 1){
			Cutscenes.trig(3);
		}
	}
}
