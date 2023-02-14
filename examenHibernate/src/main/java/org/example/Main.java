package org.example;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        peliculasActor(3);

        borrarActor(3);

        //cambioDirector(99, 99);
    }

    /*private static void cambioDirector(int idpel, int iddir) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Transaction tx = s.beginTransaction();

        Peliculas pe = s.get(Peliculas.class, idpel);
        if (pe != null) {
            String hql = "from Peliculas where artistasByDirectorId = :iddir";
            Query query = s.createQuery(hql);
            Artistas a = s.get(Artistas.class, iddir);
            if (a == null) {
                System.out.println("El director no existe, creelo: ");
                a = new Artistas();
                a.setArtistaId(iddir);
                System.out.println("Introduzca el nombre: ");
                a.setNombre(input.nextLine());
                a.setFechaNac(new Date(System.currentTimeMillis()));
                a.setFechaDef(null);

            } else {
                System.out.println("Datos director nuevo: ");
                System.out.println(a.getNombre());
                System.out.println(a.getFechaNac());
                if (a.getFechaDef() == null) {
                    System.out.println("Sigue vivo");
                } else {
                    System.out.println(a.getFechaDef());
                }

                List<Peliculas> listaP = query.list();
                for (Peliculas p : listaP) {
                    Artistas anterior = p.getArtistasByDirectorId();
                    System.out.println("Datos director anterior: ");
                    System.out.println(anterior.getNombre());
                    System.out.println(anterior.getFechaNac());
                    if (a.getFechaDef() == null) {
                        System.out.println("Sigue vivo");
                    } else {
                        System.out.println(anterior.getFechaDef());
                    }
                    p.setArtistasByDirectorId(a);
                    s.update(p);
                    System.out.println("Pelicula cambiada");
                }
            }
            tx.commit();
        } else {
            System.out.println("Esa pelicula no existe");
        }
    }*/

    public static void borrarActor(int id) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Transaction tx = s.beginTransaction();

        Artistas a = s.get(Artistas.class, id);
        if (a != null) {
            Collection<PelArt> listapelArt = a.getPelArtsByArtistaId();
            for (PelArt pelArt : listapelArt) {
                s.delete(pelArt);
            }
            Collection<Peliculas> listaPel = a.getPeliculasByArtistaId();
            for (Peliculas pel : listaPel) {
                Collection<PelArt> listapelA = pel.getPelArtsByPeliculaId();
                if (listapelA.size() > 0) {
                    for (PelArt pa : listapelA) {
                        s.delete(pa);
                    }
                }
                s.delete(pel);
            }

            s.delete(a);
            tx.commit();
            System.out.println("Actor eliminado");
        } else {
            System.out.println("El artista no existe");
        }
    }

    public static void peliculasActor(int id) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        Artistas a = s.get(Artistas.class, id);
        if (a != null) {
            System.out.println("Nombre actor: " + a.getNombre());
            System.out.println("Fecha nacimiento: " + a.getFechaNac());
            Collection<PelArt> lista = a.getPelArtsByArtistaId();
            if (lista.size() > 0) {
                System.out.println("=========================");
                for (PelArt pelArt : lista) {
                    Peliculas p = pelArt.getPeliculasByPeliculaId();
                    System.out.println(p.getTitulo());
                    System.out.println(p.getPeliAnno());
                    System.out.println(p.getEstudiosByEstudioId().getNombre());
                    System.out.println("=========================");

                }
            } else {
                System.out.println("No actua en ninguna pelicula");
            }

        } else {
            System.out.println("El artista no existe");
        }
    }
}
