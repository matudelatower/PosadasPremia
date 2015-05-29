package com.delatowebs.posadaspremia;

import android.util.Xml;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by santiago on 30/4/15.
 */
public class XmlGenerator {

    private XmlSerializer serializer;

    public XmlGenerator() {
    }

    public String generarXml(LinearLayout root) throws IOException{

        this.serializer = Xml.newSerializer();

        OutputStream outputStream = new ByteArrayOutputStream();

        this.serializer.setOutput(outputStream, "UTF-8");

        //this.serializer.startDocument(null, Boolean.valueOf(true));

        this.serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

        //<cuestionario>
        this.serializer.startTag(null, "cuestionario");

        //genero los items
        xmlItems(root);

        this.serializer.endTag(null, "cuestionario");

        this.serializer.endDocument();

        this.serializer.flush();

        return outputStream.toString();


    }



    private void xmlItems(LinearLayout root) throws IOException{


        this.itemTag(
                ((TextView) root.findViewById(R.id.txtComposicionFamiliar)).getText().toString(),
                ((Spinner) root.findViewById(R.id.composicionFamiliar)).getSelectedItem().toString(),
                root.findViewById(R.id.composicionFamiliar).getTag().toString()
        );

        this.itemTag(
                ((TextView) root.findViewById(R.id.txtNivelEducativo)).getText().toString(),
                ((Spinner) root.findViewById(R.id.nivelEducativo)).getSelectedItem().toString(),
                root.findViewById(R.id.nivelEducativo).getTag().toString()
        );
        this.itemTag(
                ((TextView) root.findViewById(R.id.txtSituacionJefeFamilia)).getText().toString(),
                ((Spinner) root.findViewById(R.id.situacionJefeFamilia)).getSelectedItem().toString(),
                root.findViewById(R.id.situacionJefeFamilia).getTag().toString()
        );
        this.itemTag(
                ((TextView) root.findViewById(R.id.txtComprasDiarias)).getText().toString(),
                ((Spinner) root.findViewById(R.id.comprasDiarias)).getSelectedItem().toString(),
                root.findViewById(R.id.comprasDiarias).getTag().toString()
        );
        this.itemTag(
                ((TextView) root.findViewById(R.id.txtSeguimientoContacto)).getText().toString(),
                ((Spinner) root.findViewById(R.id.seguimientoContacto)).getSelectedItem().toString(),
                root.findViewById(R.id.seguimientoContacto).getTag().toString()
        );
        this.itemTag(
                ((TextView) root.findViewById(R.id.txtCantidadDispositivos)).getText().toString(),
                ((EditText) root.findViewById(R.id.cantidadDispositivos)).getText().toString(),
                root.findViewById(R.id.cantidadDispositivos).getTag().toString()
        );
        this.itemTag(
                ((TextView) root.findViewById(R.id.txtContactoPreferido)).getText().toString(),
                ((EditText) root.findViewById(R.id.contactoPreferido)).getText().toString(),
                root.findViewById(R.id.contactoPreferido).getTag().toString()
        );

    }

    private void itemTag(String pregunta, String respuesta,String tag) throws IOException{

        this.serializer.startTag(null, "item");

        this.serializer.startTag(null,"tag")
                .text(tag)
                .endTag(null, "tag");

        this.serializer.startTag(null,"pregunta")
                .text(pregunta)
                .endTag(null, "pregunta");

        this.serializer.startTag(null,"respuesta")
                .text(respuesta)
                .endTag(null,"respuesta");

        this.serializer.endTag(null, "item");
    }
}
