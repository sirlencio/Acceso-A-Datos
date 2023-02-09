package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.Collection;
import java.util.List;

public class Ejercicio6 {
    //  Realiza un programa Java que muestre por cada equipo
    //  la lista de sus jugadores con la media de los puntos por partido.
    //  El listado debe aparecer ordenado por equipo.
    //  Debe mostrar tambien el numero de equipo que hay
    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        String hql = "from Equipos order by nombre";
        Query query = s.createQuery(hql);
        List<Equipos> listaEQ = query.list();
        System.out.println("Numero de equipos: " + listaEQ.size());
        System.out.println("====================================");
        for (Equipos eq : listaEQ) {
            System.out.println("Equipo: " + eq.getNombre());
            Collection<Jugadores> listaJ = eq.getJugadoresByNombre();
            for (Jugadores j: listaJ) {
                Collection<Estadisticas> listaEs = j.getEstadisticasByCodigo();
                float suma = 0;
                for (Estadisticas es: listaEs) {
                    suma += es.getPuntosPorPartido();
                }
                System.out.println(j.getCodigo() + ", " + j.getNombre() + ": " + (suma / j.getEstadisticasByCodigo().size()));
            }
            System.out.println("====================================");
        }
    }
}
