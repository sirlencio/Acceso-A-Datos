package org.example;

import java.util.Objects;

public class TLineaEstacion {
    private int codLinea;
    private int codEstacion;
    private int orden;
    private TLineas tLineasByCodLinea;
    private TEstaciones tEstacionesByCodEstacion;
    private TLineaEstacionPK id;

    public TLineaEstacionPK getId() {
        return id;
    }

    public void setId(TLineaEstacionPK id) {
        this.id = id;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodEstacion() {
        return codEstacion;
    }

    public void setCodEstacion(int codEstacion) {
        this.codEstacion = codEstacion;
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
        return codLinea == that.codLinea && codEstacion == that.codEstacion && orden == that.orden;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codLinea, codEstacion, orden);
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
