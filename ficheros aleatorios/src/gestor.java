import java.io.*;
import java.util.Scanner;

public class gestor {

    //32 cada registro, asique el segundo registro empezaria en 32 (ya q empieza en 0)
    //https://www.discoduroderoer.es/como-leer-y-escribir-un-fichero-con-randomaccessfile/
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int cursor = 5, id;
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
                    int salario = input.nextInt();
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
                posicion = posicion + 32;
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

    public static void menu() {
        System.out.println("¿Que desea hacer? :");
        System.out.println("1.- Ingresar datos");
        System.out.println("2.- Leer datos");
        System.out.println("0.- Salir");
    }
}

