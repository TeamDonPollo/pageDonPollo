package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Compra;
import util.MySQLConexion;

public class DaoPedido {

    public String GrabarPedido(String codCliente, String distrito, List<Compra> lista) {
        String fac = "";
        double total = 0;
        Connection cn = null;
        try {

            for (Compra cp : lista) {
                total += cp.Total();
            }

            cn = MySQLConexion.getConexion();
            String sql = "{call SP_GenerarPedido(?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, codCliente);
            st.setString(2, distrito);
            st.setDouble(3, total);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                fac = rs.getString(1);
            }

            String sql2 = "{call SP_Generar_DetallePedido(?,?,?,?)}";
            CallableStatement st2 = cn.prepareCall(sql2);
            for (Compra p : lista) {
                st2.setInt(1, p.getCantidad());
                st2.setString(2, fac);
                st2.setString(3, p.getCodProducto());
                st2.setDouble(4, p.getPrecio());
                st2.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
        return fac;
    }
    
    
    
    
    
      public String GrabarPedido2(List<Compra> lista, String codCliente, String local, 
                                String formaPago,String servicio, String direccion,
                                String referencia, String celular, String receptor) {
        String fac = "";
        double total = 0;
        Connection cn = null;
        try {

            for (Compra cp : lista) {
                total += cp.Total();
            }

            cn = MySQLConexion.getConexion();
            String sql = "{call SP_GenerarPedido2(?,?,?,?,?,?,?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, codCliente);
            st.setString(2, local);
            st.setString(3, formaPago);
            st.setString(4, servicio);
            st.setString(5, direccion);
            st.setString(6, referencia);
            st.setString(7, celular);
            st.setString(8, receptor);
            st.setDouble(9, total);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                fac = rs.getString(1);
            }

            String sql2 = "{call SP_Generar_DetallePedido(?,?,?,?)}";
            CallableStatement st2 = cn.prepareCall(sql2);
            for (Compra p : lista) {
                st2.setInt(1, p.getCantidad());
                st2.setString(2, fac);
                st2.setString(3, p.getCodProducto());
                st2.setDouble(4, p.getPrecio());
                st2.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
        return fac;
    }                                  
                                        
}
