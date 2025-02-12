package radio.primary;

import radio.Direction;
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
    public void update() {
        PrimaryRadio radio = (PrimaryRadio) this.getRadio();

        boolean shouldPlay = radio.getButton().isPressed();
        setPLaying(shouldPlay); //TODO

        if (radio.getVolumeWheel().getLastTwistedDegree() != WITHOUT_CHANGE_STATE) {
            Direction newVolumeDirection = radio.getVolumeWheel().getLastInteractionDirection();
            int newVolumeValue = Direction.RIGHT.equals(newVolumeDirection)
                    ? this.getVolume() + radio.getVolumeWheel().getLastTwistedDegree()
                    : this.getVolume() - radio.getVolumeWheel().getLastTwistedDegree();

            this.setVolume(newVolumeValue);

        }

        if (radio.getFrequencyWheel().getLastTwistedDegree() != WITHOUT_CHANGE_STATE) {
            Direction newFrequencyDirection = radio.getFrequencyWheel().getLastInteractionDirection();
            double newFrequencyValue = Direction.RIGHT.equals(newFrequencyDirection)
                    ? this.getFrequency() + radio.getFrequencyWheel().getLastTwistedDegree()
                    : this.getFrequency() - radio.getFrequencyWheel().getLastTwistedDegree();

            this.setFrequency(newFrequencyValue);
        }

        display();
        radio.getVolumeWheel().setWithoutChangeState();
        radio.getFrequencyWheel().setWithoutChangeState();
    }

}
