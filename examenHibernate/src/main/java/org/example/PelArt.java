package org.example;

import java.util.Objects;

public class PelArt {
    private PelArtPK id;
    private Peliculas peliculasByPeliculaId;
    private Artistas artistasByArtistaId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PelArt pelArt = (PelArt) o;
        return id == pelArt.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public PelArtPK getId() {
        return id;
    }

    public void setId(PelArtPK id) {
        this.id = id;
    }

    public Peliculas getPeliculasByPeliculaId() {
        return peliculasByPeliculaId;
    }

    public void setPeliculasByPeliculaId(Peliculas peliculasByPeliculaId) {
        this.peliculasByPeliculaId = peliculasByPeliculaId;
    }

    public Artistas getArtistasByArtistaId() {
        return artistasByArtistaId;
    }

    public void setArtistasByArtistaId(Artistas artistasByArtistaId) {
        this.artistasByArtistaId = artistasByArtistaId;
    }
}
