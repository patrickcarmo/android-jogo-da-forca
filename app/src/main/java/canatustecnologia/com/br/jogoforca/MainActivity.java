package canatustecnologia.com.br.jogoforca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bStart1 = (Button) findViewById(R.id.bStart1);
        Button bStart2 = (Button) findViewById(R.id.bStart2);
        Button bSair   = (Button) findViewById(R.id.bSair);
        Button btnPalavra   = (Button) findViewById(R.id.btnPalavra);
        bStart1.setOnClickListener(this);
        bStart2.setOnClickListener(this);
        bSair.setOnClickListener(this);
        btnPalavra.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        switch (v.getId()) {
            case R.id.bStart1:
                i.putExtra("tipo", "jogador1");
                startActivity(i);
                break;
            case R.id.btnPalavra:
                i = new Intent(MainActivity.this, MainActivityPalavra.class);
                startActivity(i);
                break;
            case R.id.bStart2:
                i.putExtra("tipo", "jogador2");
                startActivity(i);
                break;
            case R.id.bSair:
                finish();
        }
    }

    public void irParaPalavras(View view){
        Intent i = new Intent(MainActivity.this, MainActivityPalavra.class);
        startActivity(i);
    }
}
