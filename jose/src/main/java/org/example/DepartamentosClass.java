package org.example;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "departamentos", schema = "ejercicio2")
public class DepartamentosClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dept_no", nullable = false)
    private byte deptNo;
    @Basic
    @Column(name = "dnombre", nullable = true, length = 15)
    private String dnombre;
    @Basic
    @Column(name = "loc", nullable = true, length = 15)
    private String loc;
    @OneToMany(mappedBy = "departamentosByDeptNo")
    private Collection<EmpleadosClass> empleadosByDeptNo;

    public byte getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(byte deptNo) {
        this.deptNo = deptNo;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Collection<EmpleadosClass> getEmpleadosByDeptNo() {
        return empleadosByDeptNo;
    }

    public void setEmpleadosByDeptNo(Collection<EmpleadosClass> empleadosByDeptNo) {
        this.empleadosByDeptNo = empleadosByDeptNo;
    }
}
