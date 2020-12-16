package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Compra;
import modelo.Pedido;
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
      
        public List<Pedido> historialP(String cod) {
        List<Pedido> lis = new ArrayList<>();
        Connection conn = null; String sql="";

        try {
            conn = MySQLConexion.getConexion();
            sql = "select idp,total,fp.nomre,fecha,estado from pedido as p inner join forma_pago as fp on p.idfp=fp.idfp where codc=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getString(1));
                p.setTotal(rs.getDouble(2));
                p.setFormp(rs.getString(3));
                p.setFecha(rs.getString(4));
                p.setEstado(rs.getString(5));
                lis.add(p);
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
        
        public void delPedido(String id) {
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "delete from pedido where idp=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
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
    }
                                        
}
