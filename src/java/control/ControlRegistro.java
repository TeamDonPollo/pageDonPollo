/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo2.Administrador;
import modelo2.Cliente;

public class ControlRegistro extends HttpServlet {

    DaoCliente obj = new DaoCliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("opc");
        if (op.equals("1")) {
            comenzarRegistro(request, response);
        }
        if (op.equals("2")) {
            adicionarCliente(request, response);
        }
        if (op.equals("3")) {
            salirSesion(request, response);
        }
        if (op.equals("4")) {
            entrarSesion(request, response);
        }
    }

    protected void comenzarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        request.setAttribute("password", password);
        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);

        String pag = "/pagRegistro.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

        /*String codc = request.getParameter("cod");
        HttpSession ses = request.getSession();
        ses.setAttribute("datcur" , obj.buscaCurso(codc));
        request.setAttribute("dato", obj.listaAlumno(codc));
        String pag = "/PagAlu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);*/
    }

    protected void adicionarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();
        ses.setAttribute("usuario", request.getParameter("nombre"));

        Cliente c = new Cliente();
        c.setNombre(request.getParameter("nombre"));
        c.setApellido(request.getParameter("apellido"));
        c.setCorreo(request.getParameter("email"));
        c.setPassword(request.getParameter("password"));
        c.setTipoDoc(request.getParameter("doc_tipo"));
        c.setNroDoc(request.getParameter("doc_numero"));
        c.setFecha(request.getParameter("fecha"));
        c.setSexo(request.getParameter("sexo"));
        obj.adicionarCliente(c);

        ses.setAttribute("nombreLogeado", c.getNombre()+" "+c.getApellido());
        ses.setAttribute("idCliente", obj.CodigoMaximoCliente());

        String pag = "/index2.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

        /*
        HttpSession ses = request.getSession();
        Curso cur = (Curso) ses.getAttribute("datcur");
        Alumno a = new Alumno();
        a.setCodigoCurso(cur.getCodigo());
        a.setNombre(request.getParameter("nombre"));
        a.setTipo(request.getParameter("op"));
        a.setPago(Double.parseDouble(request.getParameter("pago")));
        obj.adicionarAlumno(a);
        
        request.setAttribute("dato", obj.listaAlumno(cur.getCodigo()));
        String pag = "/PagAlu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);*/
    }

    protected void salirSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();
        ses.setAttribute("usuario", null);
        ses.setAttribute("idCliente", null);
        String pag = "/index2.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void entrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre;

        HttpSession ses = request.getSession();
        ses.setAttribute("login", "false");
        ses.setAttribute("usuario", null);

        Cliente c = new Cliente();
        c = obj.buscaCliente(request.getParameter("email"));

        if (c == null) {

            Administrador a = new Administrador();
            a = obj.buscaAdministrador(request.getParameter("email"));

            if (a != null) {
                if (a.getPassword().equals((String) request.getParameter("password"))) {
                    nombre = a.getNombre();
                    ses.setAttribute("usuario", nombre);
                    ses.setAttribute("login", null);
                    String pag = "/administrador/cabAdmi2.jsp";
                    request.getRequestDispatcher(pag).forward(request, response);
                }
            }

        } else if (c.getPassword().equals((String) request.getParameter("password"))) {
            nombre = c.getNombre();
            ses.setAttribute("usuario", nombre);
            ses.setAttribute("idCliente", c.getCodigo());
            ses.setAttribute("login", null);
            ses.setAttribute("nombreLogeado", c.getNombre()+" "+c.getApellido());
        }

        String pag = "/index2.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
