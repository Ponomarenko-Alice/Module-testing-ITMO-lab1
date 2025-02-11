package radio.primary;

import radio.RadioPlayer;

public class PrimaryRadioPlayer extends RadioPlayer {

    @Override
    public void playRadio() {
        System.out.println("lalala primary");
    }

    @Override
    public void stopRadio() {
        System.out.println("primary radio stopped");
    }

    @Override
    public void changeVolumeRadio(int volume) {
        System.out.println("primary radio volume");
    }

    @Override
    public void changeFrequencyRadio(double frequency) {
        System.out.println("primary radio frequency");
    }

    @Override
    public void update(int volume, double frequency, boolean mustPlay) {
        if (mustPlay) {
            playRadio();
        } else {
            stopRadio();
        }
    }

    // Update method for button observer
    @Override
    public void update(boolean isPressed) {
        if (isPressed) {
            playRadio();
        } else {
            stopRadio();
        }
    }


}
