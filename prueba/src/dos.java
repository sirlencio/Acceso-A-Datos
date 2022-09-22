import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class dos {
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");

        Scanner input = new Scanner(System.in);
        File f = new File(input.nextLine());

        System.out.println("Nombre: " + f.getName());

        Date d = new Date(f.lastModified());
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        String dia, mes, annio, hora, minuto, segundo;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(c.get(Calendar.MINUTE));
        segundo = Integer.toString(c.get(Calendar.SECOND));

        System.out.println("Ultima hora modificado: " + hora + ":" + minuto + ":" + segundo + " " + dia + "/" + mes +"/" + annio);

        if (f.canRead()){
            System.out.println("Se puede leer");
        }else {
            System.out.println("No se puede leer");
        }
        if (f.canWrite()){
            System.out.println("Se puede escribir");
        }else {
            System.out.println("No se puede escribir");
        }

        if (f.isDirectory()){
            System.out.println("Es un directorio");
        }else if (f.isFile()){
            System.out.println("Es un archivo");
            System.out.println("El tamaño del archivo es de: " + f.length() + " bytes");
        }


    }
}
