package radio;


import radio.smart.Direction;

public interface Observer {
    void update(int volume, double frequency, boolean mustPlay);
    void update();
}
