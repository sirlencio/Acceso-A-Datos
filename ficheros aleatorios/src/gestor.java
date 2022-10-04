import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class gestor {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int cursor = 5;
        do {
            menu();
            cursor = input.nextInt();
            switch (cursor) {
                case 1:
                    System.out.println("Ingrese el id: ");
                    int id = input.nextInt();
                    System.out.println("Ingrese el departamento: ");
                    int depart = input.nextInt();
                    System.out.println("Ingrese el salario: ");
                    int salario = input.nextInt();
                    System.out.println("Ingrese el apellido: ");
                    String apellido = input.next();
                    if (!comprobarID(id)) {
                        escribir(id, depart, salario, apellido);
                    }
                    break;
                case 2:

            }

        } while (cursor != 0);
    }

    public static void escribir(int metido, int depart, int salario, String apellido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        StringBuffer buffer = null; //buffer para almacenar apellido

        file.writeInt(metido);
        buffer = new StringBuffer(apellido);
        buffer.setLength(10);
        file.writeChars(buffer.toString());
        file.writeInt(depart); //insertar departamento
        file.writeDouble(salario);//insertar salario
        file.close(); //cerrar fichero
    }

    public static boolean comprobarID(int metido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
        int id, posicion;
        posicion = 0; //para situarnos al principio
        do { //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            id = file.readInt(); // obtengo id de empleado
            if (id == metido) {
                System.out.println("El id ya existe");
                file.close(); //cerrar fichero
                return true;
            } else {
                file.close(); //cerrar fichero
                return false;
            }
        } while (file.getFilePointer() != file.length());
    }

    public static void menu() {
        System.out.println("¿Que desea hacer? :");
        System.out.println("1.- Ingresar datos");
        System.out.println("2.- Leer datos");
        System.out.println("0.- Salir");
    }
}

