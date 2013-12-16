package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.gfx.Images;
import com.ionprogramming.ld28.sfx.Sounds;


public class Pit extends Entity {

	public boolean close = false;
	public boolean closed = false;
	
	boolean triggered = false;
	
	public Pit(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 4;
		this.id = id;
	}
	
	int tick = 0;
	int stage = 0;
	@Override
	public void ai(){
		if(close){
			if(!closed){
				tick++;
				
				if(stage == 4){
					closed = true;
				}
				else if(tick >= 20){
					tick = 0;
					stage++;
				}
				//animate then set closed...
				//trigger SFX
			}
			else{
				stage = 4;
				//draw closed
			}
			
		}
		currentImage = 4+stage;
	}
	

	
	@Override
	public void trigger(int id){
		if(id == this.id && !triggered){
			this.close = true;
			Sounds.play(Sounds.pit);
			triggered = true;
		}
		
		if(id == 1 && !closed){
			System.out.println("DIE");
		}
		
	}
}
