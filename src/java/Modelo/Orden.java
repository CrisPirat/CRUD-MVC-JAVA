
package Modelo;

import java.util.Date;

public class Orden extends Objeto{
    private Date ord_fecha;
    private Cliente ord_cliente;

    public Orden() {
    }

    public Orden(Date ord_fecha, Cliente ord_cliente) {
        this.ord_fecha = ord_fecha;
        this.ord_cliente = ord_cliente;
    }

    public Cliente getOrd_cliente() {
        return ord_cliente;
    }

    public void setOrd_cliente(Cliente ord_cliente) {
        this.ord_cliente = ord_cliente;
    }

    public Date getOrd_fecha() {
        return ord_fecha;
    }

    public void setOrd_fecha(Date ord_fecha) {
        this.ord_fecha = ord_fecha;
    }
    
}
