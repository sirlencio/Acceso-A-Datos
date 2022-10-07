import java.io.*;
import java.util.Scanner;

public class dicisiete {

    //Programa para gestionar una lista de productos (código, descripción, unidades, precio) que se venden en nuestra empresa.
    // Escribiremos la información de estos productos en un fichero “productos.dat”, para almacenarlos de forma persistente.
    //Se pide:
    //a) Introducir el código necesario en el método almacenar de la clase GestorProductos para guardar la información de los productos en el fichero.
    // Guardaremos esta información codificada en un fichero binario.

    //b) Introducir el código en el método recuperar para cargar la información de este fichero.

    //c) Modificar el código anterior parapara que en las siguientes ejecuciones
    // los datos se añadan al fichero (es decir, si existe el fichero no se sobreescribirá).

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int cursor = 1;
        while (cursor != 0){
            System.out.println("%nQue desea hacer:");
            System.out.println("1.-Almacenar");
            System.out.println("2.-Leer");
            System.out.println("0.-Salir%n");
            cursor = input.nextInt();
            if (cursor == 1) {
                almacenar();
            } else if (cursor == 2) {
                recuperar();
            }else {
                break;
            }
        }

    }

    public static void almacenar() throws IOException {
        producto pro;

        File archivo = new File("productos.dat");
        ObjectOutputStream dataOS;
        if (!archivo.exists()) {
            FileOutputStream fileout = new FileOutputStream(archivo);
            dataOS = new ObjectOutputStream(fileout);
        } else {
            dataOS = new MiObjectOutputStream(new FileOutputStream(archivo, true));
        }

        int id[] = {1, 2, 3};
        String descripcion[] = {"tornillo", "tuerca", "rata"};
        int unidades[] = {50, 60, 5};
        int precio[] = {150, 145, 50};

        for (int i = 0; i < id.length; i++) {
            pro = new producto(id[i], descripcion[i], unidades[i], precio[i]);
            dataOS.writeObject(pro);
        }
        dataOS.close();
    }

    public static void recuperar() throws IOException {
        producto pro;
        File fichero = new File("productos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datalS = new ObjectInputStream(filein);
        try {
            while (true) {
                pro = (producto) datalS.readObject();
                System.out.printf("ID: " + pro.getCodigo() + "%nDescripcion: " + pro.getDescripcion() + "%nUnidades: " + pro.getUnidades() + "%nPrecio: " + pro.getPrecio() + "\n");
            }
        } catch (IOException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        datalS.close();
    }

}
