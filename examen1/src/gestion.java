import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class gestion {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("Que desea hacer?");
            System.out.println("1.- Escribir fichero");
            System.out.println("2.- Leer fichero");
            System.out.println("3.- Leer formato csv");
            System.out.println("0.- Salir");
            opc = input.nextInt();
            switch (opc){
                case 1:
                    escribirdat();
                    break;
                case 2:
                    leerfichero();
                    break;
                case 3:
                    formCSV();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
            }
        }while (opc!=0);
    }

    public static void formCSV() {
        Cliente cliente;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            System.out.println(cliente.getNombre() + "," + cliente.getEdad() + "," + cliente.getCiudad() + "," + cliente.getDescuento());
        }
    }

    public static void leerfichero() throws IOException {
        Cliente cliente;
        File fichero = new File("clientes.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datalS = new ObjectInputStream(filein);
        try {
            while (true) {
                cliente = (Cliente) datalS.readObject();
                System.out.printf(cliente.toString());
            }
        } catch (IOException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        datalS.close();
    }

    public static void escribirdat() throws IOException {
        Cliente cliente;
        BufferedReader br = new BufferedReader(new FileReader("clientes.csv"));

        String linea = br.readLine();
        String[] comas;
        int i = 0;
        while (linea != null) {
            comas = linea.split(",");
            cliente = new Cliente();
            cliente.setNombre(comas[0]);
            cliente.setEdad(Integer.parseInt(comas[1]));
            cliente.setCiudad(comas[2]);
            cliente.setDescuento(Double.parseDouble(comas[3]));
            clientes.add(cliente);
            linea = br.readLine();
        }
        br.close();

        File fichero = new File("clientes.dat");
        ObjectOutputStream dataOS;
        if (!fichero.exists()) {
            FileOutputStream fileout = new FileOutputStream(fichero);
            dataOS = new ObjectOutputStream(fileout);
        } else {
            dataOS = new MiObjectOutputStream(new FileOutputStream(fichero, true));
        }
        for (int j = 0; j < clientes.size(); j++) {
            dataOS.writeObject(clientes.get(j));
        }
        dataOS.close();
    }

}
