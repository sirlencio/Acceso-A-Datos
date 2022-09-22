import java.io.FileWriter;
import java.io.IOException;

public class tres {
    //Realiza un programa que escriba los primeros 20 números primos en un fichero
    //de nombre numprimos.txt. Después visualiza el contenido del archivo. Se creará el
    //método EsPrimo().
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("C:\\Users\\manana\\Downloads\\casa.txt");
        int cont = 0;
        int num = 0;
        do {
            if(EsPrimo(num)){
                file.write(String.valueOf(num) + " ");
                cont++;
            }
            num++;
        }while(cont!=20);
        file.close();
    }

    public static boolean EsPrimo(int n) {
        if (n == 0 || n == 1 || n == 4){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
