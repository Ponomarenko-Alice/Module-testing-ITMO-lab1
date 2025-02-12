package human;

import radio.Direction;
import util.Observer;

public interface Observable {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(Direction direction, int waveValue);

}