package nio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class prueba {

    public void crear_archivo(String nombre) {
        // Path y Files
        Path ruta = Paths.get(nombre);
        try {
            Files.createFile(ruta);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listar() {
        // directoryStream
        try {
            Path ruta = Paths.get("./io");
            DirectoryStream<Path> i = Files.newDirectoryStream(ruta);
            for (Path path : i) {
                System.out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribir() {
        try {
            Formatter i = new Formatter("creadoN.txt");
            String nombre = "Pepe";
            i.format("Hola, %s esto debe aparecer en el txt", nombre);
            i.flush();
            i.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void leer() {
        //Scanner
        try {
            Scanner lee2 = new Scanner(Paths.get("creadoN.txt"));
            while (lee2.hasNext()) {
                String cad = lee2.nextLine();
                System.out.println(cad);
            }
            lee2.close();
        } catch (Exception ex) {
            System.out.println("Error: Lectura");
        }
    }

    public static void main(String[] args) {
        prueba p = new prueba();
        p.leer();
    }
}
