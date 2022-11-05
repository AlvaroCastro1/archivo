
package nio;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;


public class OperacionesArchivo {
    String direccion, mensaje;
    public void crearDirectorio(String d){
        Path path= Paths.get(d);
        try{
            if(!Files.exists(path)){
                Files.createDirectory(path);
                JOptionPane.showMessageDialog(null,"Directorio Creado");
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe el directorio");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void crearArchivo(String d){
        Path path= Paths.get(d);
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
                JOptionPane.showMessageDialog(null,"Documento creado");
            }else{
                  JOptionPane.showMessageDialog(null,"El documento ya existe");
            }
        }catch(Exception e){
            
        }
    }
    public void escribirArchivo(String d, String m){
        Path path= Paths.get(d);
         try{
            if(!Files.exists(path)){
                
                JOptionPane.showMessageDialog(null,"El documento no existe");
            }else{
                Files.write(path, m.getBytes(), StandardOpenOption.APPEND);
                JOptionPane.showMessageDialog(null,"El documento se guardo con exito");
            }
        }catch(Exception e){
            
        }
    }
    public String leerArchivo(String d,String n){
          Path path= Paths.get(d);
         try{
            if(!Files.exists(path)){
                
                JOptionPane.showMessageDialog(null,"El documento no existe");
            }else{
                return Files.readString(path);
               
            }
        }catch(Exception e){
            
        }
        return null;
        
    }
    
}
