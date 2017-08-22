package canatustecnologia.com.br.jogoforca;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashscreenActivity extends Activity implements Runnable {

    private final int DELAY = 3000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Handler handler = new Handler();
        handler.postDelayed(this, DELAY);
    }

    public void run() {
        Intent i = new Intent(SplashscreenActivity.this, MainActivity.class);
        startActivity(i);
        SplashscreenActivity.this.finish();
    }
}
