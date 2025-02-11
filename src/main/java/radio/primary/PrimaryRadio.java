package radio.primary;

import radio.Observer;
import radio.Radio;
import radio.RadioPlayer;

public class PrimaryRadio extends Radio {

    private final Button button;

    public PrimaryRadio(RadioPlayer radioPlayer, Button button) {
        super(radioPlayer);
        this.button = button;
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

    public Button getButton() {
        return button;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : super.getObservers())
            observer.update(super.radioPlayer.getVolume(), super.radioPlayer.getFrequency(), button.isPressed());
    }
}
