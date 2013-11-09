
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

    static void insertarMensaje(Contacto co_de, Contacto co_ha, String mensaje) throws SQLException {
        Connection con;
        PreparedStatement stmt;
        try {
            con = DBHandler.getConnection();
            stmt = con.prepareStatement("INSERT INTO mensajes (co_id_de, co_id_ha, msg_cuerpo) VALUES (?, ?, ?)");
            stmt.setString(1, co_de.getId());
            stmt.setString(2, co_ha.getId());
            stmt.setString(3, mensaje);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    static ArrayList<Mensaje> getMensajes(Contacto co_de, Contacto co_ha) {
        ArrayList<Mensaje> mensajes = new ArrayList();
        Connection con;
        PreparedStatement stmt;
        try {
            con = DBHandler.getConnection();
            stmt = con.prepareStatement(""
                    + "SELECT * "
                    + "FROM mensajes m, contactos cde, contactos cha "
                    + "WHERE "
                    + "cde.co_id = m.co_id_de AND "
                    + "cha.co_id = m.co_id_ha AND "
                    + "((cde.co_id = ? AND cha.co_id = ?) "
                    + "OR "
                    + "(cde.co_id = ? AND cha.co_id = ?)) ");
            stmt.setString(1, co_de.getId());
            stmt.setString(2, co_ha.getId());
            stmt.setString(3, co_ha.getId());
            stmt.setString(4, co_de.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mensaje mensaje = new Mensaje();
                mensaje.setId_de(rs.getString(1));
                mensaje.setId_ha(rs.getString(2));
                mensaje.setNombre_de(rs.getString(7));
                mensaje.setNombre_ha(rs.getString(10));
                mensaje.setCuerpo(rs.getString(3));
                mensaje.setFecha(rs.getTimestamp(4));
                mensajes.add(mensaje);
            }
        } catch (Exception e) {
        }
        
        return mensajes;
    }
    
}
