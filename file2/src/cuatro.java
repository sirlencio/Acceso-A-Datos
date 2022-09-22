import java.io.*;
import java.util.Scanner;

public class cuatro {
    //Escribir un método que reciba por parámetro dos rutas correspondientes a un archivo de origen y otro de destino
    // y que copie el archivo origen en la ubicación destino. La ruta destino puede consistir en un directorio o un archivo.
    // En el primer caso, el archivo se copiará al directorio especificado manteniendo su nombre.
    // En el segundo, se tomará como nombre del archivo copia el que especifique su ruta.

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca la direccion de origen: ");
        String ori = input.nextLine();
        System.out.println("Introduzca la direccion de destino: ");
        String des = input.nextLine();
        rutas(ori, des);
    }

    public static void rutas(String origen, String destino) throws IOException {
        FileReader lee = new FileReader(origen);

        File arc = new File(destino);
        FileWriter esc;
        if (arc.isDirectory()) {
            esc = new FileWriter(destino + "/" + arc.getName());
        } else {
            esc = new FileWriter(destino);
        }

        int valor = 0;
        while (valor != -1) {
            valor = lee.read();
            esc.write(valor);
        }
        lee.close();
        esc.close();

    }
}
