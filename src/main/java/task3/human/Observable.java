package task3.human;

import task3.radio.Direction;
import task3.util.Observer;

public interface Observable {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(Direction direction, int waveValue);

}