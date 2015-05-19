package com.delatowebs.posadaspremia;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by matias on 25/04/15.
 */
public class Padron implements Parcelable {
    private String orden;
    private String partida;
    private String razonSocial;
    private String documento;
    private String cuit;
    private String fisica;
    private String documentoAVerificar;
    private String domicilio;
    private String corte;

    public Padron(String orden, String partida, String razonSocial, String documento, String cuit, String fisica, String documentoAVerificar, String domicilio, String corte) {
        super();
        this.orden = orden;
        this.partida = partida;
        this.razonSocial = razonSocial;
        this.documento = documento;
        this.cuit = cuit;
        this.fisica = fisica;
        this.documentoAVerificar = documentoAVerificar;
        this.domicilio = domicilio;
        this.corte = corte;
    }

    public Padron(){

    }

    public Padron(Parcel in) {
        readFromParcel(in);
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public String getDocumentoAVerificar() {
        return documentoAVerificar;
    }

    public void setDocumentoAVerificar(String documentoAVerificar) {
        this.documentoAVerificar = documentoAVerificar;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    @Override
    public String toString() {
        return partida + " " + documento;
    }

    public String filterByPartida() {
        return partida;
    }

    public String filterByDocumento() {
        return documento;
    }


    public String toString(String param) {
        String returnValue;
        if (param.equals("Partida")) {
            returnValue = partida;
        } else {
            returnValue = documento;
        }


        return returnValue;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orden);
        dest.writeString(this.partida);
        dest.writeString(this.razonSocial);
        dest.writeString(this.documento);
        dest.writeString(this.cuit);
        dest.writeString(this.fisica);
        dest.writeString(this.documentoAVerificar);
        dest.writeString(this.domicilio);
        dest.writeString(this.corte);


    }

    public void readFromParcel(Parcel in) {
        this.orden = in.readString();
        this.partida = in.readString();
        this.razonSocial = in.readString();
        this.documento = in.readString();
        this.cuit = in.readString();
        this.fisica = in.readString();
        this.documentoAVerificar = in.readString();
        this.domicilio = in.readString();
        this.corte = in.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Creator<Padron> CREATOR = new Creator<Padron>() {


        public Padron createFromParcel(Parcel in) {
            return new Padron(in);
        }


        public Padron[] newArray(int size) {
            return new Padron[size];
        }
    };
}
