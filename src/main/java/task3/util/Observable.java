package task3.util;

import task3.radio.Direction;

public interface Observable {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();

    void notifyObservers(Direction direction, int waveValue);


}