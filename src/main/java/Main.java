import task3.human.Human;
import task3.radio.Direction;
import task3.radio.Radio;
import task3.radio.RadioPlayer;
import task3.radio.primary.Button;
import task3.radio.primary.PrimaryRadioPlayer;
import task3.radio.primary.Wheel;
import task3.radio.smart.Display;
import task3.radio.smart.SmartRadioPlayer;

public class Main {
    public static void main(String[] args) {
        Human zafod = new Human("Zafod");

        Display display = new Display();
        Radio electronicRadio = new Radio();
        RadioPlayer smartRadioPlayer = new SmartRadioPlayer(electronicRadio, display);


//        zafod.registerObserver(display);
//        display.registerObserver(smartRadioPlayer);

        Button button = new Button();
        Wheel volumeWheel = new Wheel();
        Wheel frequencyWheel = new Wheel();
        Radio primaryRadio = new Radio();
        PrimaryRadioPlayer primaryRadioPlayer = new PrimaryRadioPlayer(primaryRadio, button, volumeWheel, frequencyWheel);
//
//        primaryRadio.registerObserver(primaryRadioPlayer);
//        button.registerObserver(primaryRadioPlayer);
//        volumeWheel.registerObserver(primaryRadioPlayer);
//        frequencyWheel.registerObserver(primaryRadioPlayer);

        zafod.press(button);
        zafod.twist(volumeWheel, Direction.RIGHT, 50);
        zafod.twist(frequencyWheel, Direction.LEFT, 10);

        zafod.press(button);
        zafod.wave(Direction.RIGHT, 50);
        zafod.wave(Direction.FORWARD, 15);
        zafod.wave(Direction.UP, 30);
        zafod.wave(Direction.LEFT, 100);

    }
}
