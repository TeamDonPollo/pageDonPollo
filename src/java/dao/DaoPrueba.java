
package dao;

import util.MySQLConexion;
import java.util.*;
import java.sql.*;
import modelo.PedidoCliente;
import modelo.ClaseProducto;

public class DaoPrueba {
    
    public List<ClaseProducto> busProd(String an){
        List<ClaseProducto> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call sp_productos(?)}";
            CallableStatement st = conn.prepareCall(sql);
            st.setString(1, an);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                ClaseProducto a = new ClaseProducto();
                a.setProdu(rs.getString(1));
                a.setCant(rs.getInt(2));
                a.setPrecio(rs.getDouble(3));
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
    
    public List<PedidoCliente> busDia(String an){
        List<PedidoCliente> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call sp_clientes(?)}";
            CallableStatement st = conn.prepareCall(sql);
            st.setString(1, an);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                PedidoCliente a = new PedidoCliente();
                a.setCliente(rs.getString(1));
                a.setTotal(rs.getDouble(2));
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


