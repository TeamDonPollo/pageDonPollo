
package dao;

import java.sql.*;
import java.util.*;
import modelo2.*; import modelo.*;
import util.MySQLConexion;

public class DaoRepartidor {
      public Administrador buscaAdministrador(String correo) {

        Administrador a = null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select nomad, pswd from administrador where correo=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = new Administrador();
                a.setNombre(rs.getString(1));
                a.setPassword(rs.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return a;
    }
      
      public List<Pedido> lisPedidosP(String cod) {
        List<Pedido> lis = new ArrayList<>();
        Connection conn = null; String sql="";

        try {
            conn = MySQLConexion.getConexion();
            if(sql.equals("R001")){
                sql = "select * from producto where codtip=?";
            }
            if(sql.equals("R002")){
                sql = "select * from producto where codtip=?";
            }
            if(sql.equals("R002")) {
                sql = "select * from producto where codtip=?";
            }
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pedido a = new Pedido();
               /* a.setIdprod(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setDescrip(rs.getString(3));
                a.setPrecio(rs.getDouble(4));
                a.setStock(rs.getInt(5));
                a.setCodtip(rs.getString(6));
                a.setDscto(rs.getInt(7));
                a.setFoto(rs.getBinaryStream(8));
                lis.add(a);*/
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;

    }
}
