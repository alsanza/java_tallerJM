package controller;

public class ctrPersona {

    /* inicializamos las variables para evitar un nullPointerException */
    private int IDpersona;
    private String tipo_documento = "";
    private String numero_documento = "";
    private String nombres = "";
    private String apellidos = "";
    private String email = "";
    private String contacto = "";
    private String direccion = "";
    private int estado = 1;

    public ctrPersona() {
    }

    public ctrPersona(int IDpersona, String tipo_documento, String numero_documento, String nombres, String apellidos, String email, String contacto, String direccion, int estado) {
        this.IDpersona = IDpersona;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.contacto = contacto;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getIDpersona() {
        return IDpersona;
    }

    public void setIDpersona(int IDpersona) {
        this.IDpersona = IDpersona;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
