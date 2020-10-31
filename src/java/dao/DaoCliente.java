
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo2.Administrador;
import modelo2.Cliente;
import util.MySQLConexion;

public class DaoCliente {
    
    
    //ADICION ALUMNOS
    public void adicionarCliente(Cliente c) {

        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call adicion_cliente(?,?,?,?,?,?,?,?)}";
            CallableStatement st = conn.prepareCall(sql);
            st.setString(1, c.getNombre());
            st.setString(2, c.getApellido());
            st.setString(3, c.getCorreo());
            st.setString(4, c.getPassword());
            st.setString(5, c.getTipoDoc());
            st.setInt(6, Integer.parseInt(c.getNroDoc()));
            st.setString(7, c.getFecha());
            st.setString(8,c.getSexo());
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
    
    //CREAR LOS METODOS PARA LISTAR LOS REGISTROS
    public Cliente buscaCliente(String correo) {

        Cliente c = null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select nom, pswd from cliente where correo=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                c = new Cliente();
                c.setNombre(rs.getString(1));
                c.setPassword(rs.getString(2));
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

        return c;
    }
    
    
    public Administrador buscaAdministrador(String correo) {

        Administrador a = null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select nomad, pswd from administrador where correo=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
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
    
}
