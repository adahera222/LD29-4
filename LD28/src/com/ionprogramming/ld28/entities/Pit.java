package com.ionprogramming.ld28.entities;


public class Pit extends Entity {

	public boolean close = false;
	public boolean closed = false;
	
	public Pit(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
//		imgs = Images.tiles;
//		currentImage = 3;
		this.id = id;
	}
	
	@Override
	public void ai(){
		if(close){
			if(!closed){
				//animate then set closed...
				//trigger SFX
			}
			else{
				//draw closed
			}
		}
	}
	

	
	@Override
	public void trigger(int id){
		if(id == this.id){
			this.close = true;
		}
		
	}
}
