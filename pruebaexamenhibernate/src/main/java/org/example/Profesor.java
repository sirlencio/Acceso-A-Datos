package org.example;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

public class Profesor {
    private int codProf;
    private String nombrePro;
    private String espePro;
    private Date fechaNac;
    private String sexo;
    private Integer salario;
    private Collection<Asignatura> asignaturasByCodProf;
    private Centro centroByCodCentro;

    public int getCodProf() {
        return codProf;
    }

    public void setCodProf(int codProf) {
        this.codProf = codProf;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getEspePro() {
        return espePro;
    }

    public void setEspePro(String espePro) {
        this.espePro = espePro;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return codProf == profesor.codProf && Objects.equals(nombrePro, profesor.nombrePro) && Objects.equals(espePro, profesor.espePro) && Objects.equals(fechaNac, profesor.fechaNac) && Objects.equals(sexo, profesor.sexo) && Objects.equals(salario, profesor.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProf, nombrePro, espePro, fechaNac, sexo, salario);
    }

    public Collection<Asignatura> getAsignaturasByCodProf() {
        return asignaturasByCodProf;
    }

    public void setAsignaturasByCodProf(Collection<Asignatura> asignaturasByCodProf) {
        this.asignaturasByCodProf = asignaturasByCodProf;
    }

    public Centro getCentroByCodCentro() {
        return centroByCodCentro;
    }

    public void setCentroByCodCentro(Centro centroByCodCentro) {
        this.centroByCodCentro = centroByCodCentro;
    }
}
