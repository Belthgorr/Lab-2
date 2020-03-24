/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.mycompany.entity.Transaccion;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import my.comnapny.session.TransaccionManagerLocal;

/**
 *
 * @author Victor
 */
public class TransaccionMBean {

    @EJB
    private my.comnapny.session.TransaccionManagerLocal transaccionManager;

    /**
     * Creates a new instance of TransaccionMBean
     */
    public TransaccionMBean() {
    }
    
    private Transaccion transaccion;
    private List<Transaccion> transacciones;
    
    /**
     * Creates a new instance of PagoMBean
     */
 
    
    public List<Transaccion> getTransacciones(){
        if ((transacciones==null)||(transacciones.isEmpty())) {
            refresh();
        }
        return transacciones;
    }
    
   /* public Transaccion getPago(){
        if (transaccion==null) {
            transaccion = new Transaccion("","",22333,123,"bla",5000,new Date(),(short)1);
        }
        return transaccion;
    }*/
    
    public String showTransaccion(Transaccion transaccion){
        this.transaccion=transaccion;
        return "DETAIL";
    }
    
    public String showForm() {
        return "FORM";
    }
    
    public String update() {
        transaccion=transaccionManager.update(transaccion);
        return "SAVED";
    }
    
    /*public javax.faces.model.SelectItem[] getPagos() {
        SelectItem[] options=null;
        List<Pago> pagos=pagoManager.getAllPagos();
        if (pagos!=null && pagos.size()>0) {
            int i=0;
            options=new SelectItem[pagos.size()];
            for (Pago pago : pagos) {
                options[i++] = new SelectItem(pago);
            }
        }
        return options;
    }*/
    
    private void refresh(){
        transacciones=transaccionManager.getAllTransacciones();
    }
    
}
