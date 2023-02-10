package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;

public class Main {
    // Crea un metodo para actualizar los campos numaccesos, numlineas, numviajesdestino y numviajesprocedencia
    // de las estaciones de la tabla T_Estaciones.
    // Estas columnas deben contener el numero de accesos que tiene la estacion (numaccesos),
    // el numero de lineas que pasan por la estacion (numlineas),
    // el numero de viajes que la tienen como destino (numviajesdestino),
    // y el numero de viajes que la tienen como procedencia (numviajesprocedencia)
    public static void main(String[] args) {
        //ejercicio3();
        ejercicio4();
    }

    public static void ejercicio3() {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Transaction tx = s.beginTransaction();

        String hql = "from TEstaciones";
        Query query = s.createQuery(hql);
        List<TEstaciones> listaEstaciones = query.list();
        for (TEstaciones estacion : listaEstaciones) {
            String hql2 = "from TViajes where tEstacionesByEstaciondestino = :destino";
            Query query1 = s.createQuery(hql2);
            query1.setParameter("destino", estacion);
            int destinos = query1.list().size();

            String hql3 = "from TViajes where tEstacionesByEstacionorigen = :origen";
            Query query2 = s.createQuery(hql3);
            query2.setParameter("origen", estacion);
            int origenes = query2.list().size();

            estacion.setNumaccesos(estacion.gettAccesosByCodEstacion().size());
            estacion.setNumlineas(estacion.gettLineaEstacionsByCodEstacion().size());
            estacion.setNumviajesdestino(destinos);
            estacion.setNumviajesprocedencia(origenes);
            s.update(s);
        }
        tx.commit();
    }

    public static void ejercicio4() {
        // METODO QUE VISUALICE POR CADA ESTACION EL NUM LINEAS QUE PASAN, EL NUM ACCESO QUE TIENE
        // EL NUM DE VIAJES QUE  TIENE COMO DESTINO LA ESTACION Y VIAJES CON SU NOM Y COD
        // VIAJES DE PROCEDENCIA TAMBIEN
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session session = sesionF.openSession();
        Query query = session.createQuery("from TEstaciones ");
        List<TEstaciones> estaciones = query.list();
        for (TEstaciones e : estaciones) {
            System.out.println("NOMBRE ESTACION: " + e.getNombre() + "; CODIGO ESTACION: " + e.getCodEstacion());
            Collection TLE = e.gettLineaEstacionsByCodEstacion();
            Collection TAc = e.gettAccesosByCodEstacion();
            System.out.println("    NUMERO DE LINEAS = " + TLE.size());
            System.out.println("    NUMERO DE ACCESOS = " + TAc.size());
            Collection CVDestino = e.gettViajesByCodEstacion();
            Collection CVOrigen = e.gettViajesByCodEstacion_0();
            System.out.println("    NUMERO DE VIAJES DESTINO = " + CVDestino.size());
            for (Object oo : CVDestino) {
                TViajes TV = (TViajes) oo;
                System.out.println("        -------------------------------");
                System.out.println("        CODIGO VIAJE = " + TV.getCodViaje() + "; NOMBRE = " + TV.getNombre());
                System.out.println("        ORIGEN: " + TV.gettEstacionesByEstacionorigen().getNombre() + "; DESTINO: " + TV.gettEstacionesByEstaciondestino().getNombre());
                System.out.println("        -------------------------------");
            }
            System.out.println("    NUMERO VIAJES PROCEDENCIA = " + CVOrigen.size());
            for (Object ooo : CVOrigen) {
                System.out.println("        -------------------------------");
                TViajes TV = (TViajes) ooo;
                System.out.println("        CODIGO VIAJE = " + TV.getCodViaje() + "; NOMBRE = " + TV.getNombre());
                System.out.println("        ORIGEN: " + TV.gettEstacionesByEstacionorigen().getNombre() + "; DESTINO: " + TV.gettEstacionesByEstaciondestino().getNombre());
                System.out.println("        -------------------------------");
            }
            System.out.println("===============================");

        }
    }


}
