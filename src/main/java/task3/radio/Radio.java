package task3.radio;

import lombok.Getter;

@Getter
public class Radio {
    protected final int INITIAL_VOLUME = 20;
    protected final int MIN_VOLUME = 0;
    protected final int MAX_VOLUME = 100;
    protected final int INITIAL_FREQUENCY = 20;
    protected final int MIN_FREQUENCY = 0;
    protected final int WITHOUT_CHANGE_STATE = -1000;
    private int volume;
    private double frequency;
    private boolean isPLaying;


    public Radio() {
        this.volume = INITIAL_VOLUME;
        this.frequency = INITIAL_FREQUENCY;
        this.isPLaying = false;
    }


    public void enable() {
        isPLaying = true;
    }

    public void disable() {
        isPLaying = false;
    }

    public void setVolume(int newVolume) {
        if (newVolume >= MIN_VOLUME) {
            volume = Math.min(newVolume, MAX_VOLUME);
        } else if (newVolume != WITHOUT_CHANGE_STATE) {
            volume = MIN_VOLUME;
        }
    }

    public void setFrequency(double frequency) {
        if (frequency >= 0) {
            this.frequency = frequency;
        } else if (frequency != WITHOUT_CHANGE_STATE) {
            this.frequency = MIN_FREQUENCY;
        }
    }

    public void display() {
        if (isPLaying()) {
            System.out.printf("%s is playing on frequency: %f with volume: %d \n", getClass().getSimpleName(), frequency, volume);
        } else {
            System.out.printf("%s isn't playing\n", getClass().getSimpleName());
        }
    }

}
