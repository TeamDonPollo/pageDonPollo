

package dao;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.servlet.http.*;
import util.MySQLConexion;
import modelo2.*;


public class DaoProducto {
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
             String sql="";
              conn=MySQLConexion.getConexion();
             if(InputStream.class.getClass().getResourceAsStream(a.getFoto().toString())   != null ){
              sql="Update producto set nom=?,descripcion=?,precio=?,stock=?,descuento=?,imagen=? where idpt=?";   
              PreparedStatement st = conn.prepareStatement(sql);
             st.setString(7, a.getIdprod());
             st.setString(1, a.getNom());
             st.setString(2, a.getDescrip());
             st.setDouble(3, a.getPrecio());
             st.setInt(4, a.getStock());
             st.setInt(5, a.getDscto());
             st.setBlob(6, a.getFoto());
             resp = st.executeUpdate();
             }else{
                sql="Update producto set nom=?,descripcion=?,precio=?,stock=?,descuento=? where idpt=?";   
              PreparedStatement st = conn.prepareStatement(sql);
             st.setString(6, a.getIdprod());
             st.setString(1, a.getNom());
             st.setString(2, a.getDescrip());
             st.setDouble(3, a.getPrecio());
             st.setInt(4, a.getStock());
             st.setInt(5, a.getDscto());
             resp = st.executeUpdate(); 
             }
    
          	
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
    String sql="Insert into producto (idpt,nom,descripcion,precio,stock,codtip,descuento,imagen) values(?,?,?,?,?,?,?,?)";
    conn=MySQLConexion.getConexion();

  PreparedStatement st=conn.prepareStatement(sql);

	st.setString(1, a.getIdprod());
        st.setString(2,a.getNom());
        st.setString(3,a.getDescrip());
        st.setDouble(4, a.getPrecio());
        st.setInt(5, a.getStock());
        st.setString(6,a.getCodtip());
        st.setInt(7, a.getDscto());
        st.setBlob(8, a.getFoto());
     
       st.executeUpdate();
	
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

	
	}
      
      public void delProd(String id) {
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
      
      public void listarImg(String id, HttpServletResponse response){
          Connection conn = null; ResultSet rs=null;
          String sql="select * from producto where idpt="+id;
          InputStream inputStream=null;
          OutputStream outputStream=null;
          BufferedInputStream bfInputSt=null;
          BufferedOutputStream bfOutSt=null;
          response.setContentType("image/*");
          try{
              outputStream=response.getOutputStream();
              conn = MySQLConexion.getConexion();
              
              PreparedStatement st = conn.prepareStatement(sql);
              
              rs=st.executeQuery();
              if(rs.next()){
                  inputStream=rs.getBinaryStream("imagen");
              }
              bfInputSt=new BufferedInputStream(inputStream);
              bfOutSt=new BufferedOutputStream(outputStream);
              int i=0;
              while((i=bfInputSt.read())!=-1){
                  bfOutSt.write(i);
              }
          }catch (Exception ex) {
              
          }
      }
      
      
}
