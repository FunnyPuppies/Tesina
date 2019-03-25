import javax.swing.*;
import javax.swing.text.Utilities;

/**
 * Created by inf.varronen3108 on 15/03/2019.
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int numberOfAnswer = 0;
                TextToSpeech tts = new TextToSpeech();
                tts.ConvertingToSpeech(numberOfAnswer);
            }
        });
    }
}
