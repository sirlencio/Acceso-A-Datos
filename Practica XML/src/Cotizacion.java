import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Cotizacion implements Serializable{
    private static final long serialVersionUID = 1L;
    String nombre;
    String fecha;
    String hora;
    String valor;

    public Cotizacion(String nombre, String fecha, String hora, String valor) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }
    public Cotizacion(){

    }

    @Override
    public String toString() {
        return
                 nombre + ":\n\t" +
                "fecha='" + fecha + '\'' +
                " - hora='" + hora + '\'' +
                " - valor='" + valor + '\'';
    }
    private static HashMap<String, String> cotizaciones = new HashMap<String, String>();
    public static void GrabarCotizacion() throws IOException {
        try {
            URL url = new URL("https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            InputStream is = conexion.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];

            String leido;
            String texto = "";
            boolean read = false;
            while ((leido = br.readLine()) != null) {
                texto+=leido;
                texto+=System.lineSeparator();
            }
            String [] rows = getRow(texto);
            rellenaHash( rows);
            //recorro el HashMap, creando objetos Cotización y escribiendo cada uno en el fichero
            for(String key : cotizaciones.keySet()) {
                String[]values = cotizaciones.get(key).split("-");
                Cotizacion c = new Cotizacion(key, values[0], values[1], values[2]);
                escribeFichero(c);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    private static String[] rellenaHash(String[] rows) {
        for(String s: rows){
            String[] lineas = s.split("td");
            try{
                //obtengo de forma limpia el nombre

                String nombre = lineas[1].substring(lineas[1].indexOf("title")+7);
                nombre = nombre.substring(0, nombre.indexOf("\""));

                //obtengo la fecha de hoy con un formato específico
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                String fecha = dtf.format(now);

                //obtengo tanto el valor de cotización como la hora de esta misma.
                String valor = lineas[3].replaceAll(".*\\>|\\<.*", "");
                String hora = lineas[19].replaceAll(".*\\>|\\<.*", "");

                cotizaciones.put(nombre, fecha+"-"+hora+"-"+valor);
            }catch(Exception e){// por tema de html había rows que estaban vacías, al intentar acceder a un idex de la mismada error y no introduce nada en el HashMap

            }
        }
        return null;
    }

    private static String[] getRow(String texto) {
        String []tablas =texto.split("tbody");
        for(String t:tablas){
            if(t.contains("/mercados/cotizaciones/valores/acciona_M.ANA.html"))
                return t.split("tr");
        }
        return null;
    }
    //escribe el objeto Cotización que se le pase en el fichero
    private static void escribeFichero(Cotizacion c) throws IOException {
        File f = new File("cotizaciones.dat");
        ObjectOutputStream oos;
        if(!f.exists()){
            FileOutputStream fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }else {
            oos = new MiObjectOutputStream(new FileOutputStream(f,true));
        }
        oos.writeObject(c);
        oos.close();
    }
    public static void LeerCotizacion() throws IOException {
        File f = new File("cotizaciones.dat");
        if(!f.exists()){
            System.err.println("Fichero no encontrado");
            return;
        }
        FileInputStream fis = new FileInputStream(f);//conecta el flujo de bytes al flujo de datos
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
        while (true) { //lectura del fichero
            Cotizacion c= (Cotizacion) ois.readObject();
            System.out.println(c.toString());}
        }catch (EOFException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        ois.close();
    }
    public static void VerCotizacion(String fecha, String hora) throws IOException {
        //creo un arrayList donde guardo los objetos que coincidan con fecha y hora
        ArrayList<Cotizacion> array = new ArrayList<Cotizacion>();
        File f = new File("cotizaciones.dat");
        if(!f.exists()){
            System.err.println("Fichero no encontrado");
            return;
        }
        FileInputStream fis = new FileInputStream(f);//conecta el flujo de bytes al flujo de datos
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (true) { //lectura del fichero
                Cotizacion c= (Cotizacion) ois.readObject();
                if(c.fecha.equals(fecha) && c.hora.equals(hora)){
                    array.add(c);
                }
            }
        }catch (ClassNotFoundException | IOException eo) {
            //finaliza lectura
        }
        ois.close();
        //ahora leo dicho array y lo muestro por salida estándar
        for (Cotizacion ct : array){
            System.out.println(ct.toString());
        }
        if (array.size() == 0) System.out.println("No hay elementos con esos datos. ");
    }
}
