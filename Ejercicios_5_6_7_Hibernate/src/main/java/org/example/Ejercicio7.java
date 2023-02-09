package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Scanner;

public class Ejercicio7 {
    // Realiza un programa Java que inserte estadisticas para el jugador 123.
    // Los datos a insertas son los siguientes: temporada 05/06: puntos por partido 7, rebotes 5;
    // temporada 06/07 puntos por partido 10, tapones 3.
    // Los valores no indicados tendran valor 0.
    // Transforma despues el programa para que todos los valores a insertar se
    // introduzcan a partir de los argumentos de main. Controlas posibles errores,
    // numero de argumentos correctos, que el jugador exista, que la estadistica no exista, etc.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Eliga una opcion: ");
            System.out.println("1.- Insertar estadisticas predefinidas");
            System.out.println("2.- Insertar estadisticas por argumentos");
            System.out.println("0.- Salir");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    estadisticasPredf();
                    break;
                case 2:
                    estadisticasArgs(args);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opc != 0);

    }

    public static void estadisticasPredf() {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Transaction tx = s.beginTransaction();

        Jugadores j = s.get(Jugadores.class, 123);

        Estadisticas es = new Estadisticas();
        es.setJugadoresByJugador(j);
        es.setTemporada("05/06");
        es.setPuntosPorPartido(7.0);
        es.setRebotesPorPartido(5.0);
        es.setAsistenciasPorPartido(0.0);
        es.setTaponesPorPartido(0.0);
        s.save(es);

        Estadisticas es2 = new Estadisticas();
        es2.setJugadoresByJugador(j);
        es2.setTemporada("06/07");
        es2.setPuntosPorPartido(10.0);
        es2.setRebotesPorPartido(0.0);
        es2.setAsistenciasPorPartido(0.0);
        es2.setTaponesPorPartido(3.0);
        s.save(es2);

        System.out.println("Estadisticas insertadas correctamente");
        tx.commit();
    }

    //Orden de argumentos, temporada, puntos, asists, tapones y rebotes
    public static void estadisticasArgs(String[] args) {
        if (args.length < 5) { //Compruebo q minimo meta un numero de argumentos
            System.err.println("Numero de argumentos no validos");
        } else {
            SessionFactory sesionF = HibernateUtil.getSessionFactory();
            Session s = sesionF.openSession();
            Transaction tx = s.beginTransaction();

            String temporada = args[0];
            Jugadores j = s.get(Jugadores.class, 123);
            if (j != null) { // Compruebo que el jugador exista
                String hql = "from Estadisticas where temporada like :season and jugadoresByJugador = :idjugador";
                Query query = s.createQuery(hql);
                query.setParameter("season", temporada);
                query.setParameter("idjugador", j);
                Estadisticas es = (Estadisticas) query.uniqueResult();
                if (es == null) { // Compruebo que la estadistica q voy a crear no exista
                    double puntos = Float.parseFloat(args[1]), asist = Float.parseFloat(args[2]), tapon = Float.parseFloat(args[3]), reb = Float.parseFloat(args[4]);
                    es = new Estadisticas();
                    es.setJugadoresByJugador(j);
                    es.setTemporada(temporada);
                    es.setPuntosPorPartido(puntos);
                    es.setRebotesPorPartido(reb);
                    es.setAsistenciasPorPartido(asist);
                    es.setTaponesPorPartido(tapon);
                    s.save(es);
                    tx.commit();
                    System.out.println("Estadistica insertada correctamente");
                } else {
                    System.err.println("La estadistica ya existe");
                }
            } else {
                System.err.println("El jugador no existe");
            }

        }
    }
}
