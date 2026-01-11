package musicplayer;


import musicplayer.manager.PlaylistManager;
import musicplayer.models.Song;

import java.util.List;

public class MusicPlayerApplication {
    private static MusicPlayerApplication instance = null;
    private List<Song> songLibrary;

    private MusicPlayerApplication() {
        songLibrary = new java.util.ArrayList<>();
    }

    public static synchronized MusicPlayerApplication getInstance() {
        if (instance == null) {
            instance = new MusicPlayerApplication();
        }
        return instance;
    }

    public void createSongInLibrary(String title, String artist, String path) {
        Song newSong = new Song(title, artist, path);
        songLibrary.add(newSong);
    }

    public Song findSongByTitle(String title) {
        for (Song s : songLibrary) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }

    public void createPlaylist(String playlistName) {
        PlaylistManager.getInstance().createPlaylist(playlistName);
    }

    public void addSongToPlaylist(String playlistName, String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found in library.");
        }
        PlaylistManager.getInstance().addSongToPlaylist(playlistName, song);
    }

    public void connectAudioDevice() {
        MusicPlayerFacade.getInstance().connectDevice();
    }

    public void selectPlayStrategy() {
        MusicPlayerFacade.getInstance().setPlayStrategy();
    }

    public void loadPlaylist(String playlistName) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    public void playSingleSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().playSong(song);
    }

    public void pauseCurrentSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().pauseSong(song);
    }

    public void playAllTracksInPlaylist() {
        MusicPlayerFacade.getInstance().playAllTracks();
    }

    public void playPreviousTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playPreviousTrack();
    }

    public void playNextTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playNextTrack();
    }


}
