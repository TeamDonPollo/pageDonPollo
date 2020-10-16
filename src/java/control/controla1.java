package control;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import dao.Negocio;
public class controla1 extends HttpServlet {
     Negocio obj=new Negocio();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String op=request.getParameter("opc");
      if(op.equals("1"))lisEsp(request, response);
      if(op.equals("2"))lisAlu(request, response);
      if(op.equals("3"))lisPago(request, response);
      if(op.equals("4"))lisNota(request, response);
    }
    //los metodos que van reenviar la informacion
     protected void lisEsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dato", obj.lisEsp());
        String pag="/pagEsp.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
        
    }
     protected void lisAlu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar el codigo de especilidad
        String cod=request.getParameter("id");
       request.setAttribute("dato", obj.lisAlu(cod));
        String pag="/pagAlu.jsp";
        request.getRequestDispatcher(pag).forward(request, response); 
    }
   protected void lisPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String cod=request.getParameter("id");
       request.setAttribute("dato", obj.lisPago(cod));
        String pag="/pagPago.jsp";
        request.getRequestDispatcher(pag).forward(request, response); 
        
    }
         protected void lisNota(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String cod=request.getParameter("id");
       request.setAttribute("dato", obj.lisNota(cod));
        String pag="/pagNota.jsp";
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
