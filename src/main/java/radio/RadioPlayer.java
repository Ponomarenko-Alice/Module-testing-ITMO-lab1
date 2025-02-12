package radio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RadioPlayer implements Observer {

    private int volume; // 0 --- 100
    private double frequency; // > 0
    private boolean isPLaying;
    private int INITIAL_VOLUME = 20;

    private int MIN_VOLUME = 0;

    private int MAX_VOLUME = 100;

    public void playRadio() {
    }

    public void stopRadio() {
    }


    public void changeVolumeRadio(int volume) {
    }


    public void changeFrequencyRadio(double frequency) {
    }

    public void changePlayingStatus(boolean mustPlay) {
        this.isPLaying = mustPlay;
    }


    public void setPLaying(boolean PLaying) {
        isPLaying = PLaying;
    }

    @Override
    public void update(int volume, double frequency, boolean mustPlay) {
        this.volume = volume;
        this.frequency = frequency;
        if (mustPlay) {
            playRadio();
        } else {
            stopRadio();
        }
        display();
    }

    public void display() {
        if (isPLaying) {
            System.out.printf("%s is playing on frequency %f \n volume: %d", this.getClass().getName(), frequency, volume);
        } else {
            System.out.printf("%s isn't playing", this.getClass().getName());
        }
    }

}

