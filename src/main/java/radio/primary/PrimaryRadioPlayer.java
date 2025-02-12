package radio.primary;

import radio.Direction;
import radio.RadioPlayer;

public class PrimaryRadioPlayer extends RadioPlayer {
    @Override
    public void changeVolumeRadio(int volume) { //TODO
        super.changeVolumeRadio(volume);
        System.out.println("Primary radio volume changed to " + volume);
    }

    @Override
    public void changeFrequencyRadio(double frequency) { //TODO
        super.changeFrequencyRadio(frequency);
        System.out.println("Primary radio frequency changed to " + frequency);
    }

    /**
     * Method collect status information from radio parts (button, volume anf frequency wheels) and update
     * playing values (playing status - play or pause, volume and frequency).
     * If radioPlayer is already playing and received signal to play, do nothing.
     * Otherwise, if radioPlayer is already stopped and receiving signal to stop, do nothing.
     * Displays the result of changes.
     */
    @Override
    public void update() {
        PrimaryRadio radio = (PrimaryRadio) this.getRadio();

        boolean shouldPlay = radio.getButton().isPressed();
        if (!isPLaying() && shouldPlay) {
            playRadio();
        } else if (isPLaying() && !shouldPlay) {
            stopRadio();
        }

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

        // to reset changes status after displaying (applying) result of changes
        radio.getVolumeWheel().setWithoutChangeState();
        radio.getFrequencyWheel().setWithoutChangeState();
    }

    //unused for display, but should be overridden
    @Override
    public void update(Direction direction, int waveValue) {
    }

}
