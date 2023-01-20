package org.example;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores", schema = "examen", catalog = "")
public class VendedoresClass {
    @Basic
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 255)
    private String apellidos;
    @Basic
    @Column(name = "provincia", nullable = false)
    private int provincia;
    @Basic
    @Column(name = "municipio", nullable = false)
    private long municipio;
    @Basic
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @Basic
    @Column(name = "FechaAlta", nullable = false, length = 10)
    private String fechaAlta;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public long getMunicipio() {
        return municipio;
    }

    public void setMunicipio(long municipio) {
        this.municipio = municipio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
