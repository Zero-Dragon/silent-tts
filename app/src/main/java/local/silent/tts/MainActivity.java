package local.silent.tts;
import android.app.Activity;import android.os.Bundle;import android.content.Intent;import android.widget.*;
public final class MainActivity extends Activity {
 @Override public void onCreate(Bundle state){super.onCreate(state);LinearLayout layout=new LinearLayout(this);layout.setOrientation(LinearLayout.VERTICAL);int p=(int)(24*getResources().getDisplayMetrics().density);layout.setPadding(p,p,p,p);
 TextView title=new TextView(this);title.setText("Silent TTS");title.setTextSize(28);layout.addView(title);
 TextView info=new TextView(this);info.setText("Completes speech requests silently.");info.setTextSize(16);info.setPadding(0,p,0,p);layout.addView(info);
 Button settings=new Button(this);settings.setText("Open TTS settings");layout.addView(settings);settings.setOnClickListener(v->{try{startActivity(new Intent("com.android.settings.TTS_SETTINGS"));}catch(Exception e){startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));}});setContentView(layout);}
}

