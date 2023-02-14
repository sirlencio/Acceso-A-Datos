package org.example;

import java.util.Collection;
import java.util.Objects;

public class Estudios {
    private int estudioId;
    private String nombre;
    private String email;
    private Collection<Peliculas> peliculasByEstudioId;

    public int getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(int estudioId) {
        this.estudioId = estudioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudios estudios = (Estudios) o;
        return estudioId == estudios.estudioId && Objects.equals(nombre, estudios.nombre) && Objects.equals(email, estudios.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudioId, nombre, email);
    }

    public Collection<Peliculas> getPeliculasByEstudioId() {
        return peliculasByEstudioId;
    }

    public void setPeliculasByEstudioId(Collection<Peliculas> peliculasByEstudioId) {
        this.peliculasByEstudioId = peliculasByEstudioId;
    }
}
