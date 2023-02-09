package org.example;

import java.util.Collection;
import java.util.Objects;

public class TCocheras {
    private int codCochera;
    private String nombre;
    private String direccion;
    private Collection<TTrenes> tTrenesByCodCochera;

    public int getCodCochera() {
        return codCochera;
    }

    public void setCodCochera(int codCochera) {
        this.codCochera = codCochera;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCocheras tCocheras = (TCocheras) o;
        return codCochera == tCocheras.codCochera && Objects.equals(nombre, tCocheras.nombre) && Objects.equals(direccion, tCocheras.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCochera, nombre, direccion);
    }

    public Collection<TTrenes> gettTrenesByCodCochera() {
        return tTrenesByCodCochera;
    }

    public void settTrenesByCodCochera(Collection<TTrenes> tTrenesByCodCochera) {
        this.tTrenesByCodCochera = tTrenesByCodCochera;
    }
}
