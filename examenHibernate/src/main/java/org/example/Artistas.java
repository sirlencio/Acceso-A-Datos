package org.example;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

public class Artistas {
    private int artistaId;
    private String nombre;
    private Date fechaNac;
    private Date fechaDef;
    private Collection<PelArt> pelArtsByArtistaId;
    private Collection<Peliculas> peliculasByArtistaId;

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaDef() {
        return fechaDef;
    }

    public void setFechaDef(Date fechaDef) {
        this.fechaDef = fechaDef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artistas artistas = (Artistas) o;
        return artistaId == artistas.artistaId && Objects.equals(nombre, artistas.nombre) && Objects.equals(fechaNac, artistas.fechaNac) && Objects.equals(fechaDef, artistas.fechaDef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistaId, nombre, fechaNac, fechaDef);
    }

    public Collection<PelArt> getPelArtsByArtistaId() {
        return pelArtsByArtistaId;
    }

    public void setPelArtsByArtistaId(Collection<PelArt> pelArtsByArtistaId) {
        this.pelArtsByArtistaId = pelArtsByArtistaId;
    }

    public Collection<Peliculas> getPeliculasByArtistaId() {
        return peliculasByArtistaId;
    }

    public void setPeliculasByArtistaId(Collection<Peliculas> peliculasByArtistaId) {
        this.peliculasByArtistaId = peliculasByArtistaId;
    }
}
