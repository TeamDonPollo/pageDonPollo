

package dao;

import java.sql.*;
import java.util.*;
import util.MySQLConexion;
import modelo2.*;


public class Negocio2 {
    public List<Producto> lisProd(String cod) {
        List<Producto> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from producto where codtip=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto a = new Producto();
                a.setIdprod(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setDescrip(rs.getString(3));
                a.setPrecio(rs.getDouble(4));
                a.setStock(rs.getInt(5));
                a.setCodtip(rs.getString(6));
                a.setDscto(rs.getInt(7));
                lis.add(a);
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
