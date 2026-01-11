package musicplayer.device;


import musicplayer.models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}
