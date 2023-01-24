package org.example;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "empleados", schema = "ejercicio2")
public class EmpleadosClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_no", nullable = false)
    private short empNo;
    @Basic
    @Column(name = "apellido", nullable = true, length = 10)
    private String apellido;
    @Basic
    @Column(name = "oficio", nullable = true, length = 10)
    private String oficio;
    @Basic
    @Column(name = "dir", nullable = true)
    private Short dir;
    @Basic
    @Column(name = "fecha_alt", nullable = true)
    private Date fechaAlt;
    @Basic
    @Column(name = "salario", nullable = true, precision = 2)
    private Double salario;
    @Basic
    @Column(name = "comision", nullable = true, precision = 2)
    private Double comision;
    @ManyToOne
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", nullable = false)
    private DepartamentosClass departamentosByDeptNo;

    public short getEmpNo() {
        return empNo;
    }

    public void setEmpNo(short empNo) {
        this.empNo = empNo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Short getDir() {
        return dir;
    }

    public void setDir(Short dir) {
        this.dir = dir;
    }

    public Date getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public DepartamentosClass getDepartamentosByDeptNo() {
        return departamentosByDeptNo;
    }

    public void setDepartamentosByDeptNo(DepartamentosClass departamentosByDeptNo) {
        this.departamentosByDeptNo = departamentosByDeptNo;
    }
}
