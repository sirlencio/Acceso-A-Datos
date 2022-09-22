import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Uno {

    //Crea un fichero con un editor de textos y realiza un programa que lea que
    //visualice su contenido. Modifica el programa para que acepte cualquier fichero
    //que se envíe desde la línea de comandos.

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca la ruta: ");
        FileReader f = new FileReader(input.nextLine());
        int valor = f.read();
        while (valor != -1) {
            System.out.print((char) valor);
            valor = f.read();
        }
        f.close();
    }
}