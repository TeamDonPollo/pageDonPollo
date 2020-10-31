package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;
import modelo2.Cliente;
import util.MySQLConexion;

public class DaoConsulta {
    
    public List<Consulta> listaConsultas() {
        List<Consulta> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from consulta;";
            //st.setString(1, cad);
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setIdcon(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setCorreo(rs.getString(3));
                a.setCons(rs.getString(4));
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
    
    
     public void addConsulta(Consulta p) {
        
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call ADICION_CONSULTA( ?, ?, ?)}";
            CallableStatement st = conn.prepareCall(sql);
            st.setString(1, p.getNom());
            st.setString(2, p.getCorreo());
            st.setString(3, p.getCons());
            st.executeUpdate();
            //llenar el arraylist con la clase entidad
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
     
    public void delConsulta(int id) {
        
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "delete from consulta where idcon=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
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
