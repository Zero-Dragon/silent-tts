package local.silent.tts;
import android.speech.tts.*;
import android.media.AudioFormat;
import java.util.*;
public final class SilentService extends TextToSpeechService {
 private static final String VOICE="silent";
 private volatile String[] language={"eng","USA",""};
 @Override protected String[] onGetLanguage(){return language.clone();}
 @Override protected int onIsLanguageAvailable(String l,String c,String v){return TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE;}
 @Override protected int onLoadLanguage(String l,String c,String v){language=new String[]{l==null?"":l,c==null?"":c,v==null?"":v};return TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE;}
 @Override public List<Voice> onGetVoices(){return Collections.singletonList(new Voice(VOICE,Locale.ROOT,Voice.QUALITY_NORMAL,Voice.LATENCY_VERY_LOW,false,Collections.emptySet()));}
 @Override public String onGetDefaultVoiceNameFor(String l,String c,String v){return VOICE;}
 @Override public int onIsValidVoiceName(String n){return VOICE.equals(n)?TextToSpeech.SUCCESS:TextToSpeech.ERROR;}
 @Override public int onLoadVoice(String n){return onIsValidVoiceName(n);}
 @Override protected void onStop(){}
 @Override protected void onSynthesizeText(SynthesisRequest request,SynthesisCallback callback){
  // Complete the protocol without reading text or emitting audio samples.
  if(callback.start(16000,AudioFormat.ENCODING_PCM_16BIT,1)==TextToSpeech.SUCCESS) callback.done();
 }
}
