import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class cinco {

    /*  Escribe un programa que lea las últimas cotizaciones que aparecen en la página
        http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201
        y las guarde en un fichero de objetos (se guardará: el nombre de la empresa,
        la fecha de hoy (del sistema), la hora y el valor de la cotización).
        Crear la clase Cotización con los métodos:
        GrabarCotización (se hará desde la URL),
        LeerCotización (se mostrará todo el contenido del fichero)
        y VerCotización(día,hora).  */
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int opc = 0;
        do {
            menu();
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    grabarCotizacion();
                    break;
                case 2:
                    leerCotizacion();
                    break;
                case 3:
                    verCotizacion();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opc != 4);
    }

    public static void grabarCotizacion() throws IOException {
        //Creacion objeto
        Cotizacion objeto;
        URL url = new URL("https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201");
        URLConnection conexion = url.openConnection();

        InputStream is = conexion.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String todo;
        String guardado = "";
        while ((todo = br.readLine()) != null)
            guardado += todo;
        br.close();

        //Guardamos el nombre localizando un span despues de un h1
        String nombre = guardado.substring(guardado.indexOf("<h1><span>"), guardado.indexOf("</span>", guardado.indexOf("<h1><span>")));
        nombre = nombre.substring(nombre.lastIndexOf(">") + 1);

        //Guardamos el valor de la cotizacion
        String valor = guardado.substring(guardado.indexOf("<td id=\"cotizacion"), guardado.indexOf("</td>", guardado.indexOf("<td id=\"cotizacion")));
        String hora = valor;
        valor = valor.substring(valor.indexOf(">") + 1, valor.indexOf("("));
        hora = hora.substring(hora.indexOf("(") + 1, hora.indexOf(")"));
        objeto = new Cotizacion(nombre, hora, valor);

        //Escribir fichero
        File archivo = new File("cotizacion.dat");
        ObjectOutputStream dataOS;
        if (!archivo.exists()) {
            FileOutputStream fileout = new FileOutputStream(archivo);
            dataOS = new ObjectOutputStream(fileout);
        } else {
            dataOS = new MiObjectOutputStream(new FileOutputStream(archivo, true));
        }
        dataOS.writeObject(objeto);
        dataOS.close();
        System.out.println("Fichero creado");
    }

    public static void leerCotizacion() throws IOException {
        Cotizacion objeto;
        try {
            File fichero = new File("cotizacion.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream datalS = new ObjectInputStream(filein);

            try {
                while (true) {
                    objeto = (Cotizacion) datalS.readObject();
                    System.out.println(objeto.toString());
                }
            } catch (IOException | ClassNotFoundException eo) {
                System.out.println("Fichero leido");
            }
            datalS.close();
        } catch (FileNotFoundException f) {
            System.out.println("Fichero no creado");
        }
    }

    public static void verCotizacion() throws IOException {
        System.out.println("Introduzca la fecha a comprobar (dd/MM): ");
        String fechaintro = input.next();
        System.out.println("Introduzca la hora a comprobar (hh:mm): ");
        String horaintro = input.next();
        Cotizacion objeto;
        try {
            File fichero = new File("cotizacion.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream datalS = new ObjectInputStream(filein);

            try {
                while (true) {
                    objeto = (Cotizacion) datalS.readObject();
                    if (objeto.getDia().equals(fechaintro) && objeto.getHora().equals(horaintro)) {
                        System.out.println(objeto);
                    } else {
                        System.out.println("Cotizacion no encontrada en esa fecha y hora");
                    }
                }
            } catch (IOException | ClassNotFoundException eo) {
                System.out.println("Fichero leido");
            }
            datalS.close();
        } catch (FileNotFoundException f) {
            System.out.println("Fichero no creado");
        }
    }

    public static void menu() {
        System.out.println("Que desea hacer");
        System.out.println("1.- Grabar cotizacion");
        System.out.println("2.- Leer cotizacion");
        System.out.println("3.- Ver cotizacion");
        System.out.println("4.- Salir");
    }
}
