package main;
import javax.sound.sampled.LineEvent;



public class Game 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String path = "gamemusic/bgm.wav"; 
	    music_player player = new music_player(path);
	    player.start(); 
	    new GameFrame();
	    

	}

}
