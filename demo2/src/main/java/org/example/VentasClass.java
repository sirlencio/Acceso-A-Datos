package org.example;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ventas", schema = "examen", catalog = "")
public class VentasClass {
    @Basic
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "codvendedor", nullable = false)
    private int codvendedor;
    @Basic
    @Column(name = "importe", nullable = false)
    private int importe;
    @Basic
    @Column(name = "fechaVenta", nullable = false, length = 10)
    private String fechaVenta;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(int codvendedor) {
        this.codvendedor = codvendedor;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
