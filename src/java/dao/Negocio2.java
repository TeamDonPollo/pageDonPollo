

package dao;

import java.sql.*;
import java.text.DecimalFormat;
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
                a.setFoto(rs.getBinaryStream(8));
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
    
    public TipoProducto busTip(String cod) {
        TipoProducto tp= null ;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from tipo_producto where codtip=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                tp = new TipoProducto();
                tp.setCodTipo(rs.getString(1));
                tp.setNomTipo(rs.getString(2));
                tp.setImagenTipoProd(rs.getString(3));
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

        return tp;

    }
    
     public Producto busProd(String cod) {
        Producto p= null ;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from producto where idpt=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setIdprod(rs.getString(1));
                p.setNom(rs.getString(2));
                p.setDescrip(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCodtip(rs.getString(6));
                p.setDscto(rs.getInt(7));
                p.setFoto(rs.getBinaryStream(8));
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

        return p;

    }
    
    public List<Producto> lisTProd() {
        List<Producto> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from producto";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto a = new Producto();
                a.setIdprod(rs.getString(1));
                a.setNom(rs.getString(2));
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
    
     public String generaCod() {
        String cod;
        if (lisTProd().size() == 0) {
            cod = "P0001";
        } else {
            int fin = lisTProd().size() - 1;
            cod = lisTProd().get(fin).getIdprod();
            int nro = Integer.parseInt(cod.substring(1)) + 1;
            DecimalFormat sd = new DecimalFormat("0000");
            cod = "P" + sd.format(nro);
        }
        return cod;
    }
     
     public int Modifica(Producto a){
	int resp=0;
    Connection conn= null;
	 try{
    String sql="Update producto set nom=?,descripcion=?,precio=?,stock=?,descuento=? where idpt=?";
          
    conn=MySQLConexion.getConexion();

  PreparedStatement st=conn.prepareStatement(sql);

	st.setString(6, a.getIdprod());
        st.setString(1,a.getNom());
        st.setString(2,a.getDescrip());
        st.setDouble(3, a.getPrecio());
        st.setInt(4, a.getStock());
        st.setInt(5, a.getDscto());
        //st.setBlob(6, a.getFoto());
     
        resp=	st.executeUpdate();
	
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

	return resp;	
	}
    
      public void addProd(Producto a){
	
    Connection conn= null;
	 try{
    String sql="insert into producto (idpt,nom,descripcion,precio,stock,descuento,imagen)"+
          " values(?,?,?,?,?,?,?)";
    conn=MySQLConexion.getConexion();

  PreparedStatement st=conn.prepareStatement(sql);

	st.setString(1, generaCod());
        st.setString(2,a.getNom());
        st.setString(3,a.getDescrip());
        st.setDouble(4, a.getPrecio());
        st.setInt(5, a.getStock());
        st.setInt(6, a.getDscto());
        st.setBlob(7, a.getFoto());
     
       st.executeUpdate();
	
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

	
	}
      
      public void Anula(String id) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from producto where idpt=?";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,id);
             resp = st.executeUpdate();
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
