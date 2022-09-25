import java.io.*;

public class doce {
    //Programa Java que lee el contenido del fichero creado en el ejercicio 10 y lo muestra por pantalla.
    public static void main(String[] args) throws IOException {
        File archivo = new File("archivo.dat");
        FileInputStream f = new FileInputStream(archivo);
        DataInputStream d = new DataInputStream(f);
        StringBuffer buffer = new StringBuffer();
        int n = 0;
        while (d.available() > 0) {
            if (n == 0 || n == 1) {
                buffer.append(d.readInt());
                n++;
            } else {
                buffer.append(d.readDouble());
            }
        }
        System.out.println(buffer);
        f.close();
        d.close();
    }
}
