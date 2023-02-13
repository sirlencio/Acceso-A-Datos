package org.example;

import java.util.Collection;
import java.util.Objects;

public class Centro {
    private int codCentro;
    private String nomCentro;
    private String direccion;
    private String localidad;
    private String provincia;
    private Collection<Profesor> profesorsByCodCentro;

    public int getCodCentro() {
        return codCentro;
    }

    public void setCodCentro(int codCentro) {
        this.codCentro = codCentro;
    }

    public String getNomCentro() {
        return nomCentro;
    }

    public void setNomCentro(String nomCentro) {
        this.nomCentro = nomCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centro centro = (Centro) o;
        return codCentro == centro.codCentro && Objects.equals(nomCentro, centro.nomCentro) && Objects.equals(direccion, centro.direccion) && Objects.equals(localidad, centro.localidad) && Objects.equals(provincia, centro.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCentro, nomCentro, direccion, localidad, provincia);
    }

    public Collection<Profesor> getProfesorsByCodCentro() {
        return profesorsByCodCentro;
    }

    public void setProfesorsByCodCentro(Collection<Profesor> profesorsByCodCentro) {
        this.profesorsByCodCentro = profesorsByCodCentro;
    }
}
