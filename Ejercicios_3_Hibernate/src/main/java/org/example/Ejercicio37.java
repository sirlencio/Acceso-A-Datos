package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;

public class Ejercicio37 {
    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        String hql = "FROM Clientes WHERE id = :idcliente";
        Query query = s.createQuery(hql);
        query.setParameter("idcliente", Integer.parseInt(args[0]));
        Clientes c = (Clientes) query.uniqueResult();

        if (c != null) {
            String hql2 = "FROM Ventas WHERE clientesByIdcliente = :cliente";
            Query query2 = s.createQuery(hql2);
            query2.setParameter("cliente", c);
            List<Ventas> ventasList = query2.list();
            int cont = 0, total = 0;
            for (Ventas v : ventasList) {
                System.out.println("--------------");
                System.out.println("Id venta: " + v.getIdventa());
                System.out.println("Fecha de venta: " + v.getFechaventa());
                System.out.println("Producto: " + v.getProductosByIdproducto().getDescripcion());
                System.out.println("Cantidad: " + v.getCantidad());
                System.out.println("PVP: " + v.getProductosByIdproducto().getPvp());
                double importe = (double) (v.getProductosByIdproducto().getPvp().intValueExact()) * (double) (v.getCantidad());
                System.out.println("Importe: " + importe);
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
