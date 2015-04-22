package com.delatowebs.posadaspremia;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class ListadoRegistroActivity extends ListActivity implements android.view.View.OnClickListener {

    Button btnAdd,btnGetAll;
    TextView persona_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,RegistroActivity.class);
            intent.putExtra("persona_Id",0);
            Intent intent1 = getIntent();
            String numeroDni = intent1.getStringExtra("numeroDni");
            intent.putExtra("numeroDni",numeroDni);
            startActivity(intent);

        }else {

            PersonaRepository repo = new PersonaRepository(this);

            ArrayList<HashMap<String, String>> listadoPersonas =  repo.getPersonaList();
            if(listadoPersonas.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        persona_Id = (TextView) view.findViewById(R.id.persona_Id);
                        String personaId = persona_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),PersonaDetalle.class);
                        objIndent.putExtra("persona_Id", Integer.parseInt( personaId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( ListadoRegistroActivity.this,listadoPersonas, R.layout.ver_persona, new String[] { "id","name"}, new int[] {R.id.persona_Id, R.id.nombrePersona});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No hay personas!",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_registro);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listado_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
