package org.example;

import java.sql.Date;
import java.util.Objects;

public class Ventas {
    private int idventa;
    private Date fechaventa;
    private int cantidad;
    private Clientes clientesByIdcliente;
    private Productos productosByIdproducto;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ventas ventas = (Ventas) o;
        return idventa == ventas.idventa && cantidad == ventas.cantidad && Objects.equals(fechaventa, ventas.fechaventa);
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
