package com.ionprogramming.ld28.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;

public class Entity {

	public int speed = 4;
	public int xpos;
	public int ypos;
	public int health;
	public int healthRange;
	public String type;
	public BufferedImage[] imgs;
	public int currentImage;
	
	public void draw(Graphics g){
		g.drawImage(imgs[currentImage], xpos, ypos, null);
	}
	
	public void update(){

	}
	
	public void destroy(){
		int e = Game.entities.indexOf(this);
		if(e >= 0){
			Game.entities.remove(e);
		}
	}
}
