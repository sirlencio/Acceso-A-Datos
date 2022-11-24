import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class dieciseis_leer {
    public static void main(String[] args) throws IOException {
        Agenda agenda;
        File fichero = new File("agenda.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datalS = new ObjectInputStream(filein);
        try {
            while (true) {
                agenda = (Agenda) datalS.readObject();
                System.out.printf("Nombre: " + agenda.getNombre() + "%nApellidos: " + agenda.getApellidos() + "%nTelefono: " + agenda.getTelefono() + "\n");
            }
        } catch (IOException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        datalS.close();
    }
}
