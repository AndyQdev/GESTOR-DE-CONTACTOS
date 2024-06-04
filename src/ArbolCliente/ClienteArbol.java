/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolCliente;

/**
 *
 * @author CLAUDIA CORTEZ
 */
public class ClienteArbol {
    private int clave;
    private String nombre;
    private String telefono;
    private String direccion;
    private String razonSocial;
    private String arbol;

    public String getArbol() {
        return arbol;
    }

    public void setArbol(String arbol) {
        this.arbol = arbol;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    
    public ClienteArbol(){
        this.clave = 0;
        this.nombre = null;
        this.telefono = null;
        this.direccion = null;
        this.razonSocial = null;
    }
    public ClienteArbol(int clave, String nombre, String telefono, String direccion, String razonSocial) {
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    @Override
    public String toString() {
        return "Cliente [clave=" + clave + ", nombre=" + nombre + ", telefono=" + telefono + 
               ", direccion=" + direccion + ", razonSocial=" + razonSocial + "]";
    }
}

