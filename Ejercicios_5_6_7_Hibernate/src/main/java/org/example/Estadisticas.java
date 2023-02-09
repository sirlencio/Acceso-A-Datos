package org.example;

import java.util.Objects;

public class Estadisticas {
    private String temporada;
    private Double puntosPorPartido;
    private Double asistenciasPorPartido;
    private Double taponesPorPartido;
    private Double rebotesPorPartido;
    private Jugadores jugadoresByJugador;

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(Double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    public Double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(Double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }

    public Double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(Double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    public Double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(Double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estadisticas that = (Estadisticas) o;
        return Objects.equals(temporada, that.temporada) && Objects.equals(puntosPorPartido, that.puntosPorPartido) && Objects.equals(asistenciasPorPartido, that.asistenciasPorPartido) && Objects.equals(taponesPorPartido, that.taponesPorPartido) && Objects.equals(rebotesPorPartido, that.rebotesPorPartido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporada, puntosPorPartido, asistenciasPorPartido, taponesPorPartido, rebotesPorPartido);
    }

    public Jugadores getJugadoresByJugador() {
        return jugadoresByJugador;
    }

    public void setJugadoresByJugador(Jugadores jugadoresByJugador) {
        this.jugadoresByJugador = jugadoresByJugador;
    }
}
