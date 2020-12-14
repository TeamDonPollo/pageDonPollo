package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Location;
import util.MySQLConexion;

public class DaoLocation {
    private ResultSet getDynamiResultSet(String queryToExecute) throws SQLException {
        Connection conn = MySQLConexion.getConexion();
        PreparedStatement st = conn.prepareStatement(queryToExecute);
        ResultSet rs = st.executeQuery();
        return rs;
    }
    
    public List<Location> getLocations() {
        List<Location> locationsList = new ArrayList<>();
        try {
            ResultSet rs = this.getDynamiResultSet("SELECT location_name,location_description,location_phone,location_delivery_store_time,location_reception_time,location_presential_time,location_image from locations");
            while (rs.next()) {
                Location location = new Location();
                
                location.setLocationName(rs.getString(1));
                location.setDescription(rs.getString(2));
                location.setPhoneNumber(rs.getString(3));
                location.setDeliveryStoreTime(rs.getString(4));
                location.setReceptionTime(rs.getString(5));
                location.setPresentialTime(rs.getString(6));
                location.setLocationImage(rs.getString(7));
                locationsList.add(location);
            }
            return locationsList;
        } catch (Exception ex) {
            throw new Error(ex.getMessage());
        } 
    }
}
