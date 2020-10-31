package control;

import dao.DaoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo2.Cliente;

public class ControlCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String opc = request.getParameter("opc");
        
       if (opc.equals("1")) {
            listaClientes(request, response);
        }
        if (opc.equals("2")) {
            delClientes(request, response);
        }
        }

    private void listaClientes(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        Integer cod= Integer.parseInt(request.getParameter("codc"));
        String nom = request.getParameter("nom");
        String apell = request.getParameter("apellido");
        String tipodoc = request.getParameter("tipodoc");
        String nrodoc = request.getParameter("nrodoc");
        String sexo = request.getParameter("sex");
        String fecha = request.getParameter("feco");
        String correo = request.getParameter("correo");
        HttpSession ses = request.getSession();
        ses.setAttribute("cod", cod);
        ses.setAttribute("nom", nom);
        ses.setAttribute("apellido", apell);
        ses.setAttribute("tipodoc", tipodoc);
        ses.setAttribute("nrodoc", nrodoc);
        ses.setAttribute("sex", sexo);
        ses.setAttribute("feco", fecha);
        ses.setAttribute("correo", correo);
        String ruta = "/mClientes.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void delClientes(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        
        DaoCliente obj = new DaoCliente();
        
        String cod = request.getParameter("cod");
        obj.delCliente(cod);
        
        String ruta = "/administrador/mClientes.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
        
        
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
