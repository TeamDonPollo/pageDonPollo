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
import modelo2.*;
import dao.*;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig
public class admi extends HttpServlet {

    TipoProductoDAO obj = new TipoProductoDAO();
    DaoProducto ng2 = new DaoProducto();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String opc = request.getParameter("opc");
        
        if (opc.equals("2")) {
            eClientes(request, response);
        }
        if (opc.equals("3")) {
            eConsul(request, response);
        }
        if (opc.equals("4")) {
            grafico(request, response);
        }
        if (opc.equals("6")) {
            lisProd(request, response);
        }
    }

    protected void lisProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");
        request.setAttribute("productos", obj.ListaProductos(code));
        //request.setAttribute("productos", ng2.lisProd(code));
        String pag = "pProducto.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void eConsul(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pag = "/administrador/listaConsultas.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void eClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pag = "/administrador/mClientes.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }

      protected void grafico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pag = "/administrador/pgGrafico.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        // String cod=request.getParameter("code");
        switch (accion) {
            case "Listar":
                //  List<Producto> lista=ng2.lisProd(cod);
                // request.setAttribute("lista", lista);
                // String pag="/administrador/test2.jsp";
                // request.getRequestDispatcher(pag).forward(request, response);
                break;
            case "Guardar":
                String codp = request.getParameter("codpp");
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
                break;
            default:
                request.getRequestDispatcher("admi?accion=Listar").forward(request, response);
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
