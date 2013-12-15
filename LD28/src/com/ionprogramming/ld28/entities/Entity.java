package com.ionprogramming.ld28.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.level.Map;

public class Entity {

	public int speed = 4;
	public int xpos;
	public int ypos;
	public int xos = 0;
	public int yos = 0;
	public BufferedImage[] imgs;
	public int currentImage = 0;
	boolean movable = false;
	
	public void draw(Graphics g){
		g.drawImage(imgs[currentImage], xpos*64 + xos, ypos*64 + yos, null);
	}
	
	public void update(Graphics g){
		ai();
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
			}
			else if(xos <= -64){
				xos = 0;
				xpos--;
			}
			if(yos >= 64){
				yos = 0;
				ypos++;
			}
			else if(yos <= -64){
				yos = 0;
				ypos--;
			}
		}
		draw(g);
	}
	
	public void move(int dir){
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
}
