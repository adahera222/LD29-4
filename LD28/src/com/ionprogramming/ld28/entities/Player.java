package com.ionprogramming.ld28.entities;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.gfx.Images;
import com.ionprogramming.ld28.input.Keys;

public class Player extends Entity{
	
	public static int xp;
	public static int yp;
	public static int xo;
	public static int yo;
	public static boolean die = false;
	
	public Player(int xpos, int ypos){
		this.xpos = xpos;
		this.ypos = ypos;
		imgs = Images.tiles;
		movable = true;
		this.id = 1;
		die = false;
	}
	
	@Override
	public void ai(){
		if(die){
			Keys.dir = 5;
		}
		if(move(Keys.dir)){
			if(movable){
				
				if(xos < 0){
					xos -= speed;
				}
				else if(xos > 0){
					xos += speed;
				}
				if(yos < 0){
					yos -= speed;
				}
				else if(yos > 0){
					yos += speed;
				}
				if(xos >= 64){
					xos = 0;
					xpos++;
					Pit.playerMoved = true;
				}
				else if(xos <= -64){
					xos = 0;
					xpos--;
					Pit.playerMoved = true;
				}
				if(yos >= 64){
					yos = 0;
					ypos++;
					Pit.playerMoved = true;
				}
				else if(yos <= -64){
					yos = 0;
					ypos--;
					Pit.playerMoved = true;
				}
			}
		}
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
		
		for(int e = 0; e < Game.entities.size(); e++){
			if(Game.entities.get(e).xpos == this.xpos && Game.entities.get(e).ypos == this.ypos){
				Game.entities.get(e).trigger(this.id);
			}
		}
		xp = xpos;
		yp = ypos;
		xo = xos;
		yo = yos;
	}
}
