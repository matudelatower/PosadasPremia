package com.delatowebs.posadaspremia;

import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by santiago on 12/5/15.
 */
public class XmlLoader  {

    private static final String XML_CUESTIONARIO_TAG = "cuestionario";

    private static final String XML_MEDIO_TAG = "medio";

    private static final String XML_ITEM_TAG = "item";

    private static final String XML_TAG_TAG = "tag";

    private static final String XML_CUESTIONARIO_ID = "id";

    private static final String XML_RESPUESTA_TAG = "respuesta";


    void loadXml(String xml, LinearLayout container,RegistroActivity context) throws ParserConfigurationException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(is);

            NodeList itemList = doc.getElementsByTagName("item");

            readItems(itemList,container);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void readItems(NodeList itemList, LinearLayout container) {

        for (int i = 0; i < itemList.getLength(); ++i) {
            Element item = (Element) itemList.item(i);

            String tag = "";
            String respuesta = "";


            Node tagNode = item.getElementsByTagName("tag").item(0).getFirstChild();

            if (tagNode != null) {
                tag = tagNode.getNodeValue();
            }

            Node respuestaNode = item.getElementsByTagName("respuesta").item(0).getFirstChild();

            if (respuestaNode != null) {
                respuesta = respuestaNode.getNodeValue();
            }


            if (!tag.isEmpty() && !respuesta.isEmpty()) {
                View element = container.findViewWithTag(tag);

                if (element.getClass() == EditText.class || element.getClass() == TintEditText.class) {
                    EditText edit = (EditText) element;
                    edit.setText(respuesta);
                }

                if (element.getClass() == Spinner.class || element.getClass() == TintSpinner.class) {
                    Spinner cmb = (Spinner) element;
                    cmb.setSelection(this.getIndex(cmb, respuesta));
                }

                if (element.getClass() == RadioButton.class || element.getClass() == TintRadioButton.class) {
                    RadioButton rb = (RadioButton) element;
                    rb.setChecked(true);
                }
            }


        }
    }

    //Metodo para seleccionar el elemento del spinner por valor
    private int getIndex(Spinner spinner, String myString)
    {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }
}
