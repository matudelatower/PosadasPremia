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


    private String nroDocumento;


    private Boolean editMode = false;

    private int registroId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_persona_detalle);
        //setContentView(R.layout.fragment_persona_detalle);
        setContentView(R.layout.activity_registro);

        findViewById(R.id.tipoBusqueda).requestFocus();


        Bundle bundle = getIntent().getExtras();

        this.nroDocumento = bundle.getString("numeroDni");


        if (bundle.containsKey("registroId")) {

            this.editMode = true;

            this.registroId = Integer.parseInt(bundle.getString("registroId"));

            editarRegistro();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


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


    public void datePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();

        //seteeo el EditText asociado al DatePicker
        newFragment.setEditTextAsociado((EditText) v);

        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void guardarRegistro(View v) {

        EditText txtNombre = (EditText) findViewById(R.id.nombres);
        EditText txtApellidos = (EditText) findViewById(R.id.apellidos);
        Spinner spnTipoDoc = (Spinner) findViewById(R.id.tipoDocumento);
        EditText txtNroDoc = (EditText) findViewById(R.id.numeroDocumento);
        EditText txtFechaNacimiento = (EditText) findViewById(R.id.fechaNacimiento);
        Spinner spnSexo = (Spinner) findViewById(R.id.sexo);
        EditText txtEmail = (EditText) findViewById(R.id.email);
        EditText txtTelPrincipal = (EditText) findViewById(R.id.telefonoPrincipal);
        EditText txtCuit = (EditText) findViewById(R.id.cuit);
        EditText txtNumeroPartida = (EditText) findViewById(R.id.numeroPartida);
        Spinner spnEstadoCivil = (Spinner) findViewById(R.id.estadoCivil);
        EditText txtTelSecundario = (EditText) findViewById(R.id.telefonoSecundario);
        EditText txtDireccion = (EditText) findViewById(R.id.direccionContacto);
        EditText txtNumero = (EditText) findViewById(R.id.numeroPuerta);
        EditText txtDepartamento = (EditText) findViewById(R.id.departamento);
        EditText txtPiso = (EditText) findViewById(R.id.piso);


        Boolean formularioValido = true;

        if (txtNombre.getText().toString().trim().equals("")) {
            txtNombre.setError("El nombre es requerido");
            formularioValido = false;
        }
        if (txtApellidos.getText().toString().trim().equals("")) {
            txtApellidos.setError("El apellido es requerido");
            formularioValido = false;
        }
        if (txtNroDoc.getText().toString().trim().equals("")) {
            txtNroDoc.setError("El Nro. Documento es requerido");
            formularioValido = false;
        }

        if (txtFechaNacimiento.getText().toString().trim().equals("")) {
            txtFechaNacimiento.setError("La fecha de nacimiento es requerida");
            formularioValido = false;
        }

        if (spnTipoDoc.getSelectedItem().toString().trim().equals("")) {
            ((TextView) spnTipoDoc.getSelectedView()).setError("Debe seleccionar al menos un tipo de Documento");
            formularioValido = false;
        }

        if (spnSexo.getSelectedItem().toString().trim().equals("")) {
            ((TextView) spnSexo.getSelectedView()).setError("Debe seleccionar al menos un tipo de Sexo");
            formularioValido = false;
        }

        if (txtEmail.getText().toString().trim().equals("")) {
            txtEmail.setError("La direccion de correo es requerida");
            formularioValido = false;
        }

        if (txtTelPrincipal.getText().toString().trim().equals("")) {
            txtTelPrincipal.setError("El número de teléfono principal es requerido");
            formularioValido = false;
        }

        if (!formularioValido) {
            Toast.makeText(getApplicationContext(), "El registro no se pudo completar, por favor revise que todos los campos sean válidos",
                    Toast.LENGTH_LONG).show();
        } else {

            try {

                PersonaRepository personaRepo = new PersonaRepository(this);

                Persona unaPersona = new Persona();

                if (this.editMode) {
                    unaPersona = personaRepo.getPersonaById(this.registroId);
                }

                unaPersona.setNombre(txtNombre.getText().toString());

                unaPersona.setApellido(txtApellidos.getText().toString());

                unaPersona.setDocumento(txtNroDoc.getText().toString());

                unaPersona.setTipoDocumento(spnTipoDoc.getSelectedItem().toString());

                unaPersona.setSexo(spnSexo.getSelectedItem().toString());

                unaPersona.setFechaNacimiento(txtFechaNacimiento.getText().toString());

                unaPersona.setEmail(txtEmail.getText().toString());

                unaPersona.setTelPrincipal(txtTelPrincipal.getText().toString());

                unaPersona.setCuit(txtCuit.getText().toString());

                unaPersona.setNumeroPartida(txtNumeroPartida.getText().toString());

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

                if (!this.editMode){
                    personaRepo.insert(unaPersona);
                }else{
                    personaRepo.update(unaPersona);
                }

                Toast.makeText(getApplicationContext(), "El formulario se ha guardado correctamente.",
                        Toast.LENGTH_LONG).show();

                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();


            } catch (Exception e) {
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

            String[] razonSocial = objPadron.getRazonSocial().split(",");
            String apellido = razonSocial[0];
            String nombre = razonSocial[1];
            EditText txtApellidos = (EditText) findViewById(R.id.apellidos);
            EditText txtNombres = (EditText) findViewById(R.id.nombres);
            EditText txtCuit = (EditText) findViewById(R.id.cuit);
            EditText txtDocumento = (EditText) findViewById(R.id.numeroDocumento);
            EditText txtNumeroPartida = (EditText) findViewById(R.id.numeroPartida);

            txtApellidos.setText(apellido);
            txtNombres.setText(nombre);
            txtCuit.setText(objPadron.getCuit());
            txtDocumento.setText(objPadron.getDocumento());
            txtNumeroPartida.setText(objPadron.getPartida());
        } else {

            Toast.makeText(this, "Contribuyente NO encontrado en Padron.", Toast.LENGTH_SHORT).show();
        }


    }

    private void editarRegistro() {

        EditText txtNombre          = (EditText) findViewById(R.id.nombres);
        EditText txtApellidos       = (EditText) findViewById(R.id.apellidos);
        Spinner  spnTipoDoc         = (Spinner) findViewById(R.id.tipoDocumento);
        EditText txtNroDoc          = (EditText) findViewById(R.id.numeroDocumento);
        EditText txtFechaNacimiento = (EditText) findViewById(R.id.fechaNacimiento);
        Spinner  spnSexo            = (Spinner) findViewById(R.id.sexo);
        EditText txtEmail           = (EditText) findViewById(R.id.email);
        EditText txtTelPrincipal    = (EditText) findViewById(R.id.telefonoPrincipal);
        EditText txtCuit            = (EditText) findViewById(R.id.cuit);
        Spinner  spnEstadoCivil     = (Spinner) findViewById(R.id.estadoCivil);
        EditText txtTelSecundario   = (EditText) findViewById(R.id.telefonoSecundario);
        EditText txtDireccion       = (EditText) findViewById(R.id.direccionContacto);
        EditText txtNumero          = (EditText) findViewById(R.id.numeroPuerta);
        EditText txtDepartamento    = (EditText) findViewById(R.id.departamento);
        EditText txtPiso            = (EditText) findViewById(R.id.piso);
        EditText txtNroPartida      = (EditText) findViewById(R.id.numeroPartida);


        try {
            PersonaRepository personaRepo = new PersonaRepository(this);

            Persona unaPersona = personaRepo.getPersonaById(this.registroId);

            txtNombre.setText(unaPersona.getNombre());

            txtApellidos.setText(unaPersona.getApellido());

            spnTipoDoc.setSelection(this.getIndex(spnTipoDoc, unaPersona.getTipoDocumento()));

            txtNroDoc.setText(unaPersona.getDocumento());

            txtFechaNacimiento.setText(unaPersona.getFechaNacimiento());

            spnSexo.setSelection(this.getIndex(spnSexo, unaPersona.getSexo()));

            txtEmail.setText(unaPersona.getEmail());

            txtTelPrincipal.setText(unaPersona.getTelPrincipal());

            txtCuit.setText(unaPersona.getCuit());

            spnEstadoCivil.setSelection(this.getIndex(spnEstadoCivil, unaPersona.getEstadoCivil()));

            txtTelSecundario.setText(unaPersona.getTelSecundario());

            txtDireccion.setText(unaPersona.getDireccion());

            txtNumero.setText(unaPersona.getNumero());

            txtDepartamento.setText(unaPersona.getDepartamento());

            txtPiso.setText(unaPersona.getPiso());

            txtNroPartida.setText(unaPersona.getNumeroPartida());

            String xmlEncuesta = unaPersona.getCuestionario();

            XmlLoader xmlLoad = new XmlLoader();

            LinearLayout encuestaContainer = (LinearLayout) findViewById(R.id.encuestaLayout);

            xmlLoad.loadXml(xmlEncuesta, encuestaContainer, this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Metodo para seleccionar el elemento del spinner por valor
    private int getIndex(Spinner spinner, String myString) {
        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
