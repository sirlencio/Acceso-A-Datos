import java.io.Serializable;

public class Empleado implements Serializable {

    private int id, depart, salario;
    private String apellido;

    public Empleado(int id) {
        this.id = id;
    }

    public Empleado(int id, String apellido, int depart, int salario) {
        this.id = id;
        this.apellido = apellido;
        this.depart = depart;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", depart=" + depart +
                ", salario=" + salario +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}