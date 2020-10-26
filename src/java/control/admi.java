

package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo2.*;import dao.*;


public class admi extends HttpServlet {

    Negocio2 ng2=new Negocio2();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String opc=request.getParameter("opc");
        if(opc.equals("1"))lisProm(request, response);
        if(opc.equals("2"))lisPollo(request, response);
        if(opc.equals("3"))lisGuar(request, response); 
        if(opc.equals("4"))lisSang(request, response); 
        if(opc.equals("5"))lisBeb(request, response); 
    }
    protected void lisProm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        HttpSession ses=request.getSession();
        request.setAttribute("dato", ng2.lisProd(id));
        String pag="/admi/mProm.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
        protected void lisPollo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String pag="admi/mPollo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    }
         protected void lisGuar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      String pag="/admi/mGuar.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
      
    }   
      protected void lisSang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
          String pag="/admi/mSang.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
          
    }      
         
         protected void lisBeb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String pag="/admi/mBeb.jsp";
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
