package task3.radio.smart;

import lombok.Getter;
import task3.exception.DisplayInteractionException;
import task3.radio.Direction;


@Getter
public class Display {

    protected final int MIN_WAVE_VALUE = 0;
    protected final int MAX_WAVE_VALUE = 100;
    protected final int WITHOUT_CHANGE_STATE = -1000;
    private Direction lastDirection;
    private int lastValue = WITHOUT_CHANGE_STATE;

    /**
     * @param waveValue can't be negative, interaction won't be completed.
     *                  In case when waveValue more than MAX_WAVE_VALUE - lastInteractionValue will be set to MAX_WAVE_VALUE
     */
    public void setLastInteractionDirection(Direction newDirection, int waveValue) throws DisplayInteractionException {
        lastDirection = newDirection;
        if (waveValue > MAX_WAVE_VALUE) {
            lastValue = MAX_WAVE_VALUE;
        } else if (waveValue <= MIN_WAVE_VALUE) {
            throw new DisplayInteractionException("Negative wave value");
        } else {
            lastValue = waveValue;
        }
//        notifyObservers(); //TODO enable
    }

    public void setWithoutChangeState() {
        lastDirection = Direction.NONE;
        lastValue = WITHOUT_CHANGE_STATE;

    }


    public void update(Direction direction, int waveValue) {
        try {
            setLastInteractionDirection(direction, waveValue);
        } catch (DisplayInteractionException e) { // cancel potential applied changes
            lastDirection = Direction.NONE;
            lastValue = WITHOUT_CHANGE_STATE;
            System.out.printf("Failed to interact with display. %s \n", e.getMessage());
        }

    }
}
