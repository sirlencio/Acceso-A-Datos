import java.io.*;

public class once {
    //Programa que lee el contenido del fichero creado en el ejercicio 9. Utilizaremos un bucle infinito para leer los datos.
    // Cuando se llega al final del fichero se lanza la excepción EOFException que se utiliza para salir del bucle while.
    public static void main(String[] args) throws IOException {
        File archivo = new File("datos.dat");
        FileInputStream f = new FileInputStream(archivo);
        DataInputStream d = new DataInputStream(f);
        StringBuffer buffer = new StringBuffer();

        while (d.available()>0){
            buffer.append(d.readInt());
        }
        System.out.println(buffer);
        f.close();
        d.close();
    }
}
