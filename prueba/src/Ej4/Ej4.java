package Ej4;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ej4 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		SAXParserFactory sx = SAXParserFactory.newInstance();
		SAXParser sp = sx.newSAXParser();
		UserHandler hl = new UserHandler();
		sp.parse("calendario.xml", hl);

	}
}

class UserHandler extends DefaultHandler {

	boolean bmes = false;
	boolean bsemana = false;
	boolean bdia = false;
	String d;
	String m;

	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		if (qName.equalsIgnoreCase("calendario")) {
		} else if (qName.equalsIgnoreCase("semana")) {
			bsemana = true;
		} else if (qName.equalsIgnoreCase("dia")) {
			bdia = true;
			d = attributes.getValue("id");
		} else if (qName.equalsIgnoreCase("mes")) {
			bmes = true;
			m = attributes.getValue("id");
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("mes")) {

		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (bmes) {
			System.out.println("Mes " + m + ":" + new String(ch, start, length));
			bmes = false;
		} else if (bsemana) {
			System.out.println("Semana: " + new String(ch, start, length));
			bsemana = false;
		} else if (bdia) {
			System.out.println("	Dia " + d + ":" + new String(ch, start, length));
			bdia = false;
		}

	}
}
