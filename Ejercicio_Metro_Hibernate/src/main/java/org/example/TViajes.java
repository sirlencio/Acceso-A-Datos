package org.example;

import java.util.Objects;

public class TViajes {
    private int codViaje;
    private String nombre;
    private TEstaciones tEstacionesByEstacionorigen;
    private TEstaciones tEstacionesByEstaciondestino;

    public int getCodViaje() {
        return codViaje;
    }

    public void setCodViaje(int codViaje) {
        this.codViaje = codViaje;
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
        TViajes tViajes = (TViajes) o;
        return codViaje == tViajes.codViaje && Objects.equals(nombre, tViajes.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codViaje, nombre);
    }

    public TEstaciones gettEstacionesByEstacionorigen() {
        return tEstacionesByEstacionorigen;
    }

    public void settEstacionesByEstacionorigen(TEstaciones tEstacionesByEstacionorigen) {
        this.tEstacionesByEstacionorigen = tEstacionesByEstacionorigen;
    }

    public TEstaciones gettEstacionesByEstaciondestino() {
        return tEstacionesByEstaciondestino;
    }

    public void settEstacionesByEstaciondestino(TEstaciones tEstacionesByEstaciondestino) {
        this.tEstacionesByEstaciondestino = tEstacionesByEstaciondestino;
    }
}
