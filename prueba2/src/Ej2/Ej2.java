package Ej2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ej2 {

	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError {
		// TODO Auto-generated method stub
		int pos=0, id;
		char nombre[] = new char[15];
		char c;
		String nom;
		double precio;
		File origen = new File("curso.dat");
		RandomAccessFile ra = new RandomAccessFile(origen, "r");
		
		DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbF.newDocumentBuilder();
		DOMImplementation imple = db.getDOMImplementation();
		Document doc = imple.createDocument(null, "Cursos", null);
		doc.setXmlVersion("1.0");
		
		for (;;) {
			try {
				ra.seek(pos);
				id=ra.readInt();
				for (int i=0; i<15; i++) {
					c=ra.readChar();
					nombre[i]=c;
				}
				nom=new String(nombre);
				nom = nom.trim();
				precio = ra.readDouble();
				
				//Creamos los elementos raiz
				Element raiz = doc.createElement("Curso");
				doc.getDocumentElement().appendChild(raiz);
				CrearElemento("Numero", Integer.toString(id), raiz, doc);
				CrearElemento("Nombre", nom, raiz, doc);
				CrearElemento("Precio", Double.toString(precio), raiz, doc);
				
				pos +=42;
				if (ra.getFilePointer()==ra.length()) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Source src = new DOMSource(doc);
		Result rs = new StreamResult(new File("curso.xml"));
		Transformer trs = TransformerFactory.newInstance().newTransformer();
		try {
			trs.transform(src, rs);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor); // damos valor
		raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
		elem.appendChild(text); // pegamos el valor
	}

}
