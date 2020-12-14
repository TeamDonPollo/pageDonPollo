package control;

import dao.DaoLocation;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Location;

public class ControlLocations extends HttpServlet {

    DaoLocation daoLocation = new DaoLocation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            List<Location> locationsList = this.daoLocation.getLocations();   
            request.setAttribute("locations", locationsList);
            request.getRequestDispatcher("/pagLocations.jsp").forward(request, response);
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
        }   
    }
}
