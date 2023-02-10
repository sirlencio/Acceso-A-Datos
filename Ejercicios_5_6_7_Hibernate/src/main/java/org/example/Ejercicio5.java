package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

    //  Realiza un programa Java que admita un argumento desde main, este argumento es el codigo de un jugador.
    //  El programa debe mostrar las estadisticas del jugador. Se deben controlas situaciones de error,
    //  si no se introduce ningun parametro o el parametro no es correcto (debe ser numerico)
    //  se debe mostrar un mensaje de error; si el jugador no existe muestra un mensaje indicandolo.
    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        int id = 0;
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException number) {
            System.err.println("No has metido un numero: " + number.getMessage());
            System.exit(0);
        }
        Jugadores j = s.get(Jugadores.class, id);

        if (j != null) {
            System.out.println("DATOS DEL JUGADOR: " + j.getCodigo());
            System.out.println("Nombre : " + j.getNombre());
            System.out.println("Equipo : " + j.getEquiposByNombreEquipo().getNombre());
            System.out.println("Temporada    Ptos    Asis    Tap    Reb");
            System.out.println("==========================================");
            for (Estadisticas e : j.getEstadisticasByCodigo()) {
                System.out.println(e.getTemporada() + "       " + e.getPuntosPorPartido() + "      " + e.getAsistenciasPorPartido() + "     " + e.getTaponesPorPartido() + "     " + e.getRebotesPorPartido());
            }
            System.out.println("==========================================");
            System.out.println("Num de registros: " + j.getEstadisticasByCodigo().size());
            System.out.println("==========================================");
        } else {
            System.out.println("El jugador no existe");
        }
    }
}
