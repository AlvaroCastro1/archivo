package Serializable;
import java.io.*;

public class Box implements Serializable{   //interfaz aun que no hay metodos
    private int width;
    private int height;

    public void setWidth(int w){
	       width= w;
    }

    public void setHeight(int h){
	       height= h;
    }

    public String toString(){
        String cad = "\nCaja: " + width + " , " + height ;
        return cad;
    }

    public static void main (String [] args){
        //se crea un objeto y se le dan sus atributos
        Box myBox = new Box();
        myBox.setWidth(50);
	    myBox.setHeight(20);

        Box caja2 = new Box();
        caja2.setWidth(40);
        caja2.setHeight(60);

        Box caja3 = new Box();
        caja3.setWidth(800);
        caja3.setHeight(900);

        try( FileOutputStream fs = new FileOutputStream("archivito.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs) ){

            os.writeObject(myBox);
            os.writeObject(caja2);
            os.writeObject(caja3);

            //os.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        try( FileInputStream fi = new FileInputStream("archivito.ser");
            ObjectInputStream oi = new ObjectInputStream(fi) ){
                Box obj1 = (Box) oi.readObject();
                Box obj2 = (Box) oi.readObject();
                Box obj3 = (Box) oi.readObject();
                System.out.println( obj3 );
        }catch( Exception ex){
            System.out.println("Error en Deserialización ");
            ex.printStackTrace();
        }
    }
}
