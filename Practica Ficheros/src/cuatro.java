import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
public class cuatro {

    //Escribe un programa que lea las últimas cotizaciones que aparecen en la página
    // http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?ci%20d=SEM23201
    // y las guarde en un HashMap que contenga como clave el nombre de empresa y los datosfecha de hoy,
    // el momento (hh:mm) y el valor de la cotización. Sugerencia hacer lectura con los filtros InputStreamReader y BufferedReader.

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?ci%20d=SEM23201");
        URLConnection conexion = url.openConnection();
        HashMap<String, String> datos = new HashMap<>();

        //Guardamos en guardado el html de la pagina
        InputStream is = conexion.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String todo;
        String guardado = null;
        while ((todo = br.readLine()) != null)
            guardado += todo;
        br.close();

        // Localizamos la tabla y la guardamos en un string
        String tabla = guardado.substring(guardado.indexOf("<table id=\"listado_valores"), guardado.indexOf("</table", guardado.indexOf("<table id=\"listado_valores")));
        String[] tr = tabla.split("<tr>"); //Separamos la tabla en filas
        String[] td;

        String key = "", value = "";
        for (int i = 2; i < tr.length; i++) {
            //System.out.println("Fila " + i + " " + tr[i]);
            td = tr[i].split("<td([^>]*)>"); // Separamos cada fila en columnas
            for (int j = 1; j < td.length; j++) {
                //System.out.println("Columna " + j + " "+ td[j]);
                key = td[1].substring(td[1].indexOf(">") + 1, td[1].indexOf("<", td[1].indexOf(">"))); //Guardamos el nombre de la empresa
                //System.out.println(key);
                String hora = "Hora: " + td[10].substring(0, td[10].indexOf("<")); //Guardamos la hora de la empresa
                String valor = "Valor: " + td[2].substring(0, td[2].indexOf("<")); //Guardamos el valor de la empresa
                value = valor + "\n" + hora;
                //System.out.println(value);
            }
            datos.put(key, value);
        }
        for (String i : datos.keySet()) {
            System.out.println("Nombre: " + i + "\n" + datos.get(i)); //Mostramos el hashmap
        }
    }
}

