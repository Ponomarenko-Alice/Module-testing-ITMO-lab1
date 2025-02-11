package radio;

public interface Observer {
    void update(int volume, double frequency, boolean mustPlay);
    void update(boolean isPressed);
}
