package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.gfx.Cutscenes;
import com.ionprogramming.ld28.gfx.Images;
import com.ionprogramming.ld28.sfx.Sounds;


public class Pit extends Entity {

	public static boolean playerMoved = true;
	
	boolean open = true;
	boolean triggered = false;
	
	public Pit(int x, int y, int id){
		this.xpos = x;
		this.ypos = y;
		imgs = Images.tiles;
		currentImage = 2;
		this.id = id;
	}
	
	int tick = 0;
	int stage = 0;
	@Override
	public void ai(){
		if(triggered){
			tick++;
			if(tick >= 20){
				tick = 0;
				if(open){ //close door
					stage++;
					if(stage == 4){
						open = false;
						triggered = false;
					}
				}
				else{//open door
					stage--;
					if(stage == 0){
						open = true;
						triggered = false;
					}
				}
			}
		}
		else{
			if(open){
				stage = 0;
			}
			else{
				stage = 4;
			}
			
		}
		currentImage = 2 + stage;	
	}
	
	@Override
	public void trigger(int id){
		if(id == this.id && !triggered && playerMoved){
			this.triggered = true;
			Sounds.play(Sounds.pit);
			playerMoved = false;
		}
		
		if(id == 1 && open){
			if(!Player.die) Sounds.play(Sounds.die);
			Player.die = true;
			
			Cutscenes.trig(2);
		}
		
	}
}
