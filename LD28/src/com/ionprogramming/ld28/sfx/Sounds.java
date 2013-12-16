package com.ionprogramming.ld28.sfx;

import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sounds {
	
	static MediaPlayer music;
	static ArrayList<MediaPlayer> players = new ArrayList<MediaPlayer>();

	
	
	public static Media fire;
	public static Media footsteps;
	public static Media ghost1;
	public static Media ghost2;
	public static Media glass;
	public static Media pit;
	public static Media wind;
	public static Media fall;
	public static Media win;
	public static Media s1;
	
	public static void load(){
		try{
			fire = new Media(Sounds.class.getClassLoader().getResource("res/sfx/fire.mp3").toString());
			footsteps = new Media(Sounds.class.getClassLoader().getResource("res/sfx/footsteps.mp3").toString());
			ghost1 = new Media(Sounds.class.getClassLoader().getResource("res/sfx/ghost1.mp3").toString());
			ghost2 = new Media(Sounds.class.getClassLoader().getResource("res/sfx/ghost2.mp3").toString());
			glass = new Media(Sounds.class.getClassLoader().getResource("res/sfx/glass.mp3").toString());
			pit = new Media(Sounds.class.getClassLoader().getResource("res/sfx/pit.mp3").toString());
			wind = new Media(Sounds.class.getClassLoader().getResource("res/sfx/wind.mp3").toString());

			//TODO: Proper SFX Files
			fall = new Media(Sounds.class.getClassLoader().getResource("res/sfx/wind.mp3").toString());
			win = new Media(Sounds.class.getClassLoader().getResource("res/sfx/wind.mp3").toString());
			
			s1 = new Media(Sounds.class.getClassLoader().getResource("res/music/s1.mp3").toString());

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void play(Media m){
		final MediaPlayer med = new MediaPlayer(m);
		med.play();
		med.setOnEndOfMedia(new Runnable() {
		    @Override
		    public void run() {
		       players.remove(med);
		    }
		});
		players.add(med);
	}
	
	public static void playMusic(Media m){
		final MediaPlayer med = new MediaPlayer(m);
		med.setAutoPlay(true);
		med.play();
		med.setCycleCount(MediaPlayer.INDEFINITE);
		players.add(med);
	}
	
	public static int getPlayerIndex(Media m){
		int i = -1;
		for(int n = 0; n < players.size(); n++){
			if(players.get(n).getMedia() == m){
				i = n;
				break;
			}
		}
		return i;
	}
	
	public static MediaPlayer getPlayer(Media m){
		MediaPlayer p = null;
		for(int n = 0; n < players.size(); n++){
			if(players.get(n).getMedia() == m){
				p = players.get(n);
				break;
			}
		}
		return p;
	}
}
