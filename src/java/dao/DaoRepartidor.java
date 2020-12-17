
package dao;

import java.io.InputStream;
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
            sql = "select p.idp,p.receptor,p.fecha,p.total,p.direccion, p.referencia, p.celular,p.estado from pedido as p inner join horarios h on p.nomd=h.nomd where h.codrep=? and p.estado='Pendiente'";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pedido a = new Pedido();
                a.setIdPedido(rs.getString(1));
                a.setRecp(rs.getString(2));
                a.setFecha(rs.getString(3));
                a.setTotal(rs.getDouble(4));
                a.setDistrito(rs.getString(5));
                a.setRef(rs.getString(6));
                a.setCel(rs.getString(7));
                a.setEstado(rs.getString(8));
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
      
      public List<Pedido> lisHistorialPed(String cod) {
        List<Pedido> lis = new ArrayList<>();
        Connection conn = null; String sql="";

        try {
            conn = MySQLConexion.getConexion();
            sql = "select p.idp,p.receptor,p.fecha,p.total,p.direccion, p.referencia, p.celular,p.estado from pedido as p inner join horarios h on p.nomd=h.nomd where h.codrep=? and p.estado=? or p.estado=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            st.setString(2, "Efectuado"); st.setString(3, "Cancelado");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pedido a = new Pedido();
                a.setIdPedido(rs.getString(1));
                a.setRecp(rs.getString(2));
                a.setFecha(rs.getString(3));
                a.setTotal(rs.getDouble(4));
                a.setDistrito(rs.getString(5));
                a.setRef(rs.getString(6));
                a.setCel(rs.getString(7));
                a.setEstado(rs.getString(8));
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
      
           public int actualizarEstado(String estado, String id){
	int resp=0;
    Connection conn= null;
	 try{
             String sql="";
              conn=MySQLConexion.getConexion();
           
              sql="Update pedido set estado=? where idp=?";   
              PreparedStatement st = conn.prepareStatement(sql);
             
             st.setString(1, estado);
             st.setString(2, id);
           
             resp = st.executeUpdate();
         
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

	return resp;	
	}
}
