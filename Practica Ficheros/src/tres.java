import java.io.*;
import java.util.Scanner;

public class tres {
    //Realiza un programa para trabajar con un fichero de acceso aleatorio que contiene datos de departamentos
    // (id, nombre, presupuesto). 28 bytes
    //Se deberá mostrar un menú como el siguiente:
    //1-	Introducir datos (se comprobará que no exista el id que se introduce).
    //2-	Borrar un departamento (se pedirá el id del departamento)
    //3-	Consultar un departamento (se pedirá el id del departamento)
    //4-	Ver fichero (se mostraratodo el fichero)
    //5-	Fin
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int opc = 0;
        do {
            menu();
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Introduzca el id: ");
                    int id = input.nextInt();
                    if (comprobarID(id)) {
                        break;
                    }
                    System.out.print("Introduzca el nombre: ");
                    String nombre = input.next();
                    System.out.print("Introduzca el presupuesto: ");
                    int presu = input.nextInt();
                    introducir(id, nombre, presu);
                    break;
                case 2:
                    System.out.print("Introduzca el id: ");
                    id = input.nextInt();
                    borrado(id);
                    break;
                case 3:
                    System.out.print("Introduzca el id del departamento a consultar: ");
                    id = input.nextInt();
                    leer(id);
                    break;
                case 4:
                    leerTodo();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opc != 5);
    }

    public static void introducir(int id, String nombre, int presupuesto) throws IOException {
        File fichero = new File("AleatorioDep.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int posicion = (id - 1) * 28;
        file.seek(posicion);

        StringBuffer buffer = new StringBuffer(nombre); //buffer para almacenar nombre
        buffer.setLength(10);

        file.writeInt(id);
        file.writeChars(buffer.toString());
        file.writeInt(presupuesto);
        file.close();
    }

    public static void leer(int intro) throws IOException {
        File fichero = new File("AleatorioDep.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
        int id, presu, posicion = posicion = (intro - 1) * 28;
        char[] letras = new char[10];
        char aux;
        try {
            file.seek(posicion);

            id = file.readInt();
            if (intro != id) {
                throw new EOFException("El id no existe");
            }
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                letras[i] = aux;
            }
            String nombre = new String(letras);
            presu = file.readInt();
            System.out.printf("ID: %s, Nombre: %s, Presupuesto: %d %n", id, nombre, presu);
            file.close();
        } catch (EOFException e) {
            System.out.println("El id no existe");
        }
    }

    public static void leerTodo() throws IOException {
        try{
        File fichero = new File("AleatorioDep.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
        int id, presu, posicion;
        char[] letras = new char[10];
        char aux;
        posicion = 0;
        do {
            file.seek(posicion);
            id = file.readInt();
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                letras[i] = aux;
            }
            String nombre = new String(letras);
            presu = file.readInt();
            if (id > 0)
                System.out.printf("ID: %s, Nombre: %s, Presupuesto: %d %n", id, nombre, presu);
            posicion = posicion + 28;
        } while (file.getFilePointer() != file.length());
        file.close();
        }catch (EOFException ignored){}
    }

    public static void borrado(int intro) throws IOException {
        File fichero = new File("AleatorioDep.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int arreglo = 0, posicion = (intro - 1) * 28;
        int id = -1;
        file.seek(posicion);

        StringBuilder buffer = new StringBuilder(Integer.toString(intro));
        buffer.setLength(10);

        file.writeInt(id);
        file.writeChars(buffer.toString());
        file.writeInt(arreglo);
        file.writeInt(arreglo);
        file.close();
        System.out.println("Departamento borrado");
    }

    public static boolean comprobarID(int intro) throws IOException {
        try {
            File fichero = new File("AleatorioDep.dat");
            RandomAccessFile file = new RandomAccessFile(fichero, "r");
            int id, posicion = (intro - 1) * 28; //para situarnos en el id metido
            file.seek(posicion);
            id = file.readInt();
            if (id == intro) {
                System.out.println("El id ya existe");
                file.close();
                return true;
            }
            return false;
        } catch (EOFException e) { //Si el archivo no tiene el id
            return false;
        } catch (FileNotFoundException f) {
            return false;
        }
    }

    public static void menu() {
        System.out.println("1- Introducir datos");
        System.out.println("2- Borrar un departamento");
        System.out.println("3- Consultar un departamento");
        System.out.println("4- Ver fichero");
        System.out.println("5- Fin");
    }
}
