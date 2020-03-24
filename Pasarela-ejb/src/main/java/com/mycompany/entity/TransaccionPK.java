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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Victor
 */
@Embeddable
public class TransaccionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cardNumber")
    private int cardNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempoTransaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoTransaccion;

    public TransaccionPK() {
    }

    public TransaccionPK(int cardNumber, Date tiempoTransaccion) {
        this.cardNumber = cardNumber;
        this.tiempoTransaccion = tiempoTransaccion;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getTiempoTransaccion() {
        return tiempoTransaccion;
    }

    public void setTiempoTransaccion(Date tiempoTransaccion) {
        this.tiempoTransaccion = tiempoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cardNumber;
        hash += (tiempoTransaccion != null ? tiempoTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK)) {
            return false;
        }
        TransaccionPK other = (TransaccionPK) object;
        if (this.cardNumber != other.cardNumber) {
            return false;
        }
        if ((this.tiempoTransaccion == null && other.tiempoTransaccion != null) || (this.tiempoTransaccion != null && !this.tiempoTransaccion.equals(other.tiempoTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.TransaccionPK[ cardNumber=" + cardNumber + ", tiempoTransaccion=" + tiempoTransaccion + " ]";
    }
    
}
