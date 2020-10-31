
package control;

import dao.DaoConsulta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Consulta;

public class ControlConsulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("opc").equals("1")) {
            listaConsultas(request, response);
        }
        if (request.getParameter("opc").equals("2")) {
            delConsultas(request, response);
        }
        if (request.getParameter("opc").equals("3")) {
            addConsultas(request, response);
        }
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

    private void listaConsultas(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException {
        String codEs= request.getParameter("codEsp");
        String cod = request.getParameter("cod");
        String nom = request.getParameter("nom");
        HttpSession ses = request.getSession();
        ses.setAttribute("cdEsp", codEs);
        ses.setAttribute("cod", cod);
        ses.setAttribute("nom", nom);
        String ruta = "/listaConsultas.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void delConsultas(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        DaoConsulta obj = new DaoConsulta();
        
        int cod = Integer.parseInt(request.getParameter("cod"));
        obj.delConsulta(cod);
        
        String ruta = "/administrador/listaConsultas.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
        
    }

    private void addConsultas(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
         Consulta p = new Consulta();
        DaoConsulta obj = new DaoConsulta();
        HttpSession ses = request.getSession();

       
        String nombre = request.getParameter("usuario");
        String correo = request.getParameter("email");
        String cons = request.getParameter("mensaje");

        
        p.setNom(nombre);
        p.setCorreo(correo);
        p.setCons(cons);
        obj.addConsulta(p);
        String ruta = "index2.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
    
    }

}
