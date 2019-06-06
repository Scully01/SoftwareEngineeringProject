
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import sun.audio.*;

public class Sound {
	
	public static boolean override = false;

	
	public Sound() {
		//music(theme[n]);
	}
	public static void soundEffect(String filepath) {
		if(override == false) {
			playEffect(filepath);	
		//	override = true;
		}
		
	}
	public static void music(String filepath) {
		
		InputStream music;
		try {

			music = new FileInputStream(new File(filepath));
			AudioStream audios = new AudioStream(music);
			AudioPlayer.player.start(audios);			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}
	public static void playEffect(String filepath) {
		
		InputStream sound;
		try {
			sound = new FileInputStream(new File(filepath));
			AudioStream audios = new AudioStream(sound);
			AudioPlayer.player.start(audios);
		}catch(Exception e) {
			System.out.println(e);
		}
		override = false;
		
		
	}
}
