package Ej1;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej1 {
	
	//Longitud de caracteres 4+30+8=42
	public static void buscarfichero(RandomAccessFile ra) {
		Scanner e = new Scanner(System.in);
		System.out.println("Id del curso a buscar:");
		int id = e.nextInt();
		long cod=0;
		cod =(id-1)*42; 
		try {
			ra.seek(cod);
			
			int i=ra.readInt();
			if (i==id) {
				System.out.println("-Curso: ");
				System.out.println("	Numero: "+i);
				String nombre="";
				for (int j=0; j<15; j++) {
					nombre+=ra.readChar();
				}
				System.out.println("	Nombre: "+nombre);
				System.out.println("	Precio: "+ra.readDouble());
			} else {
				System.out.println("No se ha encontrado el curso.");
			}
			
		} catch(Exception e1) {
			
		}
	}
	
	public static void verfichero(RandomAccessFile ra) throws IOException {
		try {
			ra.seek(0);
			while (true) {
				System.out.println("-Curso: \n	Numero: "+ra.readInt());
				String nombre="";
				for (int i=0; i<15; i++) {
					nombre+=ra.readChar();
				}
				System.out.println("	Nombre: "+nombre);
				System.out.println("	Precio: "+ra.readDouble());
			}
		} catch (EOFException e) {
			
		}
	}
	
	public static void nuevocurso(RandomAccessFile ra) throws IOException {  //Metodo para a�adir nuevo curso
		Scanner e = new Scanner(System.in);
		int id;
		String nombre;
		double precio;
		ra.seek(ra.length());
		System.out.println("Introduzca el id del curso:");
		id =e.nextInt();
		ra.writeInt(id);
		System.out.println("Introduzca el nombre del curso:");
		nombre =e.next();
		StringBuffer b= new StringBuffer(nombre); 
		b.setLength(15);
		ra.writeChars(b.toString());
		System.out.println("Introduzca el precio del curso:");
		precio =e.nextDouble();
		ra.writeDouble(precio);
	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner e = new Scanner(System.in);
		File archivo = new File("curso.dat");
		RandomAccessFile file = new RandomAccessFile(archivo, "rw");
		int op=1;
		do {
			System.out.println("---Menu---");
			System.out.println("1.- Introducir curso");
			System.out.println("2.- Leer fichero");
			System.out.println("3.- Buscar curso");
			op=e.nextInt();
			switch(op) {
			case 0: 
				System.out.println("Hasta luego");
				break;
			case 1: 
				try {
					nuevocurso(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2: 
				try {
					verfichero(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				buscarfichero(file);
				break;
			}
		} while (op!=0);
	}

}
