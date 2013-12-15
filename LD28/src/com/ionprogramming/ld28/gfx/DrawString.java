package com.ionprogramming.ld28.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawString{
	
	public static BufferedImage make(String words, int width, int size, int textColour){
		char[] arr = words.toLowerCase().toCharArray();
		int start = 0;
		ArrayList<Integer> starts = new ArrayList<Integer>();
		starts.add(start);
		for(int n = 0; n < arr.length; n++){
			if(arr[n] == ' ' && n - starts.get(starts.size() - 1) <= width && arr.length > n){
				start = n + 1;
			}
			if(n == starts.get(starts.size() - 1) + width){
				if(start == starts.get(starts.size() - 1)){
					start = n;
				}
				starts.add(start);
			}
		}
		BufferedImage img = new BufferedImage(width * 16, starts.size() * 16, Images.fontTiles.getType());
		Graphics2D g = img.createGraphics();
		for(int row = 0; row < starts.size(); row++){
			start = starts.get(row);
			for(int n = 0; n < width && n < arr.length - start; n++){
				int let;
				if(arr[start + n] == 'a'){
					let = 0;
				}
				else if(arr[start + n] == 'b'){
					let = 1;
				}
				else if(arr[start + n] == 'c'){
					let = 2;
				}
				else if(arr[start + n] == 'd'){
					let = 3;
				}
				else if(arr[start + n] == 'e'){
					let = 4;
				}
				else if(arr[start + n] == 'f'){
					let = 5;
				}
				else if(arr[start + n] == 'g'){
					let = 6;
				}
				else if(arr[start + n] == 'h'){
					let = 7;
				}
				else if(arr[start + n] == 'i'){
					let = 8;
				}
				else if(arr[start + n] == 'j'){
					let = 9;
				}
				else if(arr[start + n] == 'k'){
					let = 10;
				}
				else if(arr[start + n] == 'l'){
					let = 11;
				}
				else if(arr[start + n] == 'm'){
					let = 12;
				}
				else if(arr[start + n] == 'n'){
					let = 13;
				}
				else if(arr[start + n] == 'o'){
					let = 14;
				}
				else if(arr[start + n] == 'p'){
					let = 15;
				}
				else if(arr[start + n] == 'q'){
					let = 16;
				}
				else if(arr[start + n] == 'r'){
					let = 17;
				}
				else if(arr[start + n] == 's'){
					let = 18;
				}
				else if(arr[start + n] == 't'){
					let = 19;
				}
				else if(arr[start + n] == 'u'){
					let = 20;
				}
				else if(arr[start + n] == 'v'){
					let = 21;
				}
				else if(arr[start + n] == 'w'){
					let = 22;
				}
				else if(arr[start + n] == 'x'){
					let = 23;
				}
				else if(arr[start + n] == 'y'){
					let = 24;
				}
				else if(arr[start + n] == 'z'){
					let = 25;
				}
				else if(arr[start + n] == '$'){
					let = 26;
				}
				else if(arr[start + n] == '('){
					let = 27;
				}
				else if(arr[start + n] == ')'){
					let = 28;
				}
				else if(arr[start + n] == '.'){
					let = 29;
				}
				else if(arr[start + n] == ','){
					let = 30;
				}
				else if(arr[start + n] == '!'){
					let = 31;
				}
				else if(arr[start + n] == '/'){
					let = 32;
				}
				else if(arr[start + n] == '+'){
					let = 33;
				}
				else if(arr[start + n] == '-'){
					let = 34;
				}
				else if(arr[start + n] == '&'){
					let = 35;
				}
				else if(arr[start + n] == '='){
					let = 36;
				}
				else if(arr[start + n] == '\''){
					let = 37;
				}
				else if(arr[start + n] == '?'){
					let = 38;
				}
				else if(arr[start + n] == '"'){
					let = 39;
				}
				else if(arr[start + n] == '"'){
					let = 40;
				}
				else if(arr[start + n] == '_'){
					let = 41;
				}
				else if(arr[start + n] == ':'){
					let = 42;
				}
				else if(arr[start + n] == '1'){
					let = 43;
				}
				else if(arr[start + n] == '2'){
					let = 44;
				}
				else if(arr[start + n] == '3'){
					let = 45;
				}
				else if(arr[start + n] == '4'){
					let = 46;
				}
				else if(arr[start + n] == '5'){
					let = 47;
				}
				else if(arr[start + n] == '6'){
					let = 48;
				}
				else if(arr[start + n] == '7'){
					let = 49;
				}
				else if(arr[start + n] == '8'){
					let = 50;
				}
				else if(arr[start + n] == '9'){
					let = 51;
				}
				else if(arr[start + n] == '0'){
					let = 52;
				}
				else{
					let = 53;
				}
				g.drawImage(Images.font[let], n*16, row*16, null);
				
			}
			
		}
		g.dispose();
		img = ImageHandler.replaceColor(ImageHandler.resizeImage(img, img.getWidth() * size, img.getHeight() * size),0xFFFFFF , textColour);
		img = ImageHandler.replaceColor(img, 0x000000, 0x00FFFFFF);
		return img;
	}
}
