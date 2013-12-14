package com.ionprogramming.ld28;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import com.ionprogramming.ld28.entities.Entity;
import com.ionprogramming.ld28.gfx.Images;
import com.ionprogramming.ld28.gfx.Render;
import com.ionprogramming.ld28.input.Keys;
import com.ionprogramming.ld28.phys.Update;


public class Game extends Applet implements Runnable, KeyListener{
		
		private static final long serialVersionUID = 1L;
		
		private Image dbImage;
		private Graphics dbg;
	
		public static int width = 720;
		public static int height = 480;
		
		static double time;
		double sleepTime;
		static double FPS = 60;
		
		public static ArrayList<Entity> entities = new ArrayList<Entity>();
		
		public void init(){
			addKeyListener(this);
			setSize(width, height);
			setFocusable(true);
			setBackground(Color.black);
			try {
				Images.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void start(){
			Thread th = new Thread(this);
			th.start();
		}
		
		public void run(){
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			while(true){
				repaint();
				time = System.nanoTime();
				sleepTime = 1000/FPS - (System.nanoTime() - time)/1000000;
				try{
					if(sleepTime > 10){
						Thread.sleep((long) sleepTime);
					}
					else{
						Thread.sleep(10);
					}
				} 	
				catch(InterruptedException ex){
					ex.printStackTrace();
				}
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			}
		}
		
		public void paint(Graphics g){
			width = Window.getWindows()[0].getWidth() - 6;
			height = Window.getWindows()[0].getHeight() - 32;
			
			Render.render(g);
		}
		
		public void update (Graphics g){
			if (dbImage == null){
		        dbImage = createImage (this.getSize().width, this.getSize().height);
		        dbg = dbImage.getGraphics ();
		    }
		    dbg.setColor (getBackground ());
		    dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
		    dbg.setColor (getForeground());	    
		    paint (dbg);
		    g.drawImage (dbImage, 0, 0, this);
		    Update.update();
		}


		@Override
		public void keyPressed(KeyEvent e) {
			Keys.keyPressed(e);			
		}


		@Override
		public void keyReleased(KeyEvent e) {
			Keys.keyReleased(e);		
		}


		@Override
		public void keyTyped(KeyEvent e) {
			Keys.keyTyped(e);
		}
}
		
