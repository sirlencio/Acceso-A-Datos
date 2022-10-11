import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class uno {
    //Escribe un programa que cuente  el número de vocales de cada fichero de texto
    //que se pasa como parámetro (pueden ser varios: "file1.txt file3.txt file2.txt").
    //En la salida estándar se escribirá el nombre de cada fichero, junto al número de vocales del mismo.
    //De ocurrir un error al intentar leer alguno de los ficheros, se debe imprimir un mensaje para ese archivo,
    // pero se deben procesar todos los ficheros restantes.
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                char[] vocales = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú' };
                File f = new File(arg);
                FileReader fr = new FileReader(f);

                int valor = fr.read();
                String palabra = "";
                while (valor != -1) {
                    palabra += (char) valor + "";
                    valor = fr.read();
                }
                fr.close();

                int contador = 0;
                for (int k = 0; k < palabra.length(); k++) {
                    for (int j = 0; j < vocales.length; j++) {
                        if (palabra.toLowerCase().charAt(k) == vocales[j]) {
                            contador++;
                        }
                    }
                }

                System.out.println("El fichero " + arg + " contiene " + contador + " vocales");
            } catch (FileNotFoundException f) {
                System.out.println("El archivo no existe");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}