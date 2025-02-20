package task3.radio.primary;

import lombok.Getter;
import task3.exception.WheelDirectionException;
import task3.radio.Direction;

@Getter
public class Wheel {
    protected final int WITHOUT_CHANGE_STATE = -1000;
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
        } else {
            throw new WheelDirectionException("Invalid direction: " + direction);
        }

    }

    public void setWithoutChangeState() {
        lastInteractionDirection = Direction.NONE;
        lastTwistedDegree = WITHOUT_CHANGE_STATE;

    }

}
