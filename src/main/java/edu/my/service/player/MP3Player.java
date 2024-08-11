package edu.my.service.player;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Qualifier;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.lang.annotation.Annotation;

@ApplicationScoped
@ItypeMusik(ItypeMusik.FileType.MP3)
public class MP3Player implements IPlayer{

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
