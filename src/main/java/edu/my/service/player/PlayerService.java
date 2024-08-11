package edu.my.service.player;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
@ApplicationScoped
public class PlayerService {
    @Inject
    @ItypeMusik(ItypeMusik.FileType.WAV)
    IPlayer iPlayerWAV;

    @Inject
    @ItypeMusik(ItypeMusik.FileType.MP3)
    IPlayer iPlayerMP3;

    public IPlayer returnWavPlayer() {
        return iPlayerWAV;
    }

    public IPlayer returnMp3Player() {
        return iPlayerMP3;
    }


}
