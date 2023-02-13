package org.example;

import java.util.Objects;

public class Asignatura {
    private String codAsig;
    private String nombreAsi;
    private Profesor profesorByCodProf;

    public String getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(String codAsig) {
        this.codAsig = codAsig;
    }

    public String getNombreAsi() {
        return nombreAsi;
    }

    public void setNombreAsi(String nombreAsi) {
        this.nombreAsi = nombreAsi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(codAsig, that.codAsig) && Objects.equals(nombreAsi, that.nombreAsi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAsig, nombreAsi);
    }

    public Profesor getProfesorByCodProf() {
        return profesorByCodProf;
    }

    public void setProfesorByCodProf(Profesor profesorByCodProf) {
        this.profesorByCodProf = profesorByCodProf;
    }
}
