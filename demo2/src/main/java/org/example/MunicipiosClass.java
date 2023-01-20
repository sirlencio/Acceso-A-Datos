package org.example;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "municipios", schema = "examen", catalog = "")
public class MunicipiosClass {
    @Basic
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "provincia", nullable = false)
    private int provincia;
    @Basic
    @Column(name = "municipio", nullable = false, length = 255)
    private String municipio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
