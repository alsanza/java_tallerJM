/* En esta clase se declaran las variables se crean los constructores y los metodos SETTER y GETTER*/
package controller;

public class ctrEmpleado extends ctrPersona {
    
    /* Declaramos las variable de tipo privadas y las inicializamos las variables para evitar un nullPointerException */
    private int IDempleado = 0;
    private String cargo = "";
    private Double salario = 0.0;
    private String usuario = "";
    private String password = "";

    public ctrEmpleado() {
    }

    public ctrEmpleado(int IDempleado, String cargo, Double salario, String usuario, String password) {
        this.IDempleado = IDempleado;
        this.cargo = cargo;
        this.salario = salario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIDempleado() {
        return IDempleado;
    }

    public void setIDempleado(int IDempleado) {
        this.IDempleado = IDempleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
