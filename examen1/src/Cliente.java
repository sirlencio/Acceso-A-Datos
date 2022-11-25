import java.io.Serializable;

public class Cliente implements Serializable {
    String nombre, ciudad;
    int edad;
    double descuento;

    public Cliente() {
    }

    public Cliente(String nombre, String ciudad, int edad, double descuento) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", edad=" + edad +
                ", descuento=" + descuento +
                '}';
    }
}