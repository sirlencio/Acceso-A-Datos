package Ejercicio_2;

import java.util.Date;

public class empleado {
    private int n_empleado;
    private String apellido;
    private String oficio;
    private int dir;
    private Date fecha_alt;
    private float salario;
    private float comision;
    private int n_dep;

    @Override
    public String toString() {
        return "Empleado{" +
                "n_empleado=" + n_empleado +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", dir=" + dir +
                ", fecha_alt='" + fecha_alt.toString() + '\'' +
                ", salario=" + salario +
                ", comision=" + comision +
                ", n_dep=" + n_dep +
                '}';
    }

    public empleado(int n_empleado, String apellido, String oficio, int dir, Date fecha_alt, float salario, float comision, int n_dep) {
        this.n_empleado = n_empleado;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fecha_alt = fecha_alt;
        this.salario = salario;
        this.comision = comision;
        this.n_dep = n_dep;
    }

    public empleado(int n_empleado) {
        this.n_empleado = n_empleado;
    }

    public int getN_empleado() {
        return n_empleado;
    }

    public void setN_empleado(int n_empleado) {
        this.n_empleado = n_empleado;
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

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Date getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(Date fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getN_dep() {
        return n_dep;
    }

    public void setN_dep(int n_dep) {
        this.n_dep = n_dep;
    }
}
