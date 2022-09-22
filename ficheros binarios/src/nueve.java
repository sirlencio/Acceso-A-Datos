import java.io.*;
import java.util.Scanner;

public class nueve {
    //Programa que lee enteros por teclado y los escribe en el fichero binario “datos.dat”.
    public static void main(String[] args) throws IOException {
        System.out.println("Metele entero: ");
        Scanner input  = new Scanner(System.in);
        File archivo = new File("datos.dat");
        FileOutputStream f = new FileOutputStream(archivo);
        DataOutputStream d = new DataOutputStream(f);

        d.writeInt(input.nextInt());
    }
}