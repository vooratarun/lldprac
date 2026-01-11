package musicplayer.device;


import musicplayer.device.IAudioOutputDevice;
import musicplayer.models.Song;

public class BluetoothSpeakerDevice implements IAudioOutputDevice {

    public BluetoothSpeakerDevice() {
    }

    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        System.out.println("[BluetoothSpeaker] Playing: " + payload);

    }
}
