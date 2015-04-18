package com.delatowebs.posadaspremia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonaDetalle extends ActionBarActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextRazonSocial;
    EditText editTextDocumento;
    EditText editTextDomicilio;
    private int _Persona_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_persona_detalle);
        setContentView(R.layout.fragment_persona_detalle);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextRazonSocial = (EditText) findViewById(R.id.editTextRazonSocial);
        editTextDocumento = (EditText) findViewById(R.id.editTextDocumento);
        editTextDomicilio = (EditText) findViewById(R.id.editTextDomicilio);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Persona_Id =0;
        Intent intent = getIntent();
        _Persona_Id =intent.getIntExtra("persona_Id", 0);
        PersonaRepository repo = new PersonaRepository(this);
        Persona persona = new Persona();
        persona = repo.getPersonaById(_Persona_Id);

        editTextDomicilio.setText(String.valueOf(persona.getDomicilio()));
        editTextRazonSocial.setText(persona.getRazonSocial());
        editTextDocumento.setText(persona.getDocumento());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_persona_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            PersonaRepository repo = new PersonaRepository(this);
            Persona persona = new Persona();
            persona.setDomicilio(editTextDomicilio.getText().toString());
            persona.setDocumento(editTextDocumento.getText().toString());
            persona.setRazonSocial(editTextRazonSocial.getText().toString());
            persona.setId(_Persona_Id);

            if (_Persona_Id==0){
                _Persona_Id = repo.insert(persona);

                Toast.makeText(this,"Persona Creada",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(persona);
                Toast.makeText(this,"Persona Actualizada",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            PersonaRepository repo = new PersonaRepository(this);
            repo.delete(_Persona_Id);
            Toast.makeText(this, "Persona Eliminada", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}