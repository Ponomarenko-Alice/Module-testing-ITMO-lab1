package task3.radio.primary;

import lombok.Getter;
import task3.exception.WheelDirectionException;
import task3.radio.Direction;
import task3.radio.Radio;
import task3.radio.RadioPlayer;

@Getter
public class PrimaryRadioPlayer extends RadioPlayer {
    private final Button button;
    private final Wheel volumeWheel;
    private final Wheel frequencyWheel;

    public PrimaryRadioPlayer(Radio radio, Button button, Wheel volumeWheel, Wheel frequencyWheel) {
        super(radio);
        this.button = button;
        this.volumeWheel = volumeWheel;
        this.frequencyWheel = frequencyWheel;
    }


    /**
     * Method collect status information from radio parts (button, volume and frequency wheels) and update
     * playing values (playing status - play or pause, volume and frequency).
     * If radioPlayer is already playing and received signal to play, do nothing.
     * Otherwise, if radioPlayer is already stopped and receiving signal to stop, do nothing.
     * Displays the result of changes.
     */

    private void handlePlayState() {
        boolean shouldPlay = getButton().isPressed();
        if (!radio.isPLaying() && shouldPlay) {
            togglePower(radio);
        } else if (radio.isPLaying() && !shouldPlay) {
            togglePower(radio);
        }
    }

    /**
     * Changing the volume logic: a new volume value is generated from the wheel scroll
     * value by adding or subtracting it from the current volume value //TODO проверить документацию
     * Guarantees that last twisted wheel direction is valid
     */
    private void handleVolumeChange() throws WheelDirectionException {
        if (volumeWheel.getLastTwistedDegree() != volumeWheel.getWITHOUT_CHANGE_STATE()) {
            Direction volumeDirection = volumeWheel.getLastInteractionDirection();
            if (Direction.RIGHT.equals(volumeDirection)) {
                volumeUpByValue(volumeWheel.getLastTwistedDegree());
            } else if (Direction.LEFT.equals(volumeDirection)) {
                volumeDownByValue(volumeWheel.getLastTwistedDegree());
            }
        }
    }

    /**
     * Changing the frequency logic: a new frequency value is generated from the wheel scroll
     * value by adding or subtracting it from the current frequency value
     * Guarantees that last twisted wheel direction is valid //TODO протестировать этот факт
     */
    private void handleFrequencyChange(Radio radio) throws WheelDirectionException {
        if (frequencyWheel.getLastTwistedDegree() != frequencyWheel.WITHOUT_CHANGE_STATE) {
            Direction newFrequencyDirection = frequencyWheel.getLastInteractionDirection();

            if (Direction.RIGHT.equals(newFrequencyDirection)) {
                frequencyUpByValue(frequencyWheel.getLastTwistedDegree());
            } else if (Direction.LEFT.equals(newFrequencyDirection)) {
                frequencyDownByValue(frequencyWheel.getLastTwistedDegree());
            } else {
                throw new WheelDirectionException("Invalid direction"); //TODO не забыть обработать в верхнесм уровне
            }
        }
    }

    /**
     * Reset change values after applying changes to avoid impact on the next updates
     */
    private void resetChangeState(Radio radio) {
        volumeWheel.setWithoutChangeState();
        frequencyWheel.setWithoutChangeState();
    }

}
