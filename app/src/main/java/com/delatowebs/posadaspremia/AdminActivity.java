package com.delatowebs.posadaspremia;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class AdminActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
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

        if (id == R.id.action_configuracion_inicial) {
            Intent intent = new Intent(this, ConfigurarTabletActivity.class);

            startActivity(intent);
            return true;
        }
        if (id == R.id.action_importar_padron) {
            Intent intent = new Intent(this, ImportarPadronActivity.class);

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ConfigurarTablet(View v) {
        Intent intent = new Intent(this, ConfigurarTabletActivity.class);

        startActivity(intent);
    }

    public void ImportarPadron(View v) {
        Intent intent = new Intent(this, ImportarPadronActivity.class);

        startActivity(intent);
    }

    public void ListadoRegistro(View v) {
        Intent intent = new Intent(this, ListadoRegistroActivity.class);

        startActivity(intent);
    }

    public void exportarPadron(View v) {

        try {
            String fecha = new SimpleDateFormat("yyyy_MM_dd").format(new Date());

            File tarjeta = Environment.getExternalStorageDirectory();

            File file = new File(tarjeta.getAbsolutePath() + "/Download/", "registros_" + fecha + ".xml");

            XmlSerializer serializer = Xml.newSerializer();

            OutputStream os = new FileOutputStream(file);

            serializer.setOutput(os, "UTF-8");

            serializer.startDocument(null, Boolean.valueOf(true));

            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

            PersonaRepository personaRepo = new PersonaRepository(this);

            serializer.startTag(null, "registros");

            TabletRepository repo = new TabletRepository(this);

            Tablet miTablet = repo.getTabletById(repo.getFirstTablet());

            serializer.attribute("", "tablet_id", String.valueOf(miTablet.getIdTablet()));

            for (HashMap object : personaRepo.getAllPersonas()) {

                serializer.startTag(null, "persona");

                serializer.startTag(null, "id");
                serializer.text(object.get("id").toString());
                serializer.endTag(null, "id");

                serializer.startTag(null, "nombre");
                serializer.text(object.get("nombre").toString());
                serializer.endTag(null, "nombre");

                serializer.startTag(null, "apellido");
                serializer.text(object.get("apellido").toString());
                serializer.endTag(null, "apellido");

                serializer.startTag(null, "documento");
                serializer.text(object.get("documento").toString());
                serializer.endTag(null, "documento");

                serializer.startTag(null, "cuit");
                serializer.text(object.get("cuit").toString());
                serializer.endTag(null, "cuit");

                serializer.startTag(null, "numero_partida");
                serializer.text(object.get("numeroPartida").toString());
                serializer.endTag(null, "numero_partida");

                serializer.startTag(null, "tipo_doc");
                serializer.text(object.get("tipoDoc").toString());
                serializer.endTag(null, "tipo_doc");

                serializer.startTag(null, "fecha_nacimiento");
                serializer.text(object.get("fechaNacimiento").toString());
                serializer.endTag(null, "fecha_nacimiento");

                serializer.startTag(null, "sexo");
                serializer.text(object.get("sexo").toString());
                serializer.endTag(null, "sexo");

                serializer.startTag(null, "estado_civil");
                serializer.text(object.get("estadoCivil").toString());
                serializer.endTag(null, "estado_civil");

                serializer.startTag(null, "mail");
                serializer.text(object.get("mail").toString());
                serializer.endTag(null, "mail");

                serializer.startTag(null, "tel_principal");
                serializer.text(object.get("telPrincipal").toString());
                serializer.endTag(null, "tel_principal");

                serializer.startTag(null, "tel_secundario");
                serializer.text(object.get("telSecundario").toString());
                serializer.endTag(null, "tel_secundario");

                serializer.startTag(null, "direccion");
                serializer.text(object.get("direccion").toString());
                serializer.endTag(null, "direccion");


                serializer.startTag(null, "numero");
                serializer.text(object.get("numero").toString());
                serializer.endTag(null, "numero");


                serializer.startTag(null, "departamento");
                serializer.text(object.get("departamento").toString());
                serializer.endTag(null, "departamento");


                serializer.startTag(null, "piso");
                serializer.text(object.get("piso").toString());
                serializer.endTag(null, "piso");

                serializer.startTag(null, "cuestionario");
                serializer.cdsect(object.get("cuestionario").toString());
                serializer.endTag(null, "cuestionario");


                serializer.startTag(null, "creado_por");
                serializer.text(object.get("creadoPor").toString());
                serializer.endTag(null, "creado_por");

                serializer.startTag(null, "actualizado");
                serializer.text(object.get("actualizado").toString());
                serializer.endTag(null, "actualizado");

                serializer.endTag(null, "persona");

            }

            serializer.endTag(null, "registros");

            serializer.endDocument();

            serializer.flush();

            Toast.makeText(this, "El padrón se exportó correctamente.", Toast.LENGTH_SHORT).show();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            Toast.makeText(this, "Hubo un problema al intentar exportar el padrón.", Toast.LENGTH_SHORT).show();
        }
    }
}
