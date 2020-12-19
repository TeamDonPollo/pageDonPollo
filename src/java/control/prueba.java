
package control;

import dao.DaoPrueba;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ClaseProducto;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class prueba extends HttpServlet {
DaoPrueba obj=new DaoPrueba();

     JFreeChart barra( String an){
    DefaultCategoryDataset ds=new DefaultCategoryDataset();
    for(ClaseProducto x:obj.busProd(an)){
        ds.setValue(x.getPrecio(), "ventas", x.getProdu());
    }
    JFreeChart fg=ChartFactory.createBarChart3D("Productos más vendidos según tipo","producto","cantidad", ds,
    PlotOrientation.VERTICAL,true,true,true);
    return fg;
    }
    
    JFreeChart circulo(String an){
    DefaultPieDataset ds=new DefaultPieDataset();//llenar la data a graficar
    for(ClaseProducto x:obj.busProd(an)){
        ds.setValue(x.getProdu(), x.getPrecio());
    }
    JFreeChart fg=ChartFactory.createPieChart("Productos más vendidos según tipo", ds, true, true,true);
    return fg;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("image/jpeg");
        OutputStream flujo=response.getOutputStream();
        String an=request.getParameter("tan");
        int opc=Integer.parseInt(request.getParameter("op"));

        switch(opc){
            case 1: ChartUtilities.writeChartAsJPEG(flujo, barra(an), 500, 400);break;
            case 2: ChartUtilities.writeChartAsJPEG(flujo, circulo(an), 500, 400);break;
        }
        flujo.close();
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
