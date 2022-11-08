import java.io.*;

public class ejercicio4 {

    //Escribe un programa para leer los datos de las cotizaciones grabadas mediante serialización
    // en el ejercicio nº 5 de la práctica anterior y grabarlas en un documento cotizaciones.xml
    // con el siguiente formato para cada empresa:
    /*<Empresas>
        <empresa>
            <nombre>nombre</nombre>
            <fecha>fecha</fecha>
            <hora>hora</hora>
            <cotizacion>cotizacion</cotizacion>
        </empresa>
        …
        <Empresas>*/

    public static void main(String[] args) throws IOException {
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
}