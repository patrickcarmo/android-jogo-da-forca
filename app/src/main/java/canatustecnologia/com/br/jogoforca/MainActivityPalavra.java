package canatustecnologia.com.br.jogoforca;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ListView;

import canatustecnologia.com.br.jogoforca.utils.DBController;

public class MainActivityPalavra extends ListActivity {
    Intent intent;
    TextView _id;
    DBController controller = new DBController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_palavra);
        ArrayList<HashMap<String, String>> palavraList =  controller.getAllPalavras();
        if(palavraList.size()!=0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    _id = (TextView) view.findViewById(R.id.id);
                    String valid = _id.getText().toString();
                    Intent  objIndent = new Intent(getApplicationContext(),EditPalavra.class);
                    objIndent.putExtra("id", valid);
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter = new SimpleAdapter( MainActivityPalavra.this, palavraList, R.layout.view_palavra_entry, new String[] { "id","descricao"}, new int[] {R.id.id, R.id.descricao});
            setListAdapter(adapter);
        }
    }
    public void showAddForm(View view) {
        Intent objIntent = new Intent(getApplicationContext(), NewPalavra.class);
        startActivity(objIntent);
    }
}

