import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class tres {
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");

        Scanner input = new Scanner(System.in);
        File f = new File(input.nextLine(), "NUEVODIR");

        if (f.exists()) {
            System.out.println("La carpeta ya existe");
        } else if (f.mkdir()) {
            File fille = new File(f, "arc1");
            File fille2 = new File(f, "arc2");

            try {
                if (fille.createNewFile()) {
                    System.out.println("Archivo 1 creado correctamente");
                    System.out.println("Que nombre le quieres poner: ");
                    File temp = new File(f + "/" + input.nextLine());
                    if (fille.renameTo(temp)) {
                        System.out.println("Nombre cambiado");
                    }
                }
                if (fille2.createNewFile()) {
                    System.out.println("Archivo 2 creado correctamente");
                    if (fille2.delete()) {
                        System.out.println("Archivo 2 borrado correctamente");
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
