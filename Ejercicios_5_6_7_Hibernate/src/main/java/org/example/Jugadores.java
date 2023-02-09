package org.example;

import java.util.Collection;
import java.util.Objects;

public class Jugadores {
    private int codigo;
    private String nombre;
    private String procedencia;
    private String altura;
    private Integer peso;
    private String posicion;
    private Collection<Estadisticas> estadisticasByCodigo;
    private Equipos equiposByNombreEquipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugadores jugadores = (Jugadores) o;
        return codigo == jugadores.codigo && Objects.equals(nombre, jugadores.nombre) && Objects.equals(procedencia, jugadores.procedencia) && Objects.equals(altura, jugadores.altura) && Objects.equals(peso, jugadores.peso) && Objects.equals(posicion, jugadores.posicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, procedencia, altura, peso, posicion);
    }

    public Collection<Estadisticas> getEstadisticasByCodigo() {
        return estadisticasByCodigo;
    }

    public void setEstadisticasByCodigo(Collection<Estadisticas> estadisticasByCodigo) {
        this.estadisticasByCodigo = estadisticasByCodigo;
    }

    public Equipos getEquiposByNombreEquipo() {
        return equiposByNombreEquipo;
    }

    public void setEquiposByNombreEquipo(Equipos equiposByNombreEquipo) {
        this.equiposByNombreEquipo = equiposByNombreEquipo;
    }
}
