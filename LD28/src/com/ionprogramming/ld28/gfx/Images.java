package com.ionprogramming.ld28.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage tileImage;
	public static BufferedImage[] tiles;
	
	public static void load() throws IOException{
		tileImage = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/images.png"));
		tiles = ImageHandler.all(tileImage, 10, 10, 1);
	}
	
}
