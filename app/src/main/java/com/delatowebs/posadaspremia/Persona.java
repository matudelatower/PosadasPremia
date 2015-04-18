package com.delatowebs.posadaspremia;

import android.content.Context;

/**
 * Created by matias on 15/04/15.
 */
public class Persona {
    // Labels table name
    public static final String TABLE = "padron_contribuyentes";

    // Labels Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_razon_social = "razon_social";
    public static final String KEY_documento = "documento";
    public static final String KEY_cuit = "cuit";
    public static final String KEY_fisica = "fisica";
    public static final String KEY_documento_a_verificar = "documento_a_verificar";
    public static final String KEY_domicilio = "domicilio";
    public static final String KEY_nro_partida = "nro_partida";

    private Integer Id;
    private String RazonSocial;
    private String Documento;
    private String Cuit;
    private String Fisica;
    private String DocumentoAVerificar;
    private String Domicilio;
    private String NroPartida;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getCuit() {
        return Cuit;
    }

    public void setCuit(String cuit) {
        Cuit = cuit;
    }

    public String getFisica() {
        return Fisica;
    }

    public void setFisica(String fisica) {
        Fisica = fisica;
    }

    public String getDocumentoAVerificar() {
        return DocumentoAVerificar;
    }

    public void setDocumentoAVerificar(String documentoAVerificar) {
        DocumentoAVerificar = documentoAVerificar;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public String getNroPartida() {
        return NroPartida;
    }

    public void setNroPartida(String nroPartida) {
        NroPartida = nroPartida;
    }
}
