package org.example;

import java.util.Collection;
import java.util.Objects;

public class Peliculas {
    private int peliculaId;
    private String titulo;
    private int peliAnno;
    private Collection<PelArt> pelArtsByPeliculaId;
    private Estudios estudiosByEstudioId;
    private Artistas artistasByDirectorId;

    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPeliAnno() {
        return peliAnno;
    }

    public void setPeliAnno(int peliAnno) {
        this.peliAnno = peliAnno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peliculas peliculas = (Peliculas) o;
        return peliculaId == peliculas.peliculaId && peliAnno == peliculas.peliAnno && Objects.equals(titulo, peliculas.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peliculaId, titulo, peliAnno);
    }

    public Collection<PelArt> getPelArtsByPeliculaId() {
        return pelArtsByPeliculaId;
    }

    public void setPelArtsByPeliculaId(Collection<PelArt> pelArtsByPeliculaId) {
        this.pelArtsByPeliculaId = pelArtsByPeliculaId;
    }

    public Estudios getEstudiosByEstudioId() {
        return estudiosByEstudioId;
    }

    public void setEstudiosByEstudioId(Estudios estudiosByEstudioId) {
        this.estudiosByEstudioId = estudiosByEstudioId;
    }

    public Artistas getArtistasByDirectorId() {
        return artistasByDirectorId;
    }

    public void setArtistasByDirectorId(Artistas artistasByDirectorId) {
        this.artistasByDirectorId = artistasByDirectorId;
    }
}
