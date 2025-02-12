package radio.smart;

import radio.Observer;
import radio.Radio;
import radio.RadioPlayer;

public class SmartRadio extends Radio {
    private final Display display;

    public SmartRadio(RadioPlayer radioPlayer, Display display) {
        super(radioPlayer);
        this.display = display;
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void changeVolume(int volume) {
        super.changeVolume(volume);
    }

    @Override
    public void changeFrequency(double frequency) {
        super.changeFrequency(frequency);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : super.getObservers())
            observer.update(super.radioPlayer.getVolume(), super.radioPlayer.getFrequency(), radioPlayer.isPLaying());
    }

}
