/**
 * Created by inf.varronen3108 on 15/03/2019.
 */

import javax.speech.Engine;
import javax.speech.Central;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Synthesizer;
import java.util.Locale;


public class TextToSpeech {

    public void ConvertingToSpeech(int numberOfAnswer){
        try{
            // what the speaker will say depending of the question of the guy
            String text = Answer(numberOfAnswer);

            // set property as Kevin Dictionary
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            // Register Engine
            Central.registerEngineCentral
                    ("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");

            // Create a Synthesizer
            Synthesizer synthesizer =
                    Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

            // Allocate synthesizer
            synthesizer.allocate();

            // Resume Synthesizer
            synthesizer.resume();

            // speaks the given text until queue is empty.
            synthesizer.speakPlainText(text, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

            // Deallocate the Synthesizer.
            synthesizer.deallocate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String Answer(int numberOfAnswer){
        String text = null;
        switch(numberOfAnswer){
            case 1:
                text = "buongiorno";
                break;
            case 2:
                text = "buonpomeriggio";
                break;
            case 3:
                text = "buonasera";
                break;
        }
        return text;
    }
}
