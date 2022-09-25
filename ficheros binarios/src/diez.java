import java.io.*;
import java.util.Scanner;

public class diez {
    //Programa Java que crea un array de elementos de tipo double y lee por teclado el valor de sus elementos.
    // A continuación escribe el contenido del array en un fichero.
    // Al principio del fichero se escriben dos enteros con los valores del número de filas y columnas del array

    public static void main(String[] args) throws IOException {
        File arch = new File("archivo.dat");
        FileOutputStream f = new FileOutputStream(arch);
        DataOutputStream d = new DataOutputStream(f);

        Scanner input = new Scanner(System.in);
        System.out.println("Escriba cuantas filas debera tener el array: ");
        int x = input.nextInt();
        System.out.println("Escriba cuantas columnas debera tener el array: ");
        int y = input.nextInt();
        double[][] array = new double[x][y];

        d.writeInt(x);
        d.writeInt(y);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("Escriba lo que desee guardar: ");
                array[i][j] = input.nextDouble();
                d.writeDouble(array[i][j]);
            }
        }
        d.close();
        f.close();
    }
}
