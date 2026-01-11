package musicplayer.playstrategy;


import musicplayer.models.Playlist;
import musicplayer.models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrevious();

}
