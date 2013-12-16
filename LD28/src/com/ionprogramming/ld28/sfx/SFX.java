package com.ionprogramming.ld28.sfx;

import java.util.Random;

public class SFX {

	static int minDelay = 10;
	static int maxDelay = 30;
	
	
	static Random r = new Random();
	static long lastTick = System.nanoTime();
	static int timeLeft = r.nextInt(maxDelay - minDelay) + minDelay;
	
	public static void update(){
		
		if(System.nanoTime() - lastTick >= 1000000000){
			timeLeft--;
			lastTick = System.nanoTime();
		}
		
		if(timeLeft <= 0){
			timeLeft = r.nextInt(maxDelay - minDelay) + minDelay;
			int s = r.nextInt(4)+1;
			
			if(s == 1){
				Sounds.play(Sounds.ghost1);
			}
			else if(s == 2){
				Sounds.play(Sounds.ghost2);
			}
			else if(s == 3){
				Sounds.play(Sounds.glass);
			}
			else{
				Sounds.play(Sounds.wind);
			}
		}
	}
	
}
