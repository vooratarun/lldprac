package lld.musicplayer.device;


import lld.musicplayer.models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}
