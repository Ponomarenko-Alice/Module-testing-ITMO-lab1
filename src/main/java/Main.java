import radio.Direction;
import radio.Radio;
import radio.RadioPlayer;
import radio.primary.*;
import radio.smart.Display;
import radio.smart.SmartRadio;
import radio.smart.SmartRadioPlayer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Human zafod = new Human("Zafod");

        Display display = new Display();
        RadioPlayer smartRadioPlayer = new SmartRadioPlayer();
        Radio electronicRadio = new SmartRadio(smartRadioPlayer, display);
        smartRadioPlayer.setRadio(electronicRadio);
        display.registerObserver(smartRadioPlayer);

        Button button = new Button();
        Wheel volumeWheel = new VolumeWheel();
        Wheel frequencyWheel = new FrequencyWheel();
        PrimaryRadioPlayer primaryRadioPlayer = new PrimaryRadioPlayer();
        Radio primaryRadio = new PrimaryRadio(primaryRadioPlayer, button, volumeWheel, frequencyWheel);
        primaryRadioPlayer.setRadio(primaryRadio);

        primaryRadio.registerObserver(primaryRadioPlayer);
        button.registerObserver(primaryRadioPlayer);
        volumeWheel.registerObserver(primaryRadioPlayer);
        frequencyWheel.registerObserver(primaryRadioPlayer);

        zafod.press(button);

        zafod.twist(volumeWheel, Direction.RIGHT, 50);

        zafod.twist(frequencyWheel, Direction.LEFT, 10);

        zafod.press(button);

        zafod.wave(Direction.RIGHT);
        Thread.sleep(100);

    }
}
