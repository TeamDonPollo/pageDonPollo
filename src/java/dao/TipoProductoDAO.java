package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import modelo.TipoProducto;
import util.MySQLConexion;

public class TipoProductoDAO {

    public List<TipoProducto> ListaTipoProductos() {
        List<TipoProducto> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from tipo_producto";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TipoProducto a = new TipoProducto();
                a.setCodTipo(rs.getString(1));
                a.setNomTipo(rs.getString(2));
                a.setImagenTipoProd(rs.getString(3));
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

    public List<Producto> ListaProductos(String code) {
        List<Producto> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from producto where codtip = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodProducto(rs.getString(1));
                p.setProducto(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCodTipo(rs.getString(6));
                p.setDescuento(rs.getDouble(7));
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
}
