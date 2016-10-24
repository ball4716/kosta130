package com.return3.model;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundModelThread extends Thread{
	File sound_file;
	public Clip clip;
	int sleep_time;
	
	public SoundModelThread(String music_path, int sleep_time) {
		sound_file = new File(music_path);
		this.sleep_time = sleep_time;
		start();
	}
	
	@Override
	public void run() {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound_file));
			clip.start();
			Thread.sleep(sleep_time);
			clip.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
