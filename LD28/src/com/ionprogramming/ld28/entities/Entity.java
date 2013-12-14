package com.ionprogramming.ld28.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;

public class Entity {

	public int speed = 4;
	public int xpos;
	public int ypos;
	public int xos;
	public int yos;
	public int health;
	public int healthRange;
	public String type;
	public BufferedImage[] imgs;
	public int currentImage;
	boolean movable;
	
	public void draw(Graphics g){
		g.drawImage(imgs[currentImage], xpos*64 + xos, ypos*64 + yos, null);
	}
	
	public void update(){
		if(movable){
			if(xos < 0){
				xos -= 4;
			}
			else if(xos > 0){
				xos += 4;
			}
			if(yos < 0){
				yos -= 4;
			}
			else if(yos > 0){
				yos += 4;
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
	}
	
	public void move(int dir){
		if(xos == 0 && yos == 0){
			if(dir == 0){
				yos -= 4;
			}
			else if(dir == 1){
				xos += 4;
			}
			else if(dir == 2){
				yos += 4;
			}
			else if(dir == 3){
				xos -= 4;
			}
		}
	}
	
	public void destroy(){
		int e = Game.entities.indexOf(this);
		if(e >= 0){
			Game.entities.remove(e);
		}
	}
}
