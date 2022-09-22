import java.io.File;
import java.util.Scanner;

public class cuatro {
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");

        Scanner input = new Scanner(System.in);
        File f = new File(input.nextLine());
        File[] archivos = f.listFiles();
        for (int i = 0 ; i< archivos.length; i++){
            System.out.println(archivos[i].getName());
            if (archivos[i].isDirectory()){
                File marcador = new File(archivos[i].getPath());
                File[] dentro = marcador.listFiles();
                for (int j = 0 ; j< dentro.length; j++) {
                    System.out.println(dentro[j].getName());
                }
            }
        }
    }
}
