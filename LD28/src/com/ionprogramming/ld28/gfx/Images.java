package com.ionprogramming.ld28.gfx;

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
	
	public static void load() throws IOException{
		tileImage = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/images.png"));
		tiles = ImageHandler.all(tileImage, 10, 10, 1);
		
		titleScreen = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/titleScreen.png"));
		playButton = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/play.png"));
		
		fontTiles = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/font.png"));
		font = ImageHandler.all(fontTiles, 27, 2, 2);
	}
	
}
