package lld.musicplayer.playstrategy;


import lld.musicplayer.models.Playlist;
import lld.musicplayer.models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrevious();

}
