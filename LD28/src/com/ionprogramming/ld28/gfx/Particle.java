package com.ionprogramming.ld28.gfx;

import java.awt.Graphics;

import com.ionprogramming.ld28.Game;

public class Particle {
	
	int x;
	double y;
	
	public Particle(){
		x = Torchlight.random.nextInt(32) + 8;
		y = Torchlight.random.nextInt((int)(380 - 340*Game.torchTimeLeft/Game.timeLimit));
	}
	
	public void update(Graphics g){
		y-= 0.2;
		if(Torchlight.random.nextInt(250) == 0){
			y = (int)(380 - 340*Game.torchTimeLeft/Game.timeLimit);
			x = Torchlight.random.nextInt(32) + 8;
		}
		g.fillRect(x, (int) y, 4, 4);
	}
}
