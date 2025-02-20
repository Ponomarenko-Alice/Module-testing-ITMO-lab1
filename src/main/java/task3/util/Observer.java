package task3.util;

import task3.radio.Direction;
import task3.radio.Radio;

public abstract class Observer {
    public abstract void update(Direction direction, int waveValue); // for smart radio (which is observer)


    public abstract void update(); // for button observer

    public abstract void update(Radio radio);
}
