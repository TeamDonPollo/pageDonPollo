
package util;
import dao.*;import modelo2.*;import java.util.*;
public class prueba1 {

    public static void main(String[] args) {
        MySQLConexion.getConexion();
        Negocio2 n=new Negocio2();
        List<Producto> lis=(ArrayList<Producto>)n.lisProd("T001");
        for(Producto x:lis){
            System.out.println("COD: "+x.getNom());
        }
    }
    
}
