package com.delatowebs.posadaspremia;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        EditText txtNombre            = (EditText) findViewById(R.id.nombres);
        EditText txtApellidos         = (EditText) findViewById(R.id.apellidos);
        Spinner  spnTipoDoc           = (Spinner)  findViewById(R.id.tipoDocumento);
        EditText txtNroDoc            = (EditText) findViewById(R.id.numeroDocumento);
        EditText txtFechaNacimiento   = (EditText) findViewById(R.id.fechaNacimiento);
        Spinner  spnSexo              = (Spinner)  findViewById(R.id.sexo);
        EditText txtEmail             = (EditText) findViewById(R.id.email);
        EditText txtTelPrincipal      = (EditText) findViewById(R.id.telefonoPrincipal);
        EditText txtCuit              = (EditText) findViewById(R.id.cuit);
        Spinner  spnEstadoCivil       = (Spinner)  findViewById(R.id.estadoCivil);
        EditText txtTelSecundario     = (EditText) findViewById(R.id.telefonoSecundario);
        EditText txtDireccion         = (EditText) findViewById(R.id.direccionContacto);
        EditText txtNumero            = (EditText) findViewById(R.id.numeroPuerta);
        EditText txtDepartamento      = (EditText) findViewById(R.id.departamento);
        EditText txtPiso              = (EditText) findViewById(R.id.piso);


        Boolean formularioValido = true;

        if( txtNombre.getText().toString().trim().equals("")){
            txtNombre.setError( "El nombre es requerido" );
            formularioValido = false;
        }
        if(txtApellidos.getText().toString().trim().equals("")){
            txtApellidos.setError( "El apellido es requerido" );
            formularioValido = false;
        }
        if(txtNroDoc.getText().toString().trim().equals("")){
            txtNroDoc.setError( "El Nro. Documento es requerido" );
            formularioValido = false;
        }

        if(txtFechaNacimiento.getText().toString().trim().equals("")){
            txtFechaNacimiento.setError( "La fecha de nacimiento es requerida" );
            formularioValido = false;
        }

        if(spnTipoDoc.getSelectedItem().toString().trim().equals("")){
            ((TextView)spnTipoDoc.getSelectedView()).setError("Debe seleccionar al menos un tipo de Documento");
            formularioValido = false;
        }

        if(spnSexo.getSelectedItem().toString().trim().equals("")){
            ((TextView)spnSexo.getSelectedView()).setError("Debe seleccionar al menos un tipo de Sexo");
            formularioValido = false;
        }

        if(txtEmail.getText().toString().trim().equals("")){
            txtEmail.setError( "La direccion de correo es requerida" );
            formularioValido = false;
        }

        if(txtTelPrincipal.getText().toString().trim().equals("")){
            txtTelPrincipal.setError("El número de teléfono principal es requerido");
            formularioValido = false;
        }

        if(!formularioValido){
            Toast.makeText(getApplicationContext(), "El registro no se pudo completar, por favor revise que todos los campos sean válidos",
                    Toast.LENGTH_LONG).show();
        }else{

            try {

                Persona unaPersona = new Persona();

                unaPersona.setNombre(txtNombre.getText().toString());

                unaPersona.setApellido(txtApellidos.getText().toString());

                unaPersona.setDocumento(txtNroDoc.getText().toString());

                unaPersona.setTipoDocumento(spnTipoDoc.getSelectedItem().toString());

                unaPersona.setSexo(spnSexo.getSelectedItem().toString());

                unaPersona.setFechaNacimiento(txtFechaNacimiento.getText().toString());

                unaPersona.setEmail(txtEmail.getText().toString());

                unaPersona.setTelPrincipal(txtTelPrincipal.getText().toString());

                unaPersona.setCuit(txtCuit.getText().toString());

                unaPersona.setEstadoCivil(spnEstadoCivil.getSelectedItem().toString());

                unaPersona.setTelSecundario(txtTelSecundario.getText().toString());

                unaPersona.setDireccion(txtDireccion.getText().toString());

                unaPersona.setNumero(txtNumero.getText().toString());

                unaPersona.setDepartamento(txtDepartamento.getText().toString());

                unaPersona.setPiso(txtPiso.getText().toString());

                String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                unaPersona.setActualizado(fecha);

                unaPersona.setCreadoPor(this.nroDocumento);

                LinearLayout encuestaContenedor = (LinearLayout) findViewById(R.id.encuestaLayout);

                XmlGenerator xmlParser = new XmlGenerator();

                String xmlEncuesta = xmlParser.generarXml(encuestaContenedor);

                unaPersona.setCuestionario(xmlEncuesta);

                PersonaRepository personaRepo = new PersonaRepository(this);

                personaRepo.insert(unaPersona);

                Toast.makeText(getApplicationContext(), "El formulario se ha guardado correctamente.",
                        Toast.LENGTH_LONG).show();

                finish();

            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Hubo un errror al intentar guardar el formulario.",
                        Toast.LENGTH_LONG).show();
            }

        }
    }

    public void buscarContribuyente(View v) {
        //Lee archivo local
        PackageManager m = getPackageManager();
        String s = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("BusquedaPadronActivity", "Error Package name not found ", e);
        }


        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(s + "/padron.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Abre CSV
        CSVFile csvFile = new CSVFile(inputStream);

        ArrayList<Padron> padronList = csvFile.readPadron();

        Spinner spinnerTipoBusqueda = (Spinner) findViewById(R.id.tipoBusqueda);
        EditText txtBusqueda = (EditText) findViewById(R.id.numeroBusqueda);

        boolean busquedaValida = true;

        if (txtBusqueda.getText().toString().trim().equals("")) {
            txtBusqueda.setError("Debe ingresar un numero para su busqueda");
            busquedaValida = false;
        }

        if (spinnerTipoBusqueda.getSelectedItem().toString().trim().equals("")) {
            ((TextView) spinnerTipoBusqueda.getSelectedView()).setError("Debe seleccionar al menos un tipo de Sexo");
            busquedaValida = false;
        }

        if (!busquedaValida) {
            Toast.makeText(this, "Debe completar los campos para la busqueda.", Toast.LENGTH_SHORT).show();
            return;
        }

        String paramTipoBusqueda = spinnerTipoBusqueda.getSelectedItem().toString();
        String constraint = txtBusqueda.getText().toString().toLowerCase();

        ArrayList<Padron> filteredItems = new ArrayList<Padron>();

        if (constraint != null && constraint.toString().length() > 0) {


            for (int i = 0, l = padronList.size(); i < l; i++) {
                Padron padron = padronList.get(i);

                if (padron.toString(paramTipoBusqueda).toLowerCase().contains(constraint)) {
                    filteredItems.add(padron);
                    break;
                }

            }

        }

        Padron objPadron;
        if (filteredItems.size() > 0) {
            objPadron = filteredItems.get(0);
            Toast.makeText(this, "Contribuyente encontrado en Padron.", Toast.LENGTH_SHORT).show();
        } else {
            objPadron = new Padron();
            Toast.makeText(this, "Contribuyente NO encontrado en Padron.", Toast.LENGTH_SHORT).show();
        }


        String[] razonSocial = objPadron.getRazonSocial().split(",");
        String apellido = razonSocial[0];
        String nombre = razonSocial[1];
        EditText txtApellidos = (EditText) findViewById(R.id.apellidos);
        EditText txtNombres = (EditText) findViewById(R.id.nombres);
        EditText txtCuit = (EditText) findViewById(R.id.cuit);
        EditText txtDocumento = (EditText) findViewById(R.id.numeroDocumento);

        txtApellidos.setText(apellido);
        txtNombres.setText(nombre);
        txtCuit.setText(objPadron.getCuit());
        txtDocumento.setText(objPadron.getDocumento());
    }
}
