package util;

import radio.Direction;

public interface Observer {
    void update();

    void update(Direction direction, int waveValue);
}
