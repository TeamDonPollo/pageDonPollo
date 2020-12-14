

package control;


import dao.*; import modelo2.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;


@MultipartConfig
public class admi2 extends HttpServlet {
     DaoProducto ng2=new DaoProducto();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String op = request.getParameter("opc");
        if (op.equals("1"))manProd(request, response);
        if (op.equals("2"))pagIntfzProd(request, response);
        if (op.equals("3"))nuevoProd(request, response);
        if (op.equals("4"))eProd(request, response);
        if (op.equals("5"))editProd(request, response);
        if (op.equals("6"))addProd(request, response);
        if (op.equals("7"))delProd(request, response);
    }
    
    protected void manProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        HttpSession ses=request.getSession();
        ses.setAttribute("dato", ng2.lisProd(code));
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
     protected void eProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codp = request.getParameter("id");
        HttpSession rs=request.getSession();
        request.setAttribute("cod", codp);
        rs.setAttribute("objProd", ng2.busProd(codp));
        
        String pag="/administrador/pruebaEditIMG.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
       
    }
    
     protected void editProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        /* HttpSession rs=request.getSession();
        Producto s2=(Producto)rs.getAttribute("objProd");
        String iddd=s2.getIdprod();*/
         Producto a=new Producto();
         a.setIdprod(request.getParameter("idp"));
         a.setNom(request.getParameter("nombre"));
         a.setDescrip(request.getParameter("descripcion"));
         a.setPrecio(Double.parseDouble(request.getParameter("precio")));
         a.setStock(Integer.parseInt(request.getParameter("stock")));
         a.setDscto(Integer.parseInt(request.getParameter("dscto")));
         if(request.getPart("fileFoto")!=null){
             Part part=request.getPart("fileFoto"); InputStream inputS=part.getInputStream();
             a.setFoto(inputS);
         }else{
             a.setFoto(null);
         }
         
       // request.setAttribute("prodd", a);
         ng2.Modifica(a);
         manProd(request, response);
         
        /* String pag="/administrador/testeo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);*/
         
       
    }
     
      protected void addProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

               String codp = request.getParameter("cp");
                //request.setAttribute("cod", codp);
                Producto a = new Producto();
                a.setNom(request.getParameter("nombre"));
                a.setIdprod(codp);
                a.setDescrip(request.getParameter("descripcion"));
                a.setPrecio(Double.parseDouble(request.getParameter("precio")));
                a.setStock(Integer.parseInt(request.getParameter("stock")));
                a.setCodtip(request.getParameter("tipo"));
                a.setDscto(Integer.parseInt(request.getParameter("dscto")));
                Part part = request.getPart("fileFoto");
                InputStream inputS = part.getInputStream();
                a.setFoto(inputS);
                ng2.addProd(a);
          
          
       
        manProd(request, response);
       
    }
      
      protected void delProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String codp = request.getParameter("id");
          ng2.delProd(codp);
          manProd(request, response);
          
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
