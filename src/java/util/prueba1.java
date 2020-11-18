package util;

import dao.*;
import modelo2.*;
import java.util.*;

public class prueba1 {

    public static void main(String[] args) {
        MySQLConexion.getConexion();
        DaoProducto n = new DaoProducto();
        List<Producto> lis = (ArrayList<Producto>) n.lisProd("T001");
        for (Producto x : lis) {
            System.out.println("COD: " + x.getNom());
        }

    }

}
