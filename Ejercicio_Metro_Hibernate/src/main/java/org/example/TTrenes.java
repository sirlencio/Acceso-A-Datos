package org.example;

import java.util.Objects;

public class TTrenes {
    private int codTren;
    private String nombre;
    private String tipo;
    private TLineas tLineasByCodLinea;
    private TCocheras tCocherasByCodCochera;

    public int getCodTren() {
        return codTren;
    }

    public void setCodTren(int codTren) {
        this.codTren = codTren;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTrenes tTrenes = (TTrenes) o;
        return codTren == tTrenes.codTren && Objects.equals(nombre, tTrenes.nombre) && Objects.equals(tipo, tTrenes.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codTren, nombre, tipo);
    }

    public TLineas gettLineasByCodLinea() {
        return tLineasByCodLinea;
    }

    public void settLineasByCodLinea(TLineas tLineasByCodLinea) {
        this.tLineasByCodLinea = tLineasByCodLinea;
    }

    public TCocheras gettCocherasByCodCochera() {
        return tCocherasByCodCochera;
    }

    public void settCocherasByCodCochera(TCocheras tCocherasByCodCochera) {
        this.tCocherasByCodCochera = tCocherasByCodCochera;
    }
}
