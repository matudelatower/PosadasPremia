package com.delatowebs.posadaspremia;

/**
 * Created by matias on 15/04/15.
 */
public class Persona {
    // Labels table name
    public static final String TABLE = "padron_contribuyentes";

    // Labels Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_DOCUMENTO = "documento";
    public static final String KEY_CUIT = "cuit";
    public static final String KEY_APELLIDO = "apellido";
    public static final String KEY_NOMBRE = "nombre";
    public static final String KEY_TIPO_DOC = "tipo_documento";
    public static final String KEY_FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String KEY_SEXO = "sexo";
    public static final String KEY_ESTADO_CIVIL = "estado_civil";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TEL_PRINCIPAL = "tel_principal";
    public static final String KEY_TEL_SECUNDARIO = "tel_secundario";
    public static final String KEY_DIRECCION = "direccion";
    public static final String KEY_NUMERO = "numero";
    public static final String KEY_DEPARTAMENTO = "departamento";
    public static final String KEY_PISO = "piso";
    public static final String KEY_CUESTIONARIO = "cuestionario";
    public static final String KEY_CREADO_POR = "creado_por";
    public static final String KEY_ACTUALIZADO = "actualizado";

    private Integer id;
    private String documento;
    private String cuit;
    private String apellido;
    private String nombre;
    private String tipoDocumento;
    private String fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    private String email;
    private String telPrincipal;
    private String telSecundario;
    private String direccion;
    private String numero;
    private String departamento;
    private String piso;
    private String cuestionario;
    private String creadoPor;
    private String actualizado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelPrincipal() {
        return telPrincipal;
    }

    public void setTelPrincipal(String telPrincipal) {
        this.telPrincipal = telPrincipal;
    }

    public String getTelSecundario() {
        return telSecundario;
    }

    public void setTelSecundario(String telSecundario) {
        this.telSecundario = telSecundario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(String cuestionario) {
        this.cuestionario = cuestionario;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }
}
