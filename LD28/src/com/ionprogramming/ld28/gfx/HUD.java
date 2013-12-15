package com.ionprogramming.ld28.gfx;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.entities.Player;
import com.ionprogramming.ld28.level.Map;

public class HUD {
	
	static BufferedImage distance; 

	
	static BufferedImage floor; 
	static BufferedImage timeLeft; 
	
	public static BufferedImage[]hud;

	
	static int flameNum = 0;
	static int timer = 0;

	public static void render(Graphics g){
		
		int min = Game.torchTimeLeft / 60;
		int sec = Game.torchTimeLeft - (min * 60);
		String secs = String.valueOf(sec);
		String time = "";
		if(secs.length() == 1){
			time = min + ":0" + sec;
		}
		else{
			time = min + ":" + sec;
		}
		
		int dist = (int) Math.sqrt(Math.pow((Player.xp - Map.targetX), 2) + Math.pow((Player.yp - Map.targetY), 2));
		
		double theta = Math.atan((double)Math.abs(Map.targetX - Player.xp)/(double)Math.abs(Map.targetY - Player.yp));
		int cx = (int)(30*Math.sin(theta));
		int cy = (int)(30*Math.cos(theta));
		if(Map.targetX - Player.xp < 0){
			cx = -cx;
		}
		if(Map.targetY - Player.yp < 0){
			cy = -cy;
		}
		
		distance = DrawString.make("EXIT: " + dist +"M" , "EXIT: ".length() + String.valueOf(dist).length()+1, 2, 0xFFFFFF);
		
		timeLeft = DrawString.make(time, time.length(), 2, 0xFFFFFF);
		
		g.setColor(Color.black);
		g.fillRect(0, Game.height - 80, Game.width, 80);
		
		g.setColor(Color.darkGray);
		g.fillRect(Game.width - 200, Game.height - 80, 200, 40);
		g.fillRect(Game.width - 200, Game.height - 40, 200, 40);
		g.fillRect(0, 0, 50, Game.height);
		g.fillRect(30, Game.height - 80, 150, 80);
		
		g.drawImage(distance, Game.width / 2 - distance.getWidth() / 2, Game.height - 80 / 2 - distance.getHeight() / 2, null);
		
		g.drawImage(timeLeft, 40, Game.height - 40 - timeLeft.getHeight() / 2, null);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.WHITE);
		g2.drawOval(Game.width - (200 / 2) - (60 / 2), Game.height - 80 + 5, 61, 61);
		g2.setColor(Color.red);
		g2.drawLine(Game.width - (200 / 2) - (60 / 2) + 30, Game.height - 80 + 35, Game.width - (200 / 2) - (60 / 2) + 30 + cx, Game.height - 80 + 35 + cy);
		renderTorch(g);
	}
	
	public static void renderTorch(Graphics g){
		g.drawImage(Images.torch, 8, 32, null);
		g.setColor(Color.darkGray);
		g.fillRect(0, 70, 50, 340 - 340*Game.torchTimeLeft/Game.timeLimit);
		timer--;
		if(timer <= 0){
			timer = 5;
			int old = flameNum;
			while(flameNum == old){
				flameNum = Torchlight.random.nextInt(4);
			}
		}
		g.drawImage(Images.flames[flameNum], 8, 350 - 340*Game.torchTimeLeft/Game.timeLimit, null);
	}
}
