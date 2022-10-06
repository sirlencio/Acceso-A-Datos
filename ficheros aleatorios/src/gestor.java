import java.io.*;
import java.util.Scanner;

public class gestor {

    //32 cada registro, asique el segundo registro empezaria en 32 (ya q empieza en 0)
    //https://www.discoduroderoer.es/como-leer-y-escribir-un-fichero-con-randomaccessfile/
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int cursor = 5, id, salario;
        do {
            menu();
            cursor = input.nextInt();
            switch (cursor) {
                case 1:
                    System.out.println("Ingrese el id: ");
                    id = input.nextInt();
                    System.out.println("Ingrese el departamento: ");
                    int depart = input.nextInt();
                    System.out.println("Ingrese el salario: ");
                    salario = input.nextInt();
                    System.out.println("Ingrese el apellido: ");
                    String apellido = input.next();
                    if (!comprobarID(id)) {
                        escribir(id, depart, salario, apellido);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el id: ");
                    id = input.nextInt();
                    leer(id);
                    break;
                case 3:
                    System.out.println("Ingrese el id: ");
                    id = input.nextInt();
                    System.out.println("Ingrese la suma para el nuevo salario: ");
                    salario = input.nextInt();
                    modificar(id, salario);
                    break;
                case 4:
                    System.out.println("Ingrese el id: ");
                    id = input.nextInt();
                    borrado(id);
                    break;
                case 5:
                    mostrarBorrados();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (cursor != 0);
    }

    public static void escribir(int metido, int depart, int salario, String apellido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int posicion = (metido - 1) * 32;
        file.seek(posicion);

        file.writeInt(metido);

        StringBuffer buffer = new StringBuffer(apellido); //buffer para almacenar apellido
        buffer.setLength(10);

        file.writeChars(buffer.toString());
        file.writeInt(depart);
        file.writeInt(salario);
        file.close();
    }

    public static boolean comprobarID(int metido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id, posicion;
        posicion = (metido - 1) * 32;        //para situarnos en el id metido

        try {
            do { //recorro el fichero
                file.seek(posicion); //nos posicionamos en posicion
                id = file.readInt(); // obtengo id de empleado
                if (id == metido) {
                    System.out.println("%nEl id ya existe%n");
                    file.close(); //cerrar fichero
                    return true;
                }
            } while (file.getFilePointer() != file.length());
            return false;
        } catch (EOFException e) { //Si el archivo no tiene el id
            return false;
        }
    }

    public static void leer(int metido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
        int id, dep, salario, posicion;
        char apellido[] = new char[10], aux;
        try {
            posicion = (metido - 1) * 32; //para situarnos en el id

            file.seek(posicion); //nos posicionamos en posicion

            id = file.readInt(); // obtengo id de empleado
            if (metido != id) {
                throw new EOFException("El id no existe");
            }
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }
            String apellidos = new String(apellido);
            dep = file.readInt(); //obtengo dep
            salario = file.readInt(); //obtengo salario

            System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %s %n", id, apellidos, dep, salario);

            file.close(); //cerrar fichero
        } catch (EOFException e) {
            System.out.println("El id no existe");
        }
    }

    public static void modificar(int metido, int salar) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile fileread = new RandomAccessFile(fichero, "r");


        int posicion = (metido - 1) * 32; //para situarnos en el id metido
        int id, dep, salario = 0;
        char apellido[] = new char[10], aux;
        String apellidos = "";

        try {
            fileread.seek(posicion); //nos posicionamos en posicion
            id = fileread.readInt(); // obtengo id de empleado
            if (metido != id) {
                throw new EOFException("El id no existe");
            } else {
                for (int i = 0; i < 10; i++) {
                    aux = fileread.readChar();
                    apellido[i] = aux;
                }
                apellidos = new String(apellido);
                dep = fileread.readInt(); //obtengo dep
                salario = fileread.readInt(); //obtengo salario

                fileread.close(); //cerrar fichero

                posicion = posicion + 4 + 20 + 4; // Se posicion en salario
                salar = salario + salar;

                RandomAccessFile filewrite = new RandomAccessFile(fichero, "rw");

                filewrite.seek(posicion);
                filewrite.writeInt(salar);
                filewrite.close();

                System.out.printf("Apellido: %s,  Salario antiguo: %s, Salario nuevo: %s %n", apellidos, salario, salar);
            }
        } catch (EOFException e) {
            System.out.println("El id no existe");
        }
    }

    public static void borrado(int metido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int arreglo = 0, posicion = (metido - 1) * 32;
        int id = -1;
        file.seek(posicion);

        file.writeInt(id);

        StringBuffer buffer = new StringBuffer(Integer.toString(metido));
        buffer.setLength(10);

        file.writeChars(buffer.toString());
        file.writeInt(arreglo);
        file.writeInt(arreglo);
        file.close();
        System.out.println("Empleado borrado");
    }

    public static void mostrarBorrados() throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, dep, posicion = 0;
        int salario;
        char apellido[] = new char[10], aux;
        do { //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            id = file.readInt(); // obtengo id de empleado
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }
            String apellidos = new String(apellido);
            dep = file.readInt(); //obtengo dep
            salario = file.readInt(); //obtengo salario
            if (id == -1) {
                System.out.printf("Id empleados borrados: %s %n", apellidos);
            }
            posicion = posicion + 32;
        } while (file.getFilePointer() != file.length());
        file.close(); //cerrar fichero
    }

    public static void menu() {
        System.out.println("¿Que desea hacer? :");
        System.out.println("1.- Ingresar datos");
        System.out.println("2.- Leer datos");
        System.out.println("3.- Modificar salario");
        System.out.println("4.- Borrar empleado");
        System.out.println("5.- Enseñar ids de empleados borrados");
        System.out.println("0.- Salir");
    }
}

