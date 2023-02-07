package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Set;

public class Ejercicio35 {
    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        System.out.println("=========================");
        System.out.println("Datos del cliente.");
        Clientes cli = s.get(Clientes.class, 1);

        System.out.println("Ventas del cliente: " + cli.getNombre());
        System.out.println("Venta: ");
        //Obtenemos la venta
        Set <Ventas> listaVenta = (Set<Ventas>) cli.getVentasById();
        int cont = 0, total = 0;
        for (Ventas ven : listaVenta) {
            System.out.println("--------------");
            System.out.println("\t Id venta: " + ven.getIdventa());
            System.out.println("\t Fecha de venta: " + ven.getFechaventa());
            System.out.println("\t Producto: " + ven.getProductosByIdproducto().getDescripcion());
            System.out.println("\t Cantidad: " + ven.getCantidad());
            System.out.println("\t PVP: " + ven.getProductosByIdproducto().getPvp());
            double importe = (double) (ven.getProductosByIdproducto().getPvp().intValueExact()) * (double) (ven.getCantidad());
            System.out.println("\t Importe: " + importe);
            cont++;
            total += importe;
        }
        System.out.println("====================");
        System.out.println("Total ventas: " + cont);
        System.out.println("Importe total: " + total);
        s.close();
        System.exit(0);
    }
}