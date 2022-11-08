import java.io.Serializable;
import java.util.Date;

public class Cotizacion implements Serializable {
    private String nombre, hora, valor;
    private Date fecha;

    public Cotizacion(String nombre, String hora, String valor) {
        this.nombre = nombre;
        this.hora = hora;
        this.valor = valor;
        this.fecha = new Date();
    }

    public String getHora() {
        return hora;
    }

    public String getDia() {
        String dia = fecha.getDate() + "/" + fecha.getMonth();
        return dia;
    }

    public String getNombre() {
        return nombre;
    }


    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Hora: " + hora + "\n" +
                "Valor: " + valor + "\n" +
                "Fecha: " + getDia();
    }
}
