import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class dos {
    //Crea un programa que lea los primeros 54 bytes de un fichero BMP (su cabecera) y
    // compruebe si los dos primeros bytes de esos 54 corresponden a las letras B y M.
    // Si lo son, escribirá el mensaje “Parece un BMP válido”, si no es así,
    // mostrará el mensaje "No es un BMP válido.
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el fichero: ");
        try {
            FileInputStream file = new FileInputStream(new File(input.nextLine()));
            byte[] buf = new byte[54];
            file.read(buf);
            file.close();

            String s = new String(buf, StandardCharsets.UTF_8);
            if (s.charAt(0) == 'B' && s.charAt(1) == 'M') {
                System.out.println("Parece un BMP valido");
            } else {
                System.out.println("No es un BMP valido");
            }
        } catch (FileNotFoundException f) {
            System.out.println("Fichero no encontrado");
        }
    }
}
