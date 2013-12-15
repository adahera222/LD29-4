package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.Game;
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
		if(xpos*64 + xos + 32 - Game.povx < Game.width/3){
			Game.povx = xpos*64 + xos + 32 - Game.width/3;
		}
		else if(xpos*64 + xos + 32 - Game.povx > 2*Game.width/3){
			Game.povx = xpos*64 + xos + 32 - 2*Game.width/3;
		}
		if(ypos*64 + yos + 32 - Game.povy < Game.height/3){
			Game.povy = ypos*64 + yos + 32 - Game.height/3;
		}
		else if(ypos*64 + yos + 32 - Game.povy > 2*Game.height/3){
			Game.povy = ypos*64 + yos + 32 - 2*Game.height/3;
		}
	}
}
