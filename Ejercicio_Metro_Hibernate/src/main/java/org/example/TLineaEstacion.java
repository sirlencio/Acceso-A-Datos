package org.example;

import java.io.Serializable;
import java.util.Objects;

public class TLineaEstacion implements Serializable {
    private int orden;
    private TLineas tLineasByCodLinea;
    private TEstaciones tEstacionesByCodEstacion;
    private int codLinea;
    private int codEstacion;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodEstacion() {
        return codEstacion;
    }

    public void setCodEstacion(int codEstacion) {
        this.codEstacion = codEstacion;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TLineaEstacion that = (TLineaEstacion) o;
        return orden == that.orden;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orden);
    }

    public TLineas gettLineasByCodLinea() {
        return tLineasByCodLinea;
    }

    public void settLineasByCodLinea(TLineas tLineasByCodLinea) {
        this.tLineasByCodLinea = tLineasByCodLinea;
    }

    public TEstaciones gettEstacionesByCodEstacion() {
        return tEstacionesByCodEstacion;
    }

    public void settEstacionesByCodEstacion(TEstaciones tEstacionesByCodEstacion) {
        this.tEstacionesByCodEstacion = tEstacionesByCodEstacion;
    }
}
