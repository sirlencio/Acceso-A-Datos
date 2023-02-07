package org.example;

import java.sql.Date;
import java.util.Objects;

public class Ventas {
    private Integer idventa;
    private Date fechaventa;
    private Integer cantidad;
    private Clientes clientesByIdcliente;
    private Productos productosByIdproducto;

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ventas ventas = (Ventas) o;
        return Objects.equals(idventa, ventas.idventa) && Objects.equals(fechaventa, ventas.fechaventa) && Objects.equals(cantidad, ventas.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idventa, fechaventa, cantidad);
    }

    public Clientes getClientesByIdcliente() {
        return clientesByIdcliente;
    }

    public void setClientesByIdcliente(Clientes clientesByIdcliente) {
        this.clientesByIdcliente = clientesByIdcliente;
    }

    public Productos getProductosByIdproducto() {
        return productosByIdproducto;
    }

    public void setProductosByIdproducto(Productos productosByIdproducto) {
        this.productosByIdproducto = productosByIdproducto;
    }
}
