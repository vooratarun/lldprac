package musicplayer.device;

public class DeviceManager {
    private static DeviceManager instance = null;
    private IAudioOutputDevice currentOutputDevice;

    private DeviceManager() {
        currentOutputDevice = null;
    }

    public static synchronized DeviceManager getInstance() {
        if (instance == null) {
            instance = new DeviceManager();
        }
        return instance;
    }

    public void connect() {
        if (currentOutputDevice != null) {
            // In C++: delete currentOutputDevice;
            // In Java, garbage collector handles it, so no explicit delete.
        }

        currentOutputDevice = new BluetoothSpeakerDevice();
        System.out.println("Bluetooth device connected ");

    }

    public IAudioOutputDevice getOutputDevice() {
        if (currentOutputDevice == null) {
            throw new RuntimeException("No output device is connected.");
        }
        return currentOutputDevice;
    }

    public boolean hasOutputDevice() {
        return currentOutputDevice != null;
    }
}
