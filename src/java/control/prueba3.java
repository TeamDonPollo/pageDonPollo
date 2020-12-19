/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoPrueba;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.PedidoCliente;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Administrador
 */
public class prueba3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        OutputStream flujo=response.getOutputStream();
        String an=request.getParameter("tan2");
        int opc=Integer.parseInt(request.getParameter("op2"));

        switch(opc){
            case 1: ChartUtilities.writeChartAsJPEG(flujo, barra(an), 500, 400);break;
            case 2: ChartUtilities.writeChartAsJPEG(flujo, circulo(an), 500, 400);break;
        }
        flujo.close();
    }
    
    
    DaoPrueba obj=new DaoPrueba();

     JFreeChart barra( String an){
    DefaultCategoryDataset ds=new DefaultCategoryDataset();
    for(PedidoCliente x:obj.busDia(an)){
        ds.setValue(x.getTotal(), "ventas", x.getCliente());
    }
    JFreeChart fg=ChartFactory.createBarChart3D("Clientes con mayor compra","producto","cantidad", ds,
    PlotOrientation.VERTICAL,true,true,true);
    return fg;
    }
    
    JFreeChart circulo(String an){
    DefaultPieDataset ds=new DefaultPieDataset();//llenar la data a graficar
    for(PedidoCliente x:obj.busDia(an)){
        ds.setValue(x.getCliente(), x.getTotal());
    }
    JFreeChart fg=ChartFactory.createPieChart("Clientes con mayor compra", ds, true, true,true);
    return fg;
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
