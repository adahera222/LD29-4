package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld28.Game;

public class HUD {
	
	static BufferedImage completed; 
	static BufferedImage puzzles; 
	static BufferedImage slash; 
	static BufferedImage curPuz; 
	static BufferedImage totPuz; 
	
	static BufferedImage floor; 
	static BufferedImage timeLeft; 
	
	public static void genTxt(){
		completed = DrawString.make("Completed", 9, 1, 0xFFFFFF);
		puzzles = DrawString.make("Puzzles", 7, 1, 0xFFFFFF);
		
		
		slash = DrawString.make("/", 1, 2, 0xFFFFFF);
		
		totPuz = DrawString.make(String.valueOf(Game.totalPuzzles), String.valueOf(Game.totalPuzzles).length(), 1, 0xFFFFFF);	

	}

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
		
		
		
		curPuz = DrawString.make(String.valueOf(Game.puzzlesComplete), String.valueOf(Game.puzzlesComplete).length(), 1, 0xFFFFFF);
		floor = DrawString.make("Floor: " + String.valueOf(Game.currentFloor), "Floor: ".length() + String.valueOf(Game.currentFloor).length(), 1, 0xFFFFFF);
		timeLeft = DrawString.make(time, time.length(), 2, 0xFFFFFF);
		
		g.setColor(Color.red);
		g.fillRect(0, Game.height - 80, Game.width, 80);
		
		g.setColor(Color.blue);
		g.fillRect(Game.width - 200, Game.height - 80, 200, 40);

		g.setColor(Color.darkGray);
		g.fillRect(Game.width - 200, Game.height - 40, 200, 40);
	
		g.setColor(Color.gray);
		g.fillRect(0, 0, 30, Game.height);
		
		g.setColor(Color.darkGray);
		g.fillRect(30, Game.height - 80, 150, 80);
		
		g.drawImage(completed, 190, Game.height - 70, null);
		g.drawImage(puzzles, Game.width - 210 - puzzles.getWidth(), Game.height - 10 - puzzles.getHeight(), null);
		g.drawImage(timeLeft, 40, Game.height - 40 - timeLeft.getHeight() / 2, null);
		g.drawImage(slash, Game.width / 2 - slash.getWidth() / 2, Game.height - 40 - slash.getHeight() / 2, null);
		
		g.drawImage(totPuz, Game.width / 2 - totPuz.getWidth() / 2 + 30, Game.height - 40 - totPuz.getHeight() / 2 + 15, null);
		g.drawImage(curPuz, Game.width / 2 - curPuz.getWidth() / 2 - 30, Game.height - 40 - curPuz.getHeight() / 2 - 15, null);
		
		g.drawImage(floor, Game.width - (200 / 2) - floor.getWidth() / 2, Game.height - (40 / 2) - floor.getHeight() / 2, null);
		
	}
}
