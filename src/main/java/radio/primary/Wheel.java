package radio.primary;

import exception.WheelDirectionException;
import lombok.Getter;
import radio.Direction;
import radio.smart.Observable;
import util.Observer;

import java.util.LinkedList;
import java.util.List;

@Getter
public abstract class Wheel implements Observable {
    protected final int WITHOUT_CHANGE_STATE = -1000;
    private List<Observer> observers = new LinkedList<>();
    private int lastTwistedDegree;
    private Direction lastInteractionDirection;

    Wheel() {
        lastInteractionDirection = Direction.NONE;
        lastTwistedDegree = WITHOUT_CHANGE_STATE;
    }

    public void setLastInteraction(Direction direction, int degree) throws WheelDirectionException {
        if (Direction.RIGHT.equals(direction) || Direction.LEFT.equals(direction)) {
            lastInteractionDirection = direction;
            lastTwistedDegree = degree;
            notifyObservers();
        } else {
            throw new WheelDirectionException("Invalid direction: " + direction);
        }

    }

    public void setWithoutChangeState() {
        lastInteractionDirection = Direction.NONE;
        lastTwistedDegree = WITHOUT_CHANGE_STATE;

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
