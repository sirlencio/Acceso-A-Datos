import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class ejercicio2 {

    //Crea un programa que mediante SAX obtenga de la página
    // https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml
    // el título de las noticias y la fecha.

    public static void main(String[] args) throws SAXException, IOException {

        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml");
        procesadorXML.parse(fileXML);
    }
}
class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }
    boolean tit = false, fecha = false, item = false;

    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        if (nombre.equals("item")){
            item = true;
        }
        if (nombre.equals("title") && item){
            tit = true;
        }
        if (nombre.equals("pubDate") && item) {
            fecha = true;
        }
    }

    public void characters(char[] ch, int inicio, int longitud) {
        if (tit){
            String car = new String(ch, inicio, longitud);
            System.out.println(car);
            tit = false;
        }
        if (fecha){
            String car = new String(ch, inicio, longitud);
            System.out.println(car + "\n");
            fecha = false;
        }
    }

    public void endElement(String uri, String nombre, String nombreC) {
        if (nombre.equals("item")){
            item = false;
        }
    }
}
