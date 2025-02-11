import radio.Radio;
import radio.primary.Button;
import radio.primary.PrimaryRadio;
import radio.primary.PrimaryRadioPlayer;
import radio.smart.SmartRadio;
import radio.smart.SmartRadioPlayer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Human zafod = new Human("Zafod");
        Radio electronicRadio = new SmartRadio(new SmartRadioPlayer());
        Button radioButton = new Button();
        PrimaryRadioPlayer primaryRadioPlayer = new PrimaryRadioPlayer();
        Radio primaryRadio = new PrimaryRadio(primaryRadioPlayer, radioButton);

        primaryRadio.registerObserver(primaryRadioPlayer);
        radioButton.registerObserver(primaryRadioPlayer);

        zafod.press(radioButton);
        Thread.sleep(100);

        zafod.press(radioButton);
    }
}
