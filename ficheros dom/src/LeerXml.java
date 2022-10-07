import java.io.File;
import javax.xml.parsers.*;

import org.w3c.dom.*;

public class LeerXml {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("productos.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos empleado
            NodeList productos = document.getElementsByTagName("producto");
            System.out.printf("Nodos producto a recorrer: %d %n", productos.getLength());

            //recorrer la lista
            for (int i = 0; i < productos.getLength(); i++) {
                Node prod = productos.item(i); //obtener un nodo producto
                if (prod.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    //obtener los elementos del nodo
                    Element elemento = (Element) prod;
                    System.out.printf("ID = %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
                    System.out.printf(" * Descripcion = %s %n", elemento.getElementsByTagName("descripcion").item(0).getTextContent());
                    System.out.printf(" * Unidades = %s %n", elemento.getElementsByTagName("unidades").item(0).getTextContent());
                    System.out.printf(" * Precio = %s %n", elemento.getElementsByTagName("precio").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

