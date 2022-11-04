import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ejercicio1 {

    //Escribe un programa con la ayuda de DOM para que a partir del fichero peliculas.xml,
    // se muestre correctamente: el título de la película, año, director y
    // los nombres de los actores principales.

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("peliculas.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos empleado
            NodeList peliculas = document.getElementsByTagName("Pelicula");
            System.out.printf("Nodos pelicula a recorrer: %d %n", peliculas.getLength());

            //recorrer la lista
            for (int i = 0; i < peliculas.getLength(); i++) {
                Node prod = peliculas.item(i); //obtener un nodo producto
                if (prod.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    //obtener los elementos del nodo
                    Element elemento = (Element) prod;
                    System.out.printf("Titulo: %s %n", elemento.getElementsByTagName("Titulo").item(0).getTextContent());
                    System.out.printf(" * Fecha: %s %n", elemento.getElementsByTagName("Fecha").item(0).getTextContent());
                    System.out.printf(" * Director: %s %n", elemento.getElementsByTagName("Director").item(0).getTextContent());
                    System.out.printf(" * Actores: %s %n", elemento.getElementsByTagName("Actores").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}