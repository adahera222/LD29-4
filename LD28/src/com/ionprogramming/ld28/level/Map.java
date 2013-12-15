package com.ionprogramming.ld28.level;

import java.awt.Graphics;

import com.ionprogramming.ld28.Game;
import com.ionprogramming.ld28.gfx.Images;

public class Map {

	public static int[][] map;
	
	public static int[][] map1 = new int[][] {{0, 1, 1, 0 }, {1, 1, 0, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}};
	
	public static void render(Graphics g){
		for(int y = 0; y < map.length; y++){
			for(int x = 0; x < map[y].length; x++){
				if(x*64 - Game.povx > -64 && x*64 - Game.povx < Game.width && y*64 - Game.povy > -64 && y*64 - Game.povy < Game.height){
					g.drawImage(Images.walls[map[y][x]], x*64 - Game.povx, y*64 - Game.povy, null);
				}
			}
		}
	}
	
	public static int[][] format(int[][] m){
		boolean t, tl, tr, l, r, b, bl, br;
		int[][] nm = new int[m.length][m[0].length];
		for(int y = 0; y < m.length; y++){
			for(int x = 0; x < m[y].length; x++){
				if(m[y][x] == 1){
					t = false;
					tl = false;
					tr = false;
					l = false;
					r = false;
					b = false;
					bl = false;
					br = false;
					if(y == 0){
						t = true;
						tl = true;
						tr = true;
					}
					else if(m[y - 1][x] == 1){
						t = true;
						if(x > 0){
							if(m[y - 1][x - 1] == 1){
								tl = true;
							}
						}
						if(x < m[y].length - 1){
							if(m[y - 1][x + 1] == 1){
								tr = true;
							}
						}
					}
					if(y == m.length - 1){
						b = true;
						bl = true;
						br = true;
					}
					else if(m[y + 1][x] == 1){
						b = true;
						if(x > 0){
							if(m[y + 1][x - 1] == 1){
								bl = true;
							}
						}
						if(x < m[y].length - 1){
							if(m[y + 1][x + 1] == 1){
								br = true;
							}
						}
					}
					if(x == 0){
						l = true;
						tl = true;
						bl = true;
					}
					else if(m[y][x - 1] == 1){
						l = true;
						if(y > 0){
							if(m[y - 1][x - 1] == 1){
								tl = true;
							}
						}
						if(y < m.length - 1){
							if(m[y + 1][x - 1] == 1){
								bl = true;
							}
						}
					}
					if(x == m[y].length - 1){
						r = true;
						tr = true;
						br = true;
					}
					else if(m[y][x + 1] == 1){
						r = true;
						if(y > 0){
							if(m[y - 1][x + 1] == 1){
								tr = true;
							}
						}
						if(y < m.length - 1){
							if(m[y + 1][x + 1] == 1){
								br = true;
							}
						}
					}
					
					if(t && b && l && r && tl && tr && bl && !br){
						nm[y][x] = 1;
					}
					else if(t && b && l && r && tl && tr && !bl && br){
						nm[y][x] = 2;
					}
					else if(t && b && l && r && tl && !tr && bl && br){
						nm[y][x] = 3;
					}
					else if(t && b && l && r && !tl && tr && bl && br){
						nm[y][x] = 4;
					}
					else if(!t && !b && !l && !r){
						nm[y][x] = 5;
					}
					else if(!t && b && l && r && bl && br){
						nm[y][x] = 6;
					}
					else if(t && !b && l && r && tl && tr){
						nm[y][x] = 7;
					}
					else if(t && b && l && !r && tl && bl){
						nm[y][x] = 8;
					}
					else if(t && b && !l && r && tr && br){
						nm[y][x] = 9;
					}
					else if(t && b && !l && !r){
						nm[y][x] = 10;
					}
					else if(!t && !b && l && r){
						nm[y][x] = 11;
					}
					else if(t && !b && l && !r && tl){
						nm[y][x] = 12;
					}
					else if(!t && b && l && !r && bl){
						nm[y][x] = 13;
					}
					else if(!t && b && !l && r && br){
						nm[y][x] = 14;
					}
					else if(t && !b && !l && r && tr){
						nm[y][x] = 15;
					}
					else if(t && b && l && r && tl && tr && bl && br){
						nm[y][x] = 16;
					}
					else if(t && b && l && r && !tl && !tr && !bl && !br){
						nm[y][x] = 17;
					}
					else if(!t && b && !l && !r){
						nm[y][x] = 18;
					}
					else if(!t && !b && l && !r){
						nm[y][x] = 19;
					}
					else if(t && !b && !l && !r){
						nm[y][x] = 20;
					}
					else if(!t && !b && !l && r){
						nm[y][x] = 21;
					}
					else if(t && b && !l && r && tr && !br){
						nm[y][x] = 22;
					}
					else if(t && b && l && !r && tl && !bl){
						nm[y][x] = 23;
					}
					else if(t && !b && l && !r && !tl){
						nm[y][x] = 24;
					}
					else if(!t && b && l && !r && !bl){
						nm[y][x] = 25;
					}
					else if(!t && b && !l && r && !br){
						nm[y][x] = 26;
					}
					else if(t && !b && !l && r && !tr){
						nm[y][x] = 27;
					}
					else if(!t && b && l && r && bl && !br){
						nm[y][x] = 28;
					}
					else if(!t && b && l && r && !bl && br){
						nm[y][x] = 29;
					}
					else if(!t && b && l && r && !bl && !br){
						nm[y][x] = 30;
					}
					else if(t && b && l && !r && !tl && !bl){
						nm[y][x] = 31;
					}
					else if(t && !b && l && r && !tl && !tr){
						nm[y][x] = 32;
					}
					else if(t && b && !l && r && !tr && !br){
						nm[y][x] = 33;
					}
					else if(t && b && !l && r && !tr && br){
						nm[y][x] = 34;
					}
					else if(t && b && l && !r && !tl && bl){
						nm[y][x] = 35;
					}
					else if(t && b && l && r && !tl && !tr && bl && br){
						nm[y][x] = 36;
					}
					else if(t && b && l && r && !tl && tr && !bl && br){
						nm[y][x] = 37;
					}
					else if(t && b && l && r && tl && tr && !bl && !br){
						nm[y][x] = 38;
					}
					else if(t && b && l && r && tl && !tr && bl && !br){
						nm[y][x] = 39;
					}
					else if(t && !b && l && r && tl && !tr){
						nm[y][x] = 40;
					}
					else if(t && !b && l && r && !tl && tr){
						nm[y][x] = 41;
					}
				}
				else{
					nm[y][x] = 0;
				}
			}
		}
		return nm;
	}
}
