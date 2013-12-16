package com.ionprogramming.ld28.entities;

import java.awt.Graphics;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.gfx.Images;

public class Door extends Entity {

	public boolean open = false;
	public boolean opened = false;
	
	public Door(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 3;
		this.id = id;
	}
	
	@Override
	public void draw(Graphics g){
		if(xpos*64 + xos - Game.povx > -64 && xpos*64 + xos - Game.povx < Game.width && ypos*64 + yos - Game.povy > -64 && ypos*64 + yos - Game.povy < Game.height){
			g.drawImage(imgs[currentImage], xpos*64 + xos - Game.povx, ypos*64 + yos - Game.povy, null);
		}
	}
	
	@Override
	public void ai(){
		if(open){
			if(!opened){
				open();
			}
		}
	}
	
	public void open(){
		
		
	}
	
	@Override
	public void trigger(int id){
		if(id == this.id){
			this.open = true;
		}
		
	}
}
