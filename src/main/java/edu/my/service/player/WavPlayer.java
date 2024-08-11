package edu.my.service.player;

import jakarta.enterprise.context.ApplicationScoped;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

@ApplicationScoped
@ItypeMusik(ItypeMusik.FileType.WAV)
public class WavPlayer implements IPlayer{

    @Override
    public void playMusic(String fileName) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
