import java.io.*;

public class dieciseis {
    public static void main(String[] args) throws IOException {

        Agenda agenda;

        File fichero = new File("agenda.dat");
        ObjectOutputStream dataOS;
        if(!fichero.exists()){
            FileOutputStream fileout=new FileOutputStream(fichero);
            dataOS = new ObjectOutputStream(fileout);
        }
        else {
            dataOS = new MiObjectOutputStream(new FileOutputStream(fichero,true));
        }

        String nombre [] = {"Analia","Luis Miguel", "Alicia", "Roberto", "Manuel"};
        String apellidos [] = {"Romero", "Martín", "Lozano", "Pérez", "García"};
        int telefono [] = {1,2,3,4,5};

        for (int i=0;i<apellidos.length; i++){
            agenda= new Agenda(nombre [i],apellidos[i],telefono [i]);
            dataOS.writeObject(agenda);
        }
        dataOS.close();
    }
}