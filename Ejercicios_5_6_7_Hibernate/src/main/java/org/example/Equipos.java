package org.example;

import java.util.Collection;
import java.util.Objects;

public class Equipos {
    private String nombre;
    private String ciudad;
    private String conferencia;
    private String division;
    private Collection<Jugadores> jugadoresByNombre;
    private Collection<Partidos> partidosByNombre;
    private Collection<Partidos> partidosByNombre_0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipos equipos = (Equipos) o;
        return Objects.equals(nombre, equipos.nombre) && Objects.equals(ciudad, equipos.ciudad) && Objects.equals(conferencia, equipos.conferencia) && Objects.equals(division, equipos.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ciudad, conferencia, division);
    }

    public Collection<Jugadores> getJugadoresByNombre() {
        return jugadoresByNombre;
    }

    public void setJugadoresByNombre(Collection<Jugadores> jugadoresByNombre) {
        this.jugadoresByNombre = jugadoresByNombre;
    }

    public Collection<Partidos> getPartidosByNombre() {
        return partidosByNombre;
    }

    public void setPartidosByNombre(Collection<Partidos> partidosByNombre) {
        this.partidosByNombre = partidosByNombre;
    }

    public Collection<Partidos> getPartidosByNombre_0() {
        return partidosByNombre_0;
    }

    public void setPartidosByNombre_0(Collection<Partidos> partidosByNombre_0) {
        this.partidosByNombre_0 = partidosByNombre_0;
    }
}
