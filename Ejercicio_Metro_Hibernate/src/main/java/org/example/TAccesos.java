package org.example;

import java.util.Objects;

public class TAccesos {
    private int codAcceso;
    private String descripcion;
    private TEstaciones tEstacionesByCodEstacion;

    public int getCodAcceso() {
        return codAcceso;
    }

    public void setCodAcceso(int codAcceso) {
        this.codAcceso = codAcceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAccesos tAccesos = (TAccesos) o;
        return codAcceso == tAccesos.codAcceso && Objects.equals(descripcion, tAccesos.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAcceso, descripcion);
    }

    public TEstaciones gettEstacionesByCodEstacion() {
        return tEstacionesByCodEstacion;
    }

    public void settEstacionesByCodEstacion(TEstaciones tEstacionesByCodEstacion) {
        this.tEstacionesByCodEstacion = tEstacionesByCodEstacion;
    }
}
