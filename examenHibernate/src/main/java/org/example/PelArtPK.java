package org.example;

import java.io.Serializable;
import java.util.Objects;

public class PelArtPK implements Serializable {
    private int peliculaId;
    private int artistaId;

    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PelArtPK pelArtPK = (PelArtPK) o;
        return peliculaId == pelArtPK.peliculaId && artistaId == pelArtPK.artistaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peliculaId, artistaId);
    }
}
