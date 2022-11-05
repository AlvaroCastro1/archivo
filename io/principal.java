package io;
import java.io.*;

public class principal {

    public String leer(String ruta) throws IOException {
        File file = new File(ruta);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String cad ="";
        while ((st = br.readLine()) != null) {
            cad += ""+st;
        }
        return cad;
    }

    public void modificar(String ruta, String nuevoS) throws IOException {
        File archivo = new File(ruta);

        FileWriter escribir = new FileWriter(archivo);
        for(int i=0; i<nuevoS.length();i++){
            escribir.write(nuevoS.charAt(i));
        }
        escribir.close();
    }
}
