import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class cuatro {

    //Escribe un programa que lea las últimas cotizaciones que aparecen en la página
    // http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?ci%20d=SEM23201
    // y las guarde en un HashMap que contenga como clave el nombre de empresa y los datosfecha de hoy,
    // el momento (hh:mm) y el valor de la cotización. Sugerencia hacer lectura con los filtros InputStreamReader y BufferedReader.

    public static void main(String[] args) throws Exception {
        try {
            //se abre la conexiòn
            URL url = new URL("http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?ci%20d=SEM23201");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            //Lectura
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];
            //ACA EMPIEZA MI CONDICIÓN DESDE ACÁ PODES CAMBIAR VOS
            int leido;
            String texto = "";
            while ((leido = br.read(buffer)) > 0) {
                String datos = new String(buffer, 0, leido);
                texto += datos;
            }
            String[] tr = texto.split("<tr");
            String fila = "";
            for (String linea : tr) {
                if (linea.contains("Valor")) {
                    fila = linea;
                }
            }
            String[] td = fila.split("<td");
            String columna = "";
            for (String linea : td) {
                if (linea.contains(",00")) {
                    System.out.println("---> " + linea);
                    int pos1 = 0;
                    int pos2 = 0;
                    String cotizacion = "";
                    for (int i = 0; i < linea.length(); i++) {
                        if (linea.substring(i, i + 1).equals(">")) {
                            pos1 = i;
                        } else if (linea.substring(i, i + 1).equals("<")) {
                            pos2 = i;
                            break;
                        }
                    }
                    System.out.println("---> " + linea.substring(pos1 + 1, pos2));
                }
            }
            //FIN DE LA CONDICION

        } catch (MalformedURLException ex) {
            System.out.println("Tonto");
        } catch (IOException ex) {
            System.out.println("Tonto a");
        }
    }
}

