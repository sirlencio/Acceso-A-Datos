package org.example;

import java.io.Serializable;
import java.util.Objects;

public class TLineaEstacionPK implements Serializable {
    private int codLinea;
    private int codEstacion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TLineaEstacionPK that = (TLineaEstacionPK) o;
        return codLinea == that.codLinea && codEstacion == that.codEstacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codLinea, codEstacion);
    }
}
