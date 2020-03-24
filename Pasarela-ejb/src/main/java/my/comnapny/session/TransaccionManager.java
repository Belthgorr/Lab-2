/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.comnapny.session;

import com.mycompany.entity.Transaccion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import my.comnapny.session.TransaccionManagerLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
@Stateless
public class TransaccionManager implements TransaccionManagerLocal {

    @PersistenceContext(unitName = "com.mycompany_Pasarela-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    @Override
    public List<Transaccion> getAllTransacciones() {
        Query query = em.createNamedQuery("Transaccion.findAll");
        return query.getResultList();
    }

    @Override
    public Transaccion update(Transaccion transaccion) {
        double numeroTarjeta=transaccion.getTransaccionPK().getCardNumber()%100000;
        String tipo="";
        if (numeroTarjeta>11111 && numeroTarjeta<=22222) {
            tipo="American Express";
        } else if (numeroTarjeta>33334 && numeroTarjeta<=44444) {
            tipo="Diners";
        } else if (numeroTarjeta>55555 && numeroTarjeta<=66666) {
            tipo="Visa";
        } else if (numeroTarjeta>77777 && numeroTarjeta<=88888) {
            tipo="Mastercard";
        }
        transaccion.setTipoTarjeta(tipo);
        return em.merge(transaccion);
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

   
    
    
    
}
