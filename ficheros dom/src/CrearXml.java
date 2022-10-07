import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearXml {

    //Codigo, descripcion, unidades, precio

    public static void main(String[] args) throws IOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "productos", null);
            doc.setXmlVersion("1.0");

            //Lectura documento
            producto pro;
            File fichero = new File("productos.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream datalS = new ObjectInputStream(filein);

            try {
                while (true) {
                    pro = (producto) datalS.readObject();

                    Element raiz = doc.createElement("producto"); // nodo producto
                    doc.getDocumentElement().appendChild(raiz);

                    // ID
                    CrearElemento("id", Integer.toString(pro.getCodigo()), raiz, doc);
                    // Descripcion
                    CrearElemento("descripcion", pro.getDescripcion().trim(), raiz, doc);
                    // Unidades
                    CrearElemento("unidades", Integer.toString(pro.getUnidades()), raiz, doc);
                    // Precio
                    CrearElemento("precio", Double.toString(pro.getPrecio()), raiz, doc);
                }
            } catch (IOException | ClassNotFoundException eo) {
                System.out.println("Archivo XML creado.");
            }

            // Escribimos el xml
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new java.io.File("productos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void CrearElemento(String datoproducto, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoproducto);
        Text text = document.createTextNode(valor); // damos valor
        raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
        elem.appendChild(text); // pegamos el valor
    }
}

