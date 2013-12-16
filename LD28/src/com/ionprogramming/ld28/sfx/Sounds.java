package com.ionprogramming.ld28.sfx;

import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sounds {
	
	static MediaPlayer music;
	static ArrayList<MediaPlayer> players = new ArrayList<MediaPlayer>();

	public static Media pit;

	public static void load(){
		try{
			pit = new Media(Sounds.class.getClassLoader().getResource("res/sfx/pit.mp3").toString());
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
