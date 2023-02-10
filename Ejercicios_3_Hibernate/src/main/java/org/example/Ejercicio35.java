package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio35 {
    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        System.out.println("=========================");
        System.out.println("Datos del cliente.");
        Clientes cli = s.get(Clientes.class, Integer.parseInt(args[0]));

        if (cli != null) {
            System.out.println("Ventas del cliente: " + cli.getNombre());
            System.out.println("Venta: ");
            //Obtenemos la venta
            Collection<Ventas> listaVenta = cli.getVentasById();
            int cont = 0, total = 0;
            for (Ventas ven : listaVenta) {
                System.out.println("--------------");
                System.out.println("Id venta: " + ven.getIdventa());
                System.out.println("Fecha de venta: " + ven.getFechaventa());
                System.out.println("Producto: " + ven.getProductosByIdproducto().getDescripcion());
                System.out.println("Cantidad: " + ven.getCantidad());
                System.out.println("PVP: " + ven.getProductosByIdproducto().getPvp());
                double importe = (double) (ven.getProductosByIdproducto().getPvp().intValueExact()) * (double) (ven.getCantidad());
                System.out.println("\t Importe: " + importe);
                cont++;
                total += importe;
            }
            System.out.println("====================");
            System.out.println("Total ventas: " + cont);
            System.out.println("Importe total: " + total);
            s.close();
        } else {
            System.out.println("No se encontró un cliente con el identificador: " + args[0]);
        }
    }
}