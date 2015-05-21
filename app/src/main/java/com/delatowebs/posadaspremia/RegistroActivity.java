package com.delatowebs.posadaspremia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class RegistroActivity extends ActionBarActivity {

    Button btnSave;
    Button btnClose;
    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextDocumento;
    EditText editTextCuit;
    EditText editTextFechaNacimiento;
    EditText editTextMail;
    EditText editTextTelPrincipal;
    EditText editTextTelSecundario;
    EditText editTextDireccion;
    EditText editTextNumero;
    EditText editTextDepartamento;
    EditText editTextPiso;
    Spinner spinnerTipoDocumento;
    Spinner spinnerSexo;
    Spinner spinnerEstadoCivil;

    private int _Persona_Id = 0;

    private String nroDocumento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_persona_detalle);
        //setContentView(R.layout.fragment_persona_detalle);
        setContentView(R.layout.activity_registro);

        findViewById(R.id.tipoBusqueda).requestFocus();


        Bundle bundle = getIntent().getExtras();
        this.nroDocumento = bundle.getString("numeroDni");


//        editTextApellido = (EditText) findViewById(R.id.editTextApellido);
//        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
//        editTextDocumento = (EditText) findViewById(R.id.editTextDocumento);
//        editTextCuit = (EditText) findViewById(R.id.editTextCuit);
//        editTextFechaNacimiento = (EditText) findViewById(R.id.editTextFechaNacimiento);
//        editTextTelPrincipal = (EditText) findViewById(R.id.editTextTelPrincipal);
//        editTextTelSecundario = (EditText) findViewById(R.id.editTextTelSecundario);
//        editTextDireccion = (EditText) findViewById(R.id.editTextDireccion);
//        editTextNumero = (EditText) findViewById(R.id.editTextNumero);
//        editTextDepartamento = (EditText) findViewById(R.id.editTextDepartamento);
//        editTextPiso = (EditText) findViewById(R.id.editTextPiso);
//        editTextMail = (EditText) findViewById(R.id.editTextMail);
//
//        spinnerTipoDocumento= (Spinner) findViewById(R.id.spinnerTipoDocumento);
//        spinnerSexo= (Spinner) findViewById(R.id.spinnerSexo);
//        spinnerEstadoCivil= (Spinner) findViewById(R.id.spinnerEstadoCivil);


//        _Persona_Id =0;
//        Intent intent = getIntent();
//        _Persona_Id =intent.getIntExtra("persona_Id", 0);
//        PersonaRepository repo = new PersonaRepository(this);
//        Persona persona = new Persona();
//        persona = repo.getPersonaById(_Persona_Id);
//
//
//        editTextApellido.setText(persona.getApellido());
//        editTextNombre.setText(persona.getNombre());
//        editTextDocumento.setText(persona.getDocumento());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);

        switch (item.getItemId()) {

            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent i = new Intent(RegistroActivity.this, ListadoRegistroActivity.class);

                i.putExtra("numeroDni", this.nroDocumento);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //    public void onClick(View view) {
//        if (view == findViewById(R.id.btnSave)){
//            PersonaRepository repo = new PersonaRepository(this);
//            Persona persona = new Persona();
//
//            persona.setNombre(editTextNombre.getText().toString());
//            persona.setApellido(editTextApellido.getText().toString());
//            persona.setDocumento(editTextDocumento.getText().toString());
//            persona.setCuit(editTextCuit.getText().toString());
//            persona.setFechaNacimiento(editTextFechaNacimiento.getText().toString());
//            persona.setTelPrincipal(editTextTelPrincipal.getText().toString());
//            persona.setTelSecundario(editTextTelSecundario.getText().toString());
//            persona.setTelSecundario(editTextTelSecundario.getText().toString());
//            persona.setDireccion(editTextDireccion.getText().toString());
//            persona.setNumero(editTextNumero.getText().toString());
//            persona.setDepartamento(editTextDepartamento.getText().toString());
//            persona.setEmail(editTextMail.getText().toString());
//            persona.setPiso(editTextPiso.getText().toString());
//            Intent intent1 = getIntent();
//            String numeroDni = intent1.getStringExtra("numeroDni");
//
//            persona.setCreadoPor(numeroDni);
//
//
//            persona.setId(_Persona_Id);
//
//            if (_Persona_Id==0){
//                _Persona_Id = repo.insert(persona);
//
//                Toast.makeText(this, "Persona Creada", Toast.LENGTH_SHORT).show();
//            }else{
//
//                repo.update(persona);
//                Toast.makeText(this,"Persona Actualizada",Toast.LENGTH_SHORT).show();
//            }
//        }else if (view== findViewById(R.id.btnDelete)){
//            PersonaRepository repo = new PersonaRepository(this);
//            repo.delete(_Persona_Id);
//            Toast.makeText(this, "Persona Eliminada", Toast.LENGTH_SHORT);
//            finish();
//        }else if (view== findViewById(R.id.btnClose)){
//            finish();
//        }
//
//
//    }
    public void datePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();

        //seteeo el EditText asociado al DatePicker
        newFragment.setEditTextAsociado((EditText) v);

        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void guardarRegistro(View v) {

    }
}
