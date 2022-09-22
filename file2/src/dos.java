import java.io.FileWriter;
import java.io.IOException;

public class dos {
    //Escribe un programa que escriba los 100 primeros números naturales en un archivo numNaturales.txt.
    // Después visualiza el contenido del archivo.

    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("C:\\Users\\manana\\Downloads\\diablos.txt");
        String num = "";
        for (int i = 1; i < 101; i++) {
            num = num + " " + String.valueOf(i);
        }
        file.write(num);
        file.close();
    }
}
