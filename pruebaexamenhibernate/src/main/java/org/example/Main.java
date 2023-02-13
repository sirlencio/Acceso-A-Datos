package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.Collection;
import java.util.List;

public class Main {
    /*
    a) Crea un metodo que reciba un codigo de profesor y muestre el listado de asignaturas que imparte.
    Se debera comprobar que el profesor existe, mostrar su nombre y las asignaturas impartidas

    b) Crea un metodo que reciba un codigo de profesor y un numero de centro y modifique el centro
    en el que trabaja un profesor por el nuevo. Se comprobara que el centro nuevo existe y el profesor existen
    y se visualizaran los datos del centro anterior y del nuevo por pantalla

    c) Metodo que para cada centro muestre su nombre, el numero total de asignaturas que se impartan en el
    */
    public static void main(String[] args) {
        asignaturasProfe(1010);
        cambioCentro(2000, 1000);
        infoCentro();
    }

    private static void asignaturasProfe(int cod) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        Profesor p = s.get(Profesor.class, cod);
        if (p == null) {
            System.out.println("El profesor no existe");
        } else {
            System.out.println(p.getNombrePro());
            Collection<Asignatura> asignaturas = p.getAsignaturasByCodProf();
            for (Asignatura a : asignaturas) {
                System.out.println(a.getNombreAsi());
            }
        }
    }

    private static void cambioCentro(int codpro, int codcen) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Transaction tx = s.beginTransaction();
        Profesor p = s.get(Profesor.class, codpro);
        if (p == null) {
            System.out.println("El profesor no existe");
        } else {
            Centro c = s.get(Centro.class, codcen);
            if (c == null) {
                System.out.println("El centro no existe");
            } else {
                System.out.println("Centro anterior: " + p.getCentroByCodCentro().getNomCentro());
                System.out.println("Centro nuevo: " + c.getNomCentro());

                p.setCentroByCodCentro(c);
            }
        }
        s.update(p);
        tx.commit();
        System.out.println("Centro cambiado");
    }

    private static void infoCentro() {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();

        String hql = "from Centro";
        Query query = s.createQuery(hql);
        List<Centro> listac = query.list();
        for (Centro c : listac) {
            System.out.println(c.getNomCentro());
            int total = 0;
            for (Profesor p : c.getProfesorsByCodCentro()) {
                total += p.getAsignaturasByCodProf().size();
            }
            System.out.println(total + " asignaturas impartidas en este centro");
        }

    }
}
