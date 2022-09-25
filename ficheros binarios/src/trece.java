import java.io.*;

public class trece {
    //Programa que copie una imagen en otro fichero utilizando memoria intermedia.
    public static void main(String[] args) throws IOException {
        FileInputStream filein = new FileInputStream("datos.dat");
        BufferedInputStream buffin = new BufferedInputStream(filein);

        FileOutputStream fileout = new FileOutputStream ("datoscopy.dat") ;
        BufferedOutputStream buffout = new BufferedOutputStream ( fileout );

        byte [] array = new byte[1000];
        int leidos = buffin.read(array);

        while (leidos > 0){
            buffout.write(array,0,leidos);
            leidos = buffin.read(array);
        }
        buffin.close();
        buffout.close();
    }
}
