package org.example;

import java.util.Collection;
import java.util.Objects;

public class TLineas {
    private int codLinea;
    private String nombre;
    private Collection<TLineaEstacion> tLineaEstacionsByCodLinea;
    private Collection<TTrenes> tTrenesByCodLinea;

    public int getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TLineas tLineas = (TLineas) o;
        return codLinea == tLineas.codLinea && Objects.equals(nombre, tLineas.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codLinea, nombre);
    }

    public Collection<TLineaEstacion> gettLineaEstacionsByCodLinea() {
        return tLineaEstacionsByCodLinea;
    }

    public void settLineaEstacionsByCodLinea(Collection<TLineaEstacion> tLineaEstacionsByCodLinea) {
        this.tLineaEstacionsByCodLinea = tLineaEstacionsByCodLinea;
    }

    public Collection<TTrenes> gettTrenesByCodLinea() {
        return tTrenesByCodLinea;
    }

    public void settTrenesByCodLinea(Collection<TTrenes> tTrenesByCodLinea) {
        this.tTrenesByCodLinea = tTrenesByCodLinea;
    }
}
