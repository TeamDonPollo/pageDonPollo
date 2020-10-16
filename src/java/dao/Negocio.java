package dao;

import modelo.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class Negocio {
//crear los metodos para listar los registros

    public List<Especial> lisEsp() {
        List<Especial> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select idesp,  nomesp from especialidad";
            PreparedStatement st = conn.prepareStatement(sql);
//st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Especial a = new Especial();
                a.setCode(rs.getString(1));
                a.setNomesp(rs.getString(2));
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
    //listado de alumnos

    public List<Alumno> lisAlu(String id) {
        List<Alumno> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select idalumno, apealumno, nomalumno from alumno\n" +
                "where idesp=?";
            //? =equivale a un parametro 
            PreparedStatement st = conn.prepareStatement(sql);
            //relacionar el ? con su variable 
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
               Alumno a = new Alumno();
                a.setCoda(rs.getString(1));
                a.setApe(rs.getString(2));
                a.setNoma(rs.getString(3));
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
    //listado de pagos

    public List<Pagos> lisPago(String id) {
 List<Pagos> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select ciclo,ncuota, monto, fecha from pagos\n" +
            "where idalumno=?";
            //? =equivale a un parametro 
            PreparedStatement st = conn.prepareStatement(sql);
            //relacionar el ? con su variable 
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
              Pagos a = new Pagos();
                a.setCiclo(rs.getString(1));
                a.setNcuota(rs.getInt(2));
                a.setMonto(rs.getDouble(3));
                a.setFecha(rs.getString(4));
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
    //lista de notas

    public List<Notas> lisNota(String id) {
List<Notas> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select c.idcurso,nomcurso,exaparcial,exafinal\n" +
            "from curso c inner join notas n \n" +
            "on c.idcurso=n.idcurso where idalumno=?";
            //? =equivale a un parametro 
            PreparedStatement st = conn.prepareStatement(sql);
            //relacionar el ? con su variable 
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
              Notas a = new Notas();
                a.setCodc(rs.getString(1));
                a.setNomcur(rs.getString(2));
                a.setExp(rs.getInt(3));
                a.setExf(rs.getInt(4));
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
