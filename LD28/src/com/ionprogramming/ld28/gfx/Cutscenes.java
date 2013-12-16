package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.level.Levels;
import com.ionprogramming.ld28.sfx.Sounds;

public class Cutscenes {

	public static boolean on = true;
	public static int scene = 1;
	
	static boolean triggered = false;
	static int tick = 0;
	static int a = 0;
	public static void render(Graphics g){
		if(on){
			if(scene == 1){ //opening...
				
				if(!triggered){//start
					Sounds.play(Sounds.fire);
					triggered = true;
					a = 255;
				}
							
				tick++;
				
				g.setColor(new Color(0, 0, 0, a));
				g.fillRect(0, 0, Game.width, Game.height);
				
				if(tick >= 20){
					a--;
				}
				if(a <= 0){//end
					a = 0;
					on = false;
					triggered = false;
				}
			
			}
			
			else if(scene == 2){//Die...
				
				if(!triggered){//start
					Sounds.play(Sounds.fall);
					a = 0;
					triggered = true;
				}
							
				tick++;
				
				g.setColor(new Color(0, 0, 0, a));
				g.fillRect(0, 0, Game.width, Game.height);
				
				if(tick >= 20){
					a++;
				}
				if(a >= 255){//end
					a = 0;
					on = false;
					triggered = false;
					Levels.init(1); //start again...
				}
			
			}
			
			//TODO: Win Cutscene...
			else if(scene == 3){//Win...
				
				if(!triggered){//start
					Sounds.play(Sounds.win);
					a = 0;
					triggered = true;
				}
							
				tick++;
				
				g.setColor(new Color(0, 0, 0, a));
				g.fillRect(0, 0, Game.width, Game.height);
				
				if(tick >= 20){
					a++;
				}
				if(a >= 255){//end
					a = 0;
					on = false;
					triggered = false;
					Game.won = true; //start again...
				}
			
			}
			
			
			
		}
	}
	
	public static void trig(int s){
		scene = s;
		on = true;
	}
}
