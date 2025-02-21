package task3.radio.smart;

import lombok.Getter;
import task3.exception.DisplayInteractionException;
import task3.radio.Direction;
import task3.util.Observable;
import task3.util.Observer;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Display implements Observer, Observable {

    protected final int MIN_WAVE_VALUE = 0;
    protected final int MAX_WAVE_VALUE = 100;
    protected final int WITHOUT_CHANGE_STATE = -1000;
    private Direction lastDirection;
    private int lastValue = WITHOUT_CHANGE_STATE;

    private List<Observer> observers = new ArrayList<>();

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
        notifyObservers();
    }

    public void setWithoutChangeState() {
        lastDirection = Direction.NONE;
        lastValue = WITHOUT_CHANGE_STATE;

    }

    /**
     * Observer for human
     */
    public void update(Direction direction, int waveValue) {
        try {
            setLastInteractionDirection(direction, waveValue);
        } catch (DisplayInteractionException e) { // cancel potential applied changes
            System.out.printf("Failed to interact with display. %s \n", e.getMessage());
            resetLastValues();
        }

    }

    private void resetLastValues() {
        lastDirection = Direction.NONE;
        lastValue = WITHOUT_CHANGE_STATE;
    }

    @Override
    public void update() {
        //unused
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifying SmartRadioPlayer about display changing
     */
    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObservers(Direction direction, int waveValue) {
        //unused
    }
}
