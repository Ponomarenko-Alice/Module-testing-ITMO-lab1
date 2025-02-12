package radio;

import lombok.Getter;
import lombok.Setter;
import util.Observer;

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
        System.out.printf("Playing %s... \n", radio.getClass().getSimpleName());
        changePlayingStatus(true);
    }

    public void stopRadio() {
        System.out.printf("%s stopped. \n", radio.getClass().getSimpleName());
        changePlayingStatus(false);
    }

    /**
     * @param volume is checking for new valid volume value
     */
    public void changeVolumeRadio(int volume) {
        if (volume >= MIN_VOLUME) {
            setVolume(Math.min(volume, MAX_VOLUME));

        } else if (volume != WITHOUT_CHANGE_STATE) {
            setVolume(MIN_VOLUME);
        }
    }

    /**
     * @param frequency is checking for new valid frequency value
     */
    public void changeFrequencyRadio(double frequency) {
        if (frequency >= 0) {
            setFrequency(frequency);
        } else if (frequency != WITHOUT_CHANGE_STATE) {
            setFrequency(MIN_FREQUENCY);
        }
    }

    public void changePlayingStatus(boolean shouldPLay) {
        isPLaying = shouldPLay;
    }


    @Override
    public void update() {
    }

    public void display() {
        if (isPLaying) {
            System.out.printf("%s is playing on frequency: %f with volume: %d \n", getClass().getSimpleName(), frequency, volume);
        } else {
            System.out.printf("%s isn't playing\n", getClass().getSimpleName());
        }
    }

}

