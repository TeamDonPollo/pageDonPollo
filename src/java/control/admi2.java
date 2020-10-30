

package control;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class admi2 extends HttpServlet {
     Negocio2 ng2=new Negocio2();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String op = request.getParameter("opc");
        if (op.equals("1"))manProd(request, response);
        if (op.equals("2"))pagIntfzProd(request, response);
        if (op.equals("3"))nuevoProd(request, response);
        if (op.equals("4"))editProd(request, response);
    }
    
    protected void manProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        //HttpSession ses=request.getSession();
        request.setAttribute("dato", ng2.lisProd(code));
        request.setAttribute("codProd", code);
        request.setAttribute("tipo", nom);
        String pag="/administrador/mGeneral.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
       
    }
    
    protected void pagIntfzProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codp = request.getParameter("id");
        request.setAttribute("cod", codp);
        String pag="/administrador/nuevoProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
       
    }
    
    protected void nuevoProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codp = request.getParameter("id");
        request.setAttribute("cod", codp);
        String pag="/administrador/nuevoProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
       
    }
    
     protected void editProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codp = request.getParameter("id");
        request.setAttribute("cod", codp);
        request.setAttribute("objProd", ng2.busProd(codp));
        String pag="/administrador/editProd.jsp";
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
