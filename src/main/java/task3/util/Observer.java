package task3.util;

import task3.radio.Direction;

public interface Observer {
    void update(Direction direction, int waveValue); // for display and human

    void update();
}
