package control;

import dao.DaoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Compra;
import modelo2.Producto;

public class ControlCarrito extends HttpServlet {

    DaoProducto objProductos = new DaoProducto();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("agregar")) {
            AgregarCarrito(request, response);
        }

        if (accion.equals("miCarrito")) {
            Listar(request, response);
        }

        if (accion.equals("eliminar")) {
            Eliminar(request, response);
        }

        if (accion.equals("actualizar")) {
            ActualizarCarrito(request, response);
        }

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Compra> lista;
        HttpSession ses = request.getSession();

        lista = (ArrayList<Compra>) ses.getAttribute("canasta");

        int posc = Integer.parseInt(request.getParameter("posc"));

        if (lista.size() > 0 && posc<lista.size()) {
            lista.remove(posc);
        }

        ses.setAttribute("canasta", lista);
        String pag = "/pCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Compra> lista;
        HttpSession ses = request.getSession();
        if (ses.getAttribute("canasta") == null) {
            lista = new ArrayList<>();
        } else {
            lista = (ArrayList<Compra>) ses.getAttribute("canasta");
        }
        ses.setAttribute("canasta", lista);
        String pag = "/pCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void ActualizarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Compra> lista = null;
        Compra cp = new Compra();

        int can = Integer.parseInt(request.getParameter("tcan"));
        String cod = request.getParameter("code");

        HttpSession ses = request.getSession();

        lista = (ArrayList<Compra>) ses.getAttribute("canasta");

        int indice = BuscarProducto((ArrayList<Compra>) lista, cod);

        if (indice != -1) {
            Compra c = lista.get(indice);
            c.setCantidad(can);
            lista.set(indice, c);
        }

        ses.setAttribute("canasta", lista);
        String pag = "/pCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void AgregarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Compra> lista = null;
        Compra cp = new Compra();

        int can = Integer.parseInt(request.getParameter("tcan"));
        String cod = request.getParameter("code");

        Producto a = objProductos.busProd(cod);
        cp.setCodProducto(cod);
        cp.setProducto(a.getNom());
        cp.setPrecio(a.getPrecio());
        cp.setCantidad(can);

        HttpSession ses = request.getSession();
        if (ses.getAttribute("canasta") == null) {
            lista = new ArrayList<>();
        } else {
            lista = (ArrayList<Compra>) ses.getAttribute("canasta");
        }

        int indice = BuscarProducto((ArrayList<Compra>) lista, cod);
        if (indice == -1) {
            lista.add(cp);
        } else {
            Compra c = lista.get(indice);
            c.setCantidad(c.getCantidad() + can);
            lista.set(indice, c);
        }

        ses.setAttribute("canasta", lista);
        String pag = "/pCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    public int BuscarProducto(ArrayList<Compra> lista, String code) {
        for (int i = 0; i < lista.size(); i++) {
            Compra c = lista.get(i);

            if (c.getCodProducto().equals(code)) {
                return i;
            }
        }
        return -1;
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
