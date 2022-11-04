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

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Hora: " + hora + "\n" +
                "Valor: " + valor + "\n" +
                "Fecha: " + getDia();
    }
}
