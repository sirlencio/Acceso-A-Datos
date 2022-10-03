import java.io.Serializable;

public class producto implements Serializable {

    private int codigo, unidades, precio;
    private String descripcion;

    public producto(int codigo) {
        this.codigo = codigo;
    }

    public producto(int codigo,String descripcion, int unidades, int precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
