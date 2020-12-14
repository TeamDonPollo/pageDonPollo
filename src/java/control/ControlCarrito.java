package control;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import dao.DaoPedido;
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
import static jdk.nashorn.internal.objects.NativeMath.round;
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
import modelo.Compra;
import modelo2.Producto;

public class ControlCarrito extends HttpServlet {

    DaoProducto objProductos = new DaoProducto();
<<<<<<< HEAD
=======
<<<<<<< HEAD
    DaoPedido objPedido = new DaoPedido();
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    private String getTotalMount(List<Compra> cartList) {
        double totalMount = 0;
        for(Compra cartItem : cartList) {
            totalMount = cartItem.Total() + totalMount;
        }
        return String.valueOf(ControlCarrito.round(totalMount, 2));
    }
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23

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

<<<<<<< HEAD
=======
<<<<<<< HEAD
        if (accion.equals("generarCompra")) {
            generarCompra(request, response);
        }
    }

    protected void generarCompra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        List<Compra> lista;
        HttpSession ses = request.getSession();
        String resp = "";

        lista = (ArrayList<Compra>) ses.getAttribute("canasta");
        String codeCliente = (String) ses.getAttribute("idCliente");

        String direccion = request.getParameter("direccion");

        if (lista.isEmpty() || lista == null || lista.size() == 0) {
            resp = "El carrito se encuentra vacio.No se ha podido Generar la compra";
        } else if (codeCliente == null || codeCliente.trim().length() == 0) {
            resp = "No se encontraron datos del cliente logeado.No se ha podido Generar la compra";
        } else {
            resp = objPedido.GrabarPedido(codeCliente, direccion, lista);
            
            ses.setAttribute("canasta", null);
            
        }

        out.print(resp);
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Compra> lista;
<<<<<<< HEAD
=======
<<<<<<< HEAD
        Integer sizeProducts = 0;
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        HttpSession ses = request.getSession();

        lista = (ArrayList<Compra>) ses.getAttribute("canasta");

        int posc = Integer.parseInt(request.getParameter("posc"));

<<<<<<< HEAD
=======
<<<<<<< HEAD
        if (lista.size() > 0 && posc < lista.size()) {
            lista.remove(posc);
        }
        sizeProducts = lista.size();
        ses.setAttribute("canasta", lista);
        ses.setAttribute("sizeProducts",sizeProducts);
        ses.setAttribute("totalMount",this.getTotalMount(lista));
=======
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        if (lista.size() > 0 && posc<lista.size()) {
            lista.remove(posc);
        }

        ses.setAttribute("canasta", lista);
<<<<<<< HEAD
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        String pag = "/pCompra.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Compra> lista;
<<<<<<< HEAD
=======
<<<<<<< HEAD
        Integer sizeProducts = 0;
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        HttpSession ses = request.getSession();
        if (ses.getAttribute("canasta") == null) {
            lista = new ArrayList<>();
        } else {
            lista = (ArrayList<Compra>) ses.getAttribute("canasta");
        }
<<<<<<< HEAD
        ses.setAttribute("canasta", lista);
=======
<<<<<<< HEAD
        sizeProducts = lista.size();
        ses.setAttribute("canasta", lista);
        ses.setAttribute("sizeProducts",sizeProducts);
        ses.setAttribute("totalMount",this.getTotalMount(lista));
=======
        ses.setAttribute("canasta", lista);
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
        Integer sizeProducts = 0;
=======
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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
<<<<<<< HEAD

=======
<<<<<<< HEAD
           
=======

>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
        int indice = BuscarProducto((ArrayList<Compra>) lista, cod);
        if (indice == -1) {
            lista.add(cp);
        } else {
            Compra c = lista.get(indice);
            c.setCantidad(c.getCantidad() + can);
            lista.set(indice, c);
        }
<<<<<<< HEAD

        ses.setAttribute("canasta", lista);
=======
<<<<<<< HEAD
        
        sizeProducts = lista.size();

        ses.setAttribute("canasta", lista);
        ses.setAttribute("sizeProducts",sizeProducts);
        ses.setAttribute("totalMount",this.getTotalMount(lista));
=======

        ses.setAttribute("canasta", lista);
>>>>>>> b4b8914a0d99ff7d24ea5cb9c99c8ec6db4b94ae
>>>>>>> 0d5a10e7982d98d432436cbc6600725e727bdd23
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
