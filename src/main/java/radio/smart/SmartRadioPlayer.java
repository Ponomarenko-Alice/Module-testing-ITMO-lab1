package radio.smart;

import radio.RadioPlayer;

public class SmartRadioPlayer extends RadioPlayer {

    @Override
    public void playRadio() {
        System.out.println("song");
    }

    @Override
    public void stopRadio() {
        System.out.println("stop");
    }

    @Override
    public void changeVolumeRadio(int volume) {
        System.out.println("changeV");

    }

    @Override
    public void changeFrequencyRadio(double frequency) {
        System.out.println("changeF");

    }

    @Override
    public void update(int volume, double frequency, boolean mustPlay) {

    }
    @Override
    public void update(boolean mustPlay) {

    }

}
