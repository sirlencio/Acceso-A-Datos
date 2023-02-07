package org.example;

import java.util.Collection;
import java.util.Objects;

public class Clientes {
    private int id;
    private String nombre;
    private String direccion;
    private String poblacion;
    private String telef;
    private String nif;
    private Collection<Ventas> ventasById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return id == clientes.id && Objects.equals(nombre, clientes.nombre) && Objects.equals(direccion, clientes.direccion) && Objects.equals(poblacion, clientes.poblacion) && Objects.equals(telef, clientes.telef) && Objects.equals(nif, clientes.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, poblacion, telef, nif);
    }

    public Collection<Ventas> getVentasById() {
        return ventasById;
    }

    public void setVentasById(Collection<Ventas> ventasById) {
        this.ventasById = ventasById;
    }
}
