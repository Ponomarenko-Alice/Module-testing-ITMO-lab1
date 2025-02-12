package radio.smart;

import exception.DisplayInteractionException;
import lombok.Getter;
import radio.Direction;
import util.Observer;

import java.util.LinkedList;
import java.util.List;


@Getter
public class Display implements Observable, Observer {

    protected final int MIN_WAVE_VALUE = 0;
    protected final int MAX_WAVE_VALUE = 100;
    protected final int WITHOUT_CHANGE_STATE = -1000;
    private final List<Observer> observers = new LinkedList<>();
    private Direction lastInteractionDirection;
    private int lastInteractionValue = WITHOUT_CHANGE_STATE;

    /**
     * @param waveValue can't be negative, interaction won't be completed.
     *                  In case when waveValue more than MAX_WAVE_VALUE - lastInteractionValue will be set to MAX_WAVE_VALUE
     */
    public void setLastInteractionDirection(Direction newDirection, int waveValue) throws DisplayInteractionException {
        lastInteractionDirection = newDirection;
        if (waveValue > MAX_WAVE_VALUE) {
            this.lastInteractionValue = MAX_WAVE_VALUE;
        } else if (waveValue <= MIN_WAVE_VALUE) {
            throw new DisplayInteractionException("Negative wave value");
        } else {
            lastInteractionValue = waveValue;
        }
        notifyObservers();
    }

    public void setWithoutChangeState() {
        this.lastInteractionDirection = Direction.NONE;
        this.lastInteractionValue = WITHOUT_CHANGE_STATE;

    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    //unused for display, but should be overridden
    @Override
    public void update() {

    }

    @Override
    public void update(Direction direction, int waveValue) {
        try {
            setLastInteractionDirection(direction, waveValue);
        } catch (DisplayInteractionException e) { // cancel potential applied changes
            lastInteractionDirection = Direction.NONE;
            lastInteractionValue = WITHOUT_CHANGE_STATE;
            System.out.println("Failed to interact with display. " + e.getMessage());
        }

    }
}
