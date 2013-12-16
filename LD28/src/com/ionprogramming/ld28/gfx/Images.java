package com.ionprogramming.ld28.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage tileImage;
	public static BufferedImage[] tiles;
	public static BufferedImage titleScreen;
	public static BufferedImage playButton;
	public static BufferedImage fontTiles;
	public static BufferedImage[] font;
	public static BufferedImage wall;
	public static BufferedImage[] walls;
	public static BufferedImage map1;
	public static BufferedImage light;
	public static BufferedImage torch;
	public static BufferedImage flame;
	public static BufferedImage[] flames;
	
	public static BufferedImage won;
	
	public static void load() throws IOException{
		tileImage = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/images.png"));
		tiles = ImageHandler.all(tileImage, 8, 2, 1);
		
		titleScreen = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/titleScreen.png"));
		playButton = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/play.png"));
		
		fontTiles = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/font1.png"));

		font = ImageHandler.all(fontTiles, 27, 2, 2);
		
		wall = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/map.png"));
		walls = ImageHandler.all(wall, 6, 7, 1);

		font = ImageHandler.all(fontTiles, 27, 2, 1);
		
		map1 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/map1.png"));
		
		torch = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/torch.png"));
		
		flame = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/flame.png"));
		flames = ImageHandler.all(flame, 4, 1, 1);
		
		won = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/won.png"));
		
		makeLight();
	}
	
	public static void makeLight(){
		light = new BufferedImage(1100, 720, BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = light.createGraphics();
		Color c;
		for(int y = 0; y < light.getHeight(); y++){
			for(int x = 0; x < light.getWidth(); x++){
				double dist = (int)Math.sqrt((x - 550)*(x - 550) + (y - 360)*(y - 360));
				int a;
				if(dist < 360){
					a = (int)(240*dist/360 + 15);
				}
				else{
					a = 240;
				}
				c = new Color(0, 0, 0, a);
				g2.setColor(c);
				g2.fillRect(x, y, 1, 1);
			}
		}
		g2.dispose();
	}
}
