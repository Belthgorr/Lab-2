/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.comnapny.session;

import com.mycompany.entity.Transaccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Victor
 */
@Local
public interface TransaccionManagerLocal {

    List<Transaccion> getAllTransacciones();

    Transaccion update(Transaccion transaccion);

  
    
}
