package Ejercicio_3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ejercicio3 {
    private static Connection conexion = null;

    public static void main(String[] args) {
        //a) Apertura y cierre de conexión
        connect();

        //b) Leer fichero xml y almacenar datos en BD. (el número de la clave primaria se obtendrá
        //   a partir del último almacenado de forma consecutiva.
        almacenarXML();

        //c) Mostrar todos los libros de la biblioteca.
        mostrarLibros();

        //d) Mostrar los libros publicados en un determinado año que se pasa como parámetro.
        filtrarAnio(1973);

        disconnect();
    }

    public static void connect() {
        try {
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "unidad2", "");
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e);
        }
    }

    public static void disconnect() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión con la base de datos: " + e);
        }
    }

    public static void almacenarXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("biblioteca.xml"));
            document.getDocumentElement().normalize();

            //crea una lista con todos los nodos libros
            NodeList libros = document.getElementsByTagName("libro");
            int numero = 0;
            //recorrer la lista
            for (int i = 0; i < libros.getLength(); i++) {
                Node libro = libros.item(i); //obtener un nodo libro
                if (libro.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    //obtener los elementos del nodo
                    Element elemento = (Element) libro;
                    try {
                        String sql = "select max(NUMERO) from biblioteca";
                        PreparedStatement id = conexion.prepareStatement(sql);
                        ResultSet resul = id.executeQuery();
                        if (resul.next()) {
                            numero = resul.getInt(1);
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al select: " + e);
                    }
                    String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();

                    String autor = elemento.getElementsByTagName("autor").item(0).getTextContent();

                    String fechanac;
                    if (elemento.getElementsByTagName("autor").item(0).hasAttributes()) {
                        fechanac = elemento.getElementsByTagName("autor").item(0).getAttributes().getNamedItem("fechaNacimiento").getNodeValue();
                    } else {
                        fechanac = null;
                    }
                    String fechapub = elemento.getElementsByTagName("fechaPublicacion").item(0).getTextContent();

                    try {
                        numero += 1;
                        String query = "Insert into biblioteca (numero, titulo, autor, fnac, fechapub) values (?, ?, ?, ?, ?)";
                        PreparedStatement insertar = conexion.prepareStatement(query);
                        insertar.setInt(1, numero);
                        insertar.setString(2, titulo);
                        insertar.setString(3, autor);
                        if (fechanac == null) {
                            insertar.setDate(4, null);
                        } else {
                            insertar.setDate(4, java.sql.Date.valueOf(LocalDate.parse(fechanac, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                        }
                        insertar.setInt(5, Integer.parseInt(fechapub));
                        insertar.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("Error al insertar el libro: " + e);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarLibros() {
        try {
            String sql = "select * from biblioteca";
            PreparedStatement select = conexion.prepareStatement(sql);
            ResultSet resul = select.executeQuery();
            while (resul.next()) {
                System.out.println("Numero: " + resul.getInt(1));
                System.out.println("Titulo: " + resul.getString(2));
                System.out.println("Autor: " + resul.getString(3) + " , Fecha Nacimiento: " + resul.getDate(4));
                System.out.println("Fecha publicacion: " + resul.getInt(5));
            }
        } catch (SQLException e) {
            System.err.println("Error al select: " + e);
        }
    }

    public static void filtrarAnio(int intro) {
        System.out.println("====Libros publicados en el año " + intro + "====");
        try {
            String sql = "select * from biblioteca where FECHAPUB = " + intro;
            PreparedStatement select = conexion.prepareStatement(sql);
            ResultSet resul = select.executeQuery();
            while (resul.next()) {
                System.out.println("Numero: " + resul.getInt(1));
                System.out.println("Titulo: " + resul.getString(2));
                System.out.println("Autor: " + resul.getString(3) + " , Fecha Nacimiento: " + resul.getDate(4));
                System.out.println("Fecha publicacion: " + resul.getInt(5));
            }
        } catch (SQLException e) {
            System.err.println("Error al select: " + e);
        }
    }
}