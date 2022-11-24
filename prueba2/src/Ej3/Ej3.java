package Ej3;

import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			 
		    TransformerFactory tFactory = TransformerFactory.newInstance();
		 
		    Transformer transformer =
		      tFactory.newTransformer
		         (new javax.xml.transform.stream.StreamSource
		            ("calendario.xsl"));
		 
		    transformer.transform
		      (new javax.xml.transform.stream.StreamSource
		            ("calendario.xml"),
		       new javax.xml.transform.stream.StreamResult
		            ( new FileOutputStream("calendario.html")));
		    }
		  catch (Exception e) {
		    e.printStackTrace( );
		    }
	}

}
