package org.example;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "provincias", schema = "examen", catalog = "")
public class ProvinciasClass {
    @Basic
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "provincia", nullable = false, length = 255)
    private String provincia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
