package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    // Crea un metodo para actualizar los campos numaccesos, numlineas, numviajesdestino y numviajesprocedencia
    // de las estaciones de la tabla T_Estaciones.
    // Estas columnas deben contener el numero de accesos que tiene la estacion (numaccesos),
    // el numero de lineas que pasan por la estacion (numlineas),
    // el numero de viajes que la tienen como destino (numviajesdestino),
    // y el numero de viajes que la tienen como procedencia (numviajesprocedencia)
    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Transaction tx = s.beginTransaction();

        String hql = "from TEstaciones";
        Query query = s.createQuery(hql);
        List <TEstaciones> listaEstaciones = query.list();
        for (TEstaciones estacion: listaEstaciones) {
            int n = estacion.getCodEstacion();
            String hql2 = "from TViajes where tEstacionesByEstaciondestino = :destino";
            Query query1 = s.createQuery(hql2);
            query1.setParameter("destino", n);
            int destinos = query1.list().size();

            String hql3 = "from TViajes where tEstacionesByEstacionorigen = :origen";
            Query query2 = s.createQuery(hql3);
            query2.setParameter("origen", n);
            int origenes = query2.list().size();

            estacion.setNumaccesos(estacion.gettAccesosByCodEstacion().size());
            estacion.setNumlineas(estacion.gettLineaEstacionsByCodEstacion().size());
            estacion.setNumviajesdestino(destinos);
            estacion.setNumviajesprocedencia(origenes);
            s.update(s);
        }
        tx.commit();
    }
}
