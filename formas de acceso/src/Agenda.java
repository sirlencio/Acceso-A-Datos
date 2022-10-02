import java.io.Serializable;

public class Agenda implements Serializable {
        public String nombre;
        public String apellidos;
        public Integer telefono;

    public Agenda(String nombre, String apellidos, Integer telefono) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.telefono = telefono;
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

        public Integer getTelefono() {
            return telefono;
        }

        public void setTelefono(Integer telefono) {
            this.telefono = telefono;
        }
}
