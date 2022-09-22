import java.io.File;
import java.util.Scanner;

public class uno {
    public static void main(String[] args) {
        System.out.println("Introduzca la ruta: ");

        Scanner input = new Scanner(System.in);
        File f = new File(input.nextLine());
        String[] nombres = f.list();
        File[] archivos = f.listFiles();

        System.out.println("Hay un total de " + nombres.length + " archivos");
        for (int i = 0 ; i< nombres.length; i++){
            String nombre = nombres[i];
            if (archivos[i].isDirectory()){
                System.out.println(nombre + " es un directorio");
            }else {
                System.out.println(nombre + " es un archivo");
            }
        }
    }
}