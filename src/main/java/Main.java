import radio.Radio;
import radio.primary.Button;
import radio.primary.PrimaryRadioPlayer;
import radio.primary.PrimaryRadio;

import radio.smart.Display;
import radio.smart.SmartRadio;
import radio.smart.SmartRadioPlayer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Human zafod = new Human("Zafod");
        Display display = new Display();
        Radio electronicRadio = new SmartRadio(new SmartRadioPlayer(), display);
        Button button = new Button();
        PrimaryRadioPlayer primaryRadioPlayer = new PrimaryRadioPlayer();
        Radio primaryRadio = new PrimaryRadio(primaryRadioPlayer, button); // doesn't work

        primaryRadio.registerObserver(primaryRadioPlayer);
        button.registerObserver(primaryRadioPlayer);

        zafod.press(button);
        Thread.sleep(100);

        zafod.press(button);
    }
}
