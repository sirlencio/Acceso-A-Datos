import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CrearXml {

    //Codigo, descripcion, unidades, precio

    public static void main(String[] args) throws IOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "clientes", null);
            doc.setXmlVersion("1.0");

            //Lectura documento
            Cliente cliente;
            File fichero = new File("clientes.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream datalS = new ObjectInputStream(filein);

            try {
                while (true) {
                    cliente = (Cliente) datalS.readObject();

                    Element raiz = doc.createElement("cliente"); // nodo producto
                    doc.getDocumentElement().appendChild(raiz);

                    // ID
                    CrearElemento("nombre", cliente.getNombre(), raiz, doc);
                    // Descripcion
                    CrearElemento("edad", Integer.toString(cliente.getEdad()), raiz, doc);
                    // Unidades
                    CrearElemento("ciudad", cliente.getCiudad(), raiz, doc);
                    // Precio
                    CrearElemento("descuento", Double.toString(cliente.getDescuento()), raiz, doc);
                }
            } catch (IOException | ClassNotFoundException eo) {
                System.out.println("Archivo XML creado.");
            }

            // Escribimos el xml
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File("clientes.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void CrearElemento(String datocliente, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datocliente);
        Text text = document.createTextNode(valor); // damos valor
        raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
        elem.appendChild(text); // pegamos el valor
    }
}

