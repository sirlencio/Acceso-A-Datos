package Ejercicio_2;

public class departamento {
    private int n_dep;
    private String nombre_dep;
    private String localidad;

    public departamento(int n_dep, String nombre_dep, String localidad) {
        this.n_dep = n_dep;
        this.nombre_dep = nombre_dep;
        this.localidad = localidad;
    }

    public departamento(int n_dep) {
        this.n_dep = n_dep;
    }

    public int getN_dep() {
        return n_dep;
    }

    public void setN_dep(int n_dep) {
        this.n_dep = n_dep;
    }

    public String getNombre_dep() {
        return nombre_dep;
    }

    public void setNombre_dep(String nombre_dep) {
        this.nombre_dep = nombre_dep;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String loc) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Departamento{" + "n_dep=" + n_dep + ", nombre_dep='" + nombre_dep + '\'' + ", localidad='" + localidad + '\'' + '}';
    }
}
