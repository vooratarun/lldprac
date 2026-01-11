package musicplayer;


import musicplayer.enums.PlayStrategyType;

public class Main {
    public static void main(String[] args) {
        try {
            MusicPlayerApplication application = MusicPlayerApplication.getInstance();

            // Populate library
            application.createSongInLibrary("Kesariya", "Arijit Singh", "/music/kesariya.mp3");
            application.createSongInLibrary("Chaiyya Chaiyya", "Sukhwinder Singh", "/music/chaiyya_chaiyya.mp3");
            application.createSongInLibrary("Tum Hi Ho", "Arijit Singh", "/music/tum_hi_ho.mp3");
            application.createSongInLibrary("Jai Ho", "A. R. Rahman", "/music/jai_ho.mp3");
            application.createSongInLibrary("Zinda", "Siddharth Mahadevan", "/music/zinda.mp3");

            // Create playlist and add songs
            application.createPlaylist("Bollywood Vibes");
            application.addSongToPlaylist("Bollywood Vibes", "Kesariya");
            application.addSongToPlaylist("Bollywood Vibes", "Chaiyya Chaiyya");
            application.addSongToPlaylist("Bollywood Vibes", "Tum Hi Ho");
            application.addSongToPlaylist("Bollywood Vibes", "Jai Ho");

            // Connect device
            application.connectAudioDevice();// default booth

            //Play/pause a single song
            application.playSingleSong("Zinda");
            application.pauseCurrentSong("Zinda");
            application.playSingleSong("Zinda");  // resume

            System.out.println("\n-- Sequential Playback --\n");
            application.selectPlayStrategy();
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTracksInPlaylist();
            application.playPreviousTrackInPlaylist();
            application.playNextTrackInPlaylist();

        } catch (Exception error) {
            System.err.println("Error: " + error.getMessage());
        }
    }
}
