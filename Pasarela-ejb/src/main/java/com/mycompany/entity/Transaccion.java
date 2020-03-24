/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByNombre", query = "SELECT t FROM Transaccion t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Transaccion.findByEmail", query = "SELECT t FROM Transaccion t WHERE t.email = :email")
    , @NamedQuery(name = "Transaccion.findByCardNumber", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.cardNumber = :cardNumber")
    , @NamedQuery(name = "Transaccion.findByCvv", query = "SELECT t FROM Transaccion t WHERE t.cvv = :cvv")
    , @NamedQuery(name = "Transaccion.findByTipoTarjeta", query = "SELECT t FROM Transaccion t WHERE t.tipoTarjeta = :tipoTarjeta")
    , @NamedQuery(name = "Transaccion.findByValorTransaccion", query = "SELECT t FROM Transaccion t WHERE t.valorTransaccion = :valorTransaccion")
    , @NamedQuery(name = "Transaccion.findById", query = "SELECT t FROM Transaccion t WHERE t.id = :id")
    , @NamedQuery(name = "Transaccion.findByFechaVencimiento", query = "SELECT t FROM Transaccion t WHERE t.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Transaccion.findByTiempoTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.tiempoTransaccion = :tiempoTransaccion")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv")
    private int cvv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoTarjeta")
    private String tipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTransaccion")
    private double valorTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(TransaccionPK transaccionPK, String nombre, String email, int cvv, String tipoTarjeta, double valorTransaccion, int id, Date fechaVencimiento) {
        this.transaccionPK = transaccionPK;
        this.nombre = nombre;
        this.email = email;
        this.cvv = cvv;
        this.tipoTarjeta = tipoTarjeta;
        this.valorTransaccion = valorTransaccion;
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Transaccion(int cardNumber, Date tiempoTransaccion) {
        this.transaccionPK = new TransaccionPK(cardNumber, tiempoTransaccion);
    }

    public TransaccionPK getTransaccionPK() {
        return transaccionPK;
    }

    public void setTransaccionPK(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public double getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(double valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.transaccionPK == null && other.transaccionPK != null) || (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Transaccion[ transaccionPK=" + transaccionPK + " ]";
    }
    
}
