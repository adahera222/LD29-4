package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.gfx.Images;
import com.ionprogramming.ld28.input.Keys;

public class Player extends Entity{
	public Player(int xpos, int ypos){
		this.xpos = xpos;
		this.ypos = ypos;
		imgs = Images.tiles;
		movable = true;
	}
	
	@Override
	public void ai(){
		move(Keys.dir);
	}
}
