package local.silent.tts;
import android.app.Activity;import android.os.Bundle;import android.content.Intent;import android.speech.tts.TextToSpeech;import java.util.*;
public final class CheckActivity extends Activity {
 @Override public void onCreate(Bundle state){super.onCreate(state);ArrayList<String> voices=new ArrayList<>();
 for(Locale locale:Locale.getAvailableLocales()){try{String l=locale.getISO3Language(),c=locale.getISO3Country();if(!l.isEmpty()){String tag=l+(c.isEmpty()?"":"-"+c);if(!voices.contains(tag))voices.add(tag);}}catch(MissingResourceException ignored){}}
 Intent result=new Intent();result.putStringArrayListExtra(TextToSpeech.Engine.EXTRA_AVAILABLE_VOICES,voices);result.putStringArrayListExtra(TextToSpeech.Engine.EXTRA_UNAVAILABLE_VOICES,new ArrayList<String>());setResult(TextToSpeech.Engine.CHECK_VOICE_DATA_PASS,result);finish();}
}
