package canatustecnologia.com.br.jogoforca;

import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import canatustecnologia.com.br.jogoforca.utils.DBController;

public class NewPalavra extends Activity{
    EditText descricao;
    EditText dica;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_palavra);
        descricao = (EditText) findViewById(R.id.descricao);
        dica = (EditText) findViewById(R.id.dica);
    }
    public void addNewPalavra(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        queryValues.put("descricao", descricao.getText().toString());
        queryValues.put("dica", dica.getText().toString());
        controller.insertPalavra(queryValues);
        this.voltarTela(view);
    }
    public void voltarTela(View view) {
        Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(objIntent);
    }
}

