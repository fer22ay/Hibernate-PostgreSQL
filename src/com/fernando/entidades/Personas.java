package com.fernando.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 2020
 */
@Entity
@Table(name = "\"PERSONA\"", schema = "\"HIBERNATE\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByIdPersona", query = "SELECT p FROM Personas p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Personas.findByNombrePersona", query = "SELECT p FROM Personas p WHERE p.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "Personas.findByApellidoPersona", query = "SELECT p FROM Personas p WHERE p.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "Personas.findByFechaIngreso", query = "SELECT p FROM Personas p WHERE p.fechaIngreso = :fechaIngreso")})
public class Personas implements Serializable {

    private static final long serialVersionUID = -2167012108890219374L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"ID_PERSONA\"")
    private Integer idPersona;
    @Column(name = "\"NOMBRE_PERSONA\"")
    private String nombrePersona;
    @Column(name = "\"APELLIDO_PERSONA\"")
    private String apellidoPersona;
    @Column(name = "\"FECHA_INGRESO\"")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    public Personas() {
    }

    public Personas(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("SHA-1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md5.digest(apellidoPersona.getBytes());
        BigInteger bi = new BigInteger(1, messageDigest);
        apellidoPersona = bi.toString(16); 
            while (apellidoPersona.length() < 32) { 
                apellidoPersona = "0" + apellidoPersona; 
            } 
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        String fecha;
        this.fechaIngreso = fechaIngreso;

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        fecha = df.format(fechaIngreso);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID " + idPersona + " -  NOMBRE: " + nombrePersona + " " + apellidoPersona;
    }

}
