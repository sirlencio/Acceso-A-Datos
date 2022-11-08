import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class ejercicio4 {

    //Escribe un programa para leer los datos de las cotizaciones grabadas mediante serialización
    // en el ejercicio nº 5 de la práctica anterior y grabarlas en un documento cotizaciones.xml
    // con el siguiente formato para cada empresa:
    /*<Empresas>
        <empresa>
            <nombre>nombre</nombre>
            <fecha>fecha</fecha>
            <hora>hora</hora>
            <cotizacion>cotizacion</cotizacion>
        </empresa>
        …
        <Empresas>*/

    public static void main(String[] args) throws IOException, ParserConfigurationException {
        ArrayList<Cotizacion> array = new ArrayList<>();
        try {
            File fichero = new File("cotizaciones.dat");
            ObjectInputStream datalS = new ObjectInputStream(new FileInputStream(fichero));
            try {
                while (true) {
                    Cotizacion objeto = (Cotizacion) datalS.readObject();
                    array.add(objeto);
                }
            } catch (IOException | ClassNotFoundException eo) {
                System.out.println("Fichero leido");
            }
            datalS.close();
        } catch (FileNotFoundException f) {
            System.out.println("Fichero no creado");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document doc = implementation.createDocument(null, "Empresas", null);

        for (int i = 0; i < array.size(); i++) {
            Element raiz = doc.createElement("Empresa");
            doc.getDocumentElement().appendChild(raiz);

            // Nombre
            CrearElemento("nombre", array.get(i).nombre, raiz, doc);
            // Fecha
            CrearElemento("fecha", array.get(i).fecha, raiz, doc);
            // Hora
            CrearElemento("hora", array.get(i).hora, raiz, doc);
            // Cotizacion
            CrearElemento("valor", array.get(i).valor, raiz, doc);
        }

        try (FileOutputStream output = new FileOutputStream("cotizaciones.xml")) {
            writeXml(doc, output);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    static void CrearElemento(String datoproducto, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoproducto);
        Text text = document.createTextNode(valor); // damos valor
        raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
        elem.appendChild(text); // pegamos el valor
    }

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}