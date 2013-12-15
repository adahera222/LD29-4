package com.ionprogramming.ld28.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.level.Map;

public class Entity {

	public int id = 0;
	public int speed = 4;
	public int xpos;
	public int ypos;
	public int xos = 0;
	public int yos = 0;
	public BufferedImage[] imgs;
	public int currentImage = 0;
	boolean movable = false;
	
	public void draw(Graphics g){
		if(xpos*64 + xos - Game.povx > -64 && xpos*64 + xos - Game.povx < Game.width && ypos*64 + yos - Game.povy > -64 && ypos*64 + yos - Game.povy < Game.height){
			g.drawImage(imgs[currentImage], xpos*64 + xos - Game.povx, ypos*64 + yos - Game.povy, null);
		}
	}
	
	public void update(Graphics g){
		ai();
		draw(g);
	}
	
	public boolean move(int dir){
		if(xos == 0 && yos == 0){
			if(dir == 0){
				if(ypos > 0){
					if(Map.map[ypos - 1][xpos] == 0){
						yos -= speed;
					}
				}
			}
			else if(dir == 1){
				if(xpos < Map.map[0].length - 1){
					if(Map.map[ypos][xpos + 1] == 0){
						xos += speed;
					}
				}
			}
			else if(dir == 2){
				if(ypos < Map.map.length - 1){
					if(Map.map[ypos + 1][xpos] == 0){
						yos += speed;
					}
				}
			}
			else if(dir == 3){
				if(xpos > 0){
					if(Map.map[ypos][xpos - 1] == 0){
						xos -= speed;
					}
				}
			}
			return false;
		}
		else{
			return true;
		}
	}
	
	public void ai(){
	}
	
	public void destroy(){
		int e = Game.entities.indexOf(this);
		if(e >= 0){
			Game.entities.remove(e);
		}
	}
	
	public void trigger(int id){
		
	}
}
