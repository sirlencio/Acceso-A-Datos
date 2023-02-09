package org.example;

import java.util.Objects;

public class Partidos {
    private int codigo;
    private Integer puntosLocal;
    private Integer puntosVisitante;
    private String temporada;
    private Equipos equiposByEquipoLocal;
    private Equipos equiposByEquipoVisitante;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Integer getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(Integer puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public Integer getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(Integer puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partidos partidos = (Partidos) o;
        return codigo == partidos.codigo && Objects.equals(puntosLocal, partidos.puntosLocal) && Objects.equals(puntosVisitante, partidos.puntosVisitante) && Objects.equals(temporada, partidos.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, puntosLocal, puntosVisitante, temporada);
    }

    public Equipos getEquiposByEquipoLocal() {
        return equiposByEquipoLocal;
    }

    public void setEquiposByEquipoLocal(Equipos equiposByEquipoLocal) {
        this.equiposByEquipoLocal = equiposByEquipoLocal;
    }

    public Equipos getEquiposByEquipoVisitante() {
        return equiposByEquipoVisitante;
    }

    public void setEquiposByEquipoVisitante(Equipos equiposByEquipoVisitante) {
        this.equiposByEquipoVisitante = equiposByEquipoVisitante;
    }
}
