package radio.primary;

import radio.Direction;
import radio.RadioPlayer;

public class PrimaryRadioPlayer extends RadioPlayer {
    private final PrimaryRadio radio = (PrimaryRadio) getRadio();


    /**
     * Method collect status information from radio parts (button, volume and frequency wheels) and update
     * playing values (playing status - play or pause, volume and frequency).
     * If radioPlayer is already playing and received signal to play, do nothing.
     * Otherwise, if radioPlayer is already stopped and receiving signal to stop, do nothing.
     * Displays the result of changes.
     */
    @Override
    public void update() {
        handlePlayState();
        handleVolumeChange();
        handleFrequencyChange();
        display();
        resetChangeState();
    }

    private void handlePlayState() {
        boolean shouldPlay = radio.getButton().isPressed();
        if (!isPLaying() && shouldPlay) {
            playRadio();
        } else if (isPLaying() && !shouldPlay) {
            stopRadio();
        }
    }

    /**
     * Changing the volume logic: a new volume value is generated from the wheel scroll
     * value by adding or subtracting it from the current volume value
     */
    private void handleVolumeChange() {
        if (radio.getVolumeWheel().getLastTwistedDegree() != WITHOUT_CHANGE_STATE) {
            Direction volumeDirection = radio.getVolumeWheel().getLastInteractionDirection();
            int newVolume = Direction.RIGHT.equals(volumeDirection)
                    ? getVolume() + radio.getVolumeWheel().getLastTwistedDegree()
                    : getVolume() - radio.getVolumeWheel().getLastTwistedDegree();
            changeVolumeRadio(newVolume);
        }
    }

    /**
     * Changing the frequency logic: a new frequency value is generated from the wheel scroll
     * value by adding or subtracting it from the current frequency value
     */
    private void handleFrequencyChange() {
        if (radio.getFrequencyWheel().getLastTwistedDegree() != WITHOUT_CHANGE_STATE) {
            Direction newFrequencyDirection = radio.getFrequencyWheel().getLastInteractionDirection();
            double newFrequencyValue = Direction.RIGHT.equals(newFrequencyDirection)
                    ? getFrequency() + radio.getFrequencyWheel().getLastTwistedDegree()
                    : getFrequency() - radio.getFrequencyWheel().getLastTwistedDegree();

            super.changeFrequencyRadio(newFrequencyValue);
        }
    }

    /**
     * Reset change values after applying changes to avoid impact on the next updates
     */
    private void resetChangeState() {
        radio.getVolumeWheel().setWithoutChangeState();
        radio.getFrequencyWheel().setWithoutChangeState();
    }

    //unused for display, but should be overridden
    @Override
    public void update(Direction direction, int waveValue) {
    }
}
