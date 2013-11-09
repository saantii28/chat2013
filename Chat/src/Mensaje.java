


import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago-Laptop
 */
class Mensaje {
    
    private String id_de;
    private String id_ha;
    private String cuerpo;
    private String nombre_de;
    private String nombre_ha;
    private Timestamp fecha;

    /**
     * @return the id_de
     */
    public String getId_de() {
        return id_de;
    }

    /**
     * @param id_de the co_id to set
     */
    public void setId_de(String co_id) {
        this.id_de = co_id;
    }

    /**
     * @return the id_ha
     */
    public String getId_ha() {
        return id_ha;
    }

    /**
     * @param id_ha the co_ha to set
     */
    public void setId_ha(String co_ha) {
        this.id_ha = co_ha;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * @return the nombre_de
     */
    public String getNombre_de() {
        return nombre_de;
    }

    /**
     * @param nombre_de the nombre_de to set
     */
    public void setNombre_de(String nombre_de) {
        this.nombre_de = nombre_de;
    }

    /**
     * @return the nombre_ha
     */
    public String getNombre_ha() {
        return nombre_ha;
    }

    /**
     * @param nombre_ha the nombre_ha to set
     */
    public void setNombre_ha(String nombre_ha) {
        this.nombre_ha = nombre_ha;
    }

    /**
     * @return the fecha
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
