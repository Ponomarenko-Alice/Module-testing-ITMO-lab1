package task3.radio.primary;

import lombok.Getter;
import task3.exception.WheelDirectionException;
import task3.radio.Direction;
import task3.util.Observable;
import task3.util.Observer;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Wheel implements Observable {
    protected final int WITHOUT_CHANGE_STATE = -1000;
    List<Observer> observers = new ArrayList<>();
    private int lastTwistedDegree;
    private Direction lastInteractionDirection;


    public Wheel() {
        lastInteractionDirection = Direction.NONE;
        lastTwistedDegree = WITHOUT_CHANGE_STATE;
    }

    public void setLastInteraction(Direction direction, int degree) throws WheelDirectionException {
        if (Direction.RIGHT.equals(direction) || Direction.LEFT.equals(direction)) {
            lastInteractionDirection = direction;
            lastTwistedDegree = degree;
            notifyObservers();
        } else if (Direction.NONE.equals(direction)) {
            //do nothing
        } else {
            throw new WheelDirectionException("Invalid direction: " + direction);
        }


    }

    public void setWithoutChangeState() {
        lastInteractionDirection = Direction.NONE;
        lastTwistedDegree = WITHOUT_CHANGE_STATE;
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
     * Notifying PrimaryRadioPlayer about wheel changing
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


    @Override
    public void notifyObservers(Direction direction, int waveValue) {
        //unused
    }


}
