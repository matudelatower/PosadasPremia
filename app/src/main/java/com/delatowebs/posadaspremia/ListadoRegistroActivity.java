package com.delatowebs.posadaspremia;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class ListadoRegistroActivity extends ListActivity {

    Bundle extras;
    String dniStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_registro);

        extras = getIntent().getExtras();

        dniStr = "111";
        if (getIntent().hasExtra("numeroDni")) {
            dniStr = extras.getString("numeroDni");
        }


        cargarListado();
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

    public void cargarListado() {
        PersonaRepository repo = new PersonaRepository(this);
//        Bundle extras = getIntent().getExtras();
//
//        String dniStr = extras.getString("numeroDni");
        ArrayList<HashMap<String, String>> listadoEncuestas = null;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            boolean isEmpty = extras.getBoolean("numeroDni", false);
            if (!isEmpty) {
                listadoEncuestas = repo.getPersonaListPorEncuestador(extras.getString("numeroDni"));
            }
        } else {
            listadoEncuestas = repo.getPersonaList();
            Button btn = (Button) findViewById(R.id.btnAdd);
            btn.setVisibility(View.GONE);
//            btn.setEnabled(false);

        }


        if (listadoEncuestas.size() != 0) {
            ListView lv = getListView();
//            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//                    encuesta_Id = (TextView) view.findViewById(R.id.encuesta_Id);
//                    String registroId = encuesta_Id.getText().toString();
//                    Intent objIndent = new Intent(getApplicationContext(),EncuestaDetalle.class);
//                    objIndent.putExtra("encuesta_Id", Integer.parseInt( registroId));
//                    startActivity(objIndent);
//                }
//            });
            ListAdapter adapter = new SimpleAdapter(ListadoRegistroActivity.this, listadoEncuestas, R.layout.item_persona, new String[]{"id", "nombre_completo", "documento", "creadoPor"}, new int[]{R.id.registroId, R.id.nombre_completo, R.id.documento, R.id.creadoPor});
            setListAdapter(adapter);
        } else {
            Toast.makeText(this, "No hay Personas!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Cerrar(View v) {
        finish();
    }

    public void EditarEncuesta(View v) {

        if (getIntent().hasExtra("numeroDni")) {

            //obetngo el id de la encuesta
            String registroId = ((TextView) v.findViewById(R.id.registroId)).getText().toString();

            TabletRepository tabletRepo = new TabletRepository(this);

            String nroEncuesta = tabletRepo.getTabletById(tabletRepo.getFirstTablet()).getIdTablet() + "00" + registroId;

            //llamo a la pantalla que contiene el cuestionario
            Intent i = new Intent(this, RegistroActivity.class);

            //envio el id de encuesta, de esta forma se identifica si se estaría editando la encuesta
            i.putExtra("cuestionarioId", registroId);
            i.putExtra("nroEncuesta", nroEncuesta);
            i.putExtra("numeroDni", getIntent().getExtras().getString("numeroDni"));
            startActivity(i);
        }
    }

    public void NuevaPersona(View v) {
        Intent i = new Intent(ListadoRegistroActivity.this, RegistroActivity.class);

        i.putExtra("numeroDni", dniStr);

//        startActivity(i);
        startActivityForResult(i, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if (resultCode == RESULT_CANCELED) {
                cargarListado();
            }
        }
    }//onActivityResult


}
