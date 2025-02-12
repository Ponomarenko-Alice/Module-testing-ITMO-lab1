package radio.primary;

import radio.RadioPlayer;

public class PrimaryRadioPlayer extends RadioPlayer {

    @Override
    public void playRadio() {
        System.out.println("Playing primary radio...");
    }

    @Override
    public void stopRadio() {
        System.out.println("Primary radio stopped.");
    }

    @Override
    public void changeVolumeRadio(int volume) {
        super.changeVolumeRadio(volume);
        System.out.println("Primary radio volume changed to " + volume);
    }

    @Override
    public void changeFrequencyRadio(double frequency) {
        super.changeFrequencyRadio(frequency);
        System.out.println("Primary radio frequency changed to " + frequency);
    }

    @Override
    public void update(int volume, double frequency, boolean mustPlay) {
        if (mustPlay) {
            playRadio();
        } else {
            stopRadio();
        }
        System.out.println("Updated frequency: " + frequency + ", volume: " + volume);
    }

    @Override
    public void update() {
        System.out.printf("пересмотреть "); //TODO
    }


}
