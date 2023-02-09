package org.example;

import java.util.Collection;
import java.util.Objects;

public class TEstaciones {
    private int codEstacion;
    private String nombre;
    private String direccion;
    private Integer numaccesos;
    private Integer numlineas;
    private Integer numviajesdestino;
    private Integer numviajesprocedencia;
    private Collection<TViajes> tViajesByCodEstacion;
    private Collection<TViajes> tViajesByCodEstacion_0;
    private Collection<TLineaEstacion> tLineaEstacionsByCodEstacion;
    private Collection<TAccesos> tAccesosByCodEstacion;

    public int getCodEstacion() {
        return codEstacion;
    }

    public void setCodEstacion(int codEstacion) {
        this.codEstacion = codEstacion;
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

    public Integer getNumaccesos() {
        return numaccesos;
    }

    public void setNumaccesos(Integer numaccesos) {
        this.numaccesos = numaccesos;
    }

    public Integer getNumlineas() {
        return numlineas;
    }

    public void setNumlineas(Integer numlineas) {
        this.numlineas = numlineas;
    }

    public Integer getNumviajesdestino() {
        return numviajesdestino;
    }

    public void setNumviajesdestino(Integer numviajesdestino) {
        this.numviajesdestino = numviajesdestino;
    }

    public Integer getNumviajesprocedencia() {
        return numviajesprocedencia;
    }

    public void setNumviajesprocedencia(Integer numviajesprocedencia) {
        this.numviajesprocedencia = numviajesprocedencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TEstaciones that = (TEstaciones) o;
        return codEstacion == that.codEstacion && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(numaccesos, that.numaccesos) && Objects.equals(numlineas, that.numlineas) && Objects.equals(numviajesdestino, that.numviajesdestino) && Objects.equals(numviajesprocedencia, that.numviajesprocedencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEstacion, nombre, direccion, numaccesos, numlineas, numviajesdestino, numviajesprocedencia);
    }

    public Collection<TViajes> gettViajesByCodEstacion() {
        return tViajesByCodEstacion;
    }

    public void settViajesByCodEstacion(Collection<TViajes> tViajesByCodEstacion) {
        this.tViajesByCodEstacion = tViajesByCodEstacion;
    }

    public Collection<TViajes> gettViajesByCodEstacion_0() {
        return tViajesByCodEstacion_0;
    }

    public void settViajesByCodEstacion_0(Collection<TViajes> tViajesByCodEstacion_0) {
        this.tViajesByCodEstacion_0 = tViajesByCodEstacion_0;
    }

    public Collection<TLineaEstacion> gettLineaEstacionsByCodEstacion() {
        return tLineaEstacionsByCodEstacion;
    }

    public void settLineaEstacionsByCodEstacion(Collection<TLineaEstacion> tLineaEstacionsByCodEstacion) {
        this.tLineaEstacionsByCodEstacion = tLineaEstacionsByCodEstacion;
    }

    public Collection<TAccesos> gettAccesosByCodEstacion() {
        return tAccesosByCodEstacion;
    }

    public void settAccesosByCodEstacion(Collection<TAccesos> tAccesosByCodEstacion) {
        this.tAccesosByCodEstacion = tAccesosByCodEstacion;
    }
}
