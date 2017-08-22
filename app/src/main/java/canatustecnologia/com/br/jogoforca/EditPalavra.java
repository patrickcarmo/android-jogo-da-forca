package canatustecnologia.com.br.jogoforca;

import java.util.HashMap;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

import canatustecnologia.com.br.jogoforca.utils.DBController;

/**
 * Created by PATRICK on 30/12/2016.
 */

public class EditPalavra extends Activity{
    EditText descricao;
    EditText dica;
    DBController controller = new DBController(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_palavra);
        descricao = (EditText) findViewById(R.id.descricao);
        dica = (EditText) findViewById(R.id.dica);
        Intent objIntent = getIntent();
        String id = objIntent.getStringExtra("id");
        Log.d("Lendo: ", "Lendo todas as palavras..");
        HashMap<String, String> palavraList = controller.getPalavraInfo(id);
        Log.d("descricao",palavraList.get("descricao"));
        Log.d("dica",palavraList.get("dica"));
        if(palavraList.size()!=0) {
            descricao.setText(palavraList.get("descricao"));
            dica.setText(palavraList.get("dica"));
        }
    }
    public void editPalavra(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        descricao = (EditText) findViewById(R.id.descricao);
        dica = (EditText) findViewById(R.id.dica);
        Intent objIntent = getIntent();
        String id = objIntent.getStringExtra("id");
        queryValues.put("id", id);
        queryValues.put("descricao", descricao.getText().toString());
        queryValues.put("dica", dica.getText().toString());

        controller.updatePalavra(queryValues);
        this.callHomeActivity(view);

    }
    public void removePalavra(View view) {
        Intent objIntent = getIntent();
        String id = objIntent.getStringExtra("id");
        controller.deletePalavra(id);
        this.callHomeActivity(view);

    }
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(objIntent);
    }
}


