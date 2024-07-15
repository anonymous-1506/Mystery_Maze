package main;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[10];
	
	public Sound()
	{
		soundURL[0] = getClass().getResource("/sound/game_loop.wav");
		soundURL[1] = getClass().getResource("/sound/pick.wav");
		soundURL[2] = getClass().getResource("/sound/victory.wav");
		soundURL[3] = getClass().getResource("/sound/coin_key_pick.wav");
		soundURL[4] = getClass().getResource("/sound/Pickup_Coin.wav");
		soundURL[5] = getClass().getResource("/sound/Explosion.wav");
		
	}
	public void setFile(int i)
	{
		try
		{
			AudioInputStream is = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(is);
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void play() {
		clip.start();
	}
	public void loop()
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stop()
	{
		clip.stop();
	}
}
