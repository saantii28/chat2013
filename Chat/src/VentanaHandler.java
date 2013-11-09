
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago-Laptop
 */
public class VentanaHandler {
    
    public static ArrayList<Contacto> getContactos() throws SQLException{
        ArrayList<Contacto> contactos = new ArrayList();
        Connection con;
        PreparedStatement stmt;
        try {
            con = DBHandler.getConnection();
            stmt = con.prepareStatement("Select * from contactos");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Contacto c = new Contacto();
                c.setId(rs.getString("co_id"));
                c.setName(rs.getString("co_name"));
                c.setMail(rs.getString("co_mail"));
                contactos.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return contactos;
    }
    
}
