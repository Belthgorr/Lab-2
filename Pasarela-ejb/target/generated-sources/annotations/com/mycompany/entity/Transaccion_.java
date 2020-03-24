package com.mycompany.entity;

import com.mycompany.entity.TransaccionPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-03-23T21:27:05")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, Integer> cvv;
    public static volatile SingularAttribute<Transaccion, String> tipoTarjeta;
    public static volatile SingularAttribute<Transaccion, Double> valorTransaccion;
    public static volatile SingularAttribute<Transaccion, Date> fechaVencimiento;
    public static volatile SingularAttribute<Transaccion, Integer> id;
    public static volatile SingularAttribute<Transaccion, String> nombre;
    public static volatile SingularAttribute<Transaccion, String> email;
    public static volatile SingularAttribute<Transaccion, TransaccionPK> transaccionPK;

}