package radio;

public abstract class RadioPlayer implements Observer {
     int volume; // 0 --- 100
    protected double frequency; // > 0
    private int INITIALVOLUME = 20;

    private int MINVOLUME = 0;

    private int MAXVOLUME = 100;

    public void playRadio() {
    }

    public void stopRadio() {
    }


    public void changeVolumeRadio(int volume) {
    }


    public void changeFrequencyRadio(double frequency) {
    }

    public void changePlayingStatus(boolean isPlaying) {
    }

    @Override
    public void update(int volume, double frequency, boolean isPlaying) {
        changeVolumeRadio(volume);
        changeFrequencyRadio(frequency);

    }

    public int getVolume() {
        return volume;
    }

    public double getFrequency() {
        return frequency;
    }
}

