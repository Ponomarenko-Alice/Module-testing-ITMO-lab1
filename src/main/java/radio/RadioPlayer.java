package radio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RadioPlayer implements Observer {

    protected final int INITIAL_VOLUME = 20;
    protected final int MIN_VOLUME = 0;
    protected final int MAX_VOLUME = 100;
    protected final int INITIAL_FREQUENCY = 20;
    protected final int MIN_FREQUENCY = 0;
    protected final int WITHOUT_CHANGE_STATE = -1000;
    private int volume;
    private double frequency;
    private boolean isPLaying;
    private Radio radio;

    public RadioPlayer() {
        this.volume = INITIAL_VOLUME;
        this.frequency = INITIAL_FREQUENCY;
        this.isPLaying = false;
    }

    public void playRadio() {
    }

    public void stopRadio() {
    }

    public void changeVolumeRadio(int volume) {
        if (volume >= MIN_VOLUME) {
            if (volume <= MAX_VOLUME) {
                this.setVolume(volume);
            } else {
                this.setVolume(MAX_VOLUME);
            }

        } else if (volume != WITHOUT_CHANGE_STATE) {
            this.setVolume(MIN_VOLUME);
        }
    }

    public void changeFrequencyRadio(double frequency) {
        if (frequency >= 0) {
            this.setFrequency(frequency);
        } else if (frequency != WITHOUT_CHANGE_STATE) {
            this.setFrequency(MIN_FREQUENCY);
        }
    }

    public void changePlayingStatus(boolean shouldPLay) {
        this.isPLaying = shouldPLay;
    }


    @Override
    public void update() {
    }

    public void display() {
        if (isPLaying) {
            System.out.printf("%s is playing on frequency: %f with volume: %d \n", this.getClass().getSimpleName(), frequency, volume);
        } else {
            System.out.printf("%s isn't playing", this.getClass().getSimpleName());
        }
    }

}

