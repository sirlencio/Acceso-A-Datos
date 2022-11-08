import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ejercicio3 {

    //Escribe un programa para obtener una representación de la información anterior en formato JSON.

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml");
        InputStream is = url.openStream();
        int read = 0;
        StringBuilder builder = new StringBuilder();
        while ((read = is.read()) != -1){
            builder.append((char)read);
        }
        String xml = builder.toString();
        JSONObject json = XML.toJSONObject(xml);
        String out = json.toString(4);
        System.out.println(out);
    }
}
