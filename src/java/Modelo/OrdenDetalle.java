/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author crist
 */
public class OrdenDetalle extends Objeto{
    private Orden odt_orden;
    private Articulo odt_articulo;
    private Float odt_cantidad;

    public OrdenDetalle() {
    }

    public OrdenDetalle(Orden odt_orden, Articulo odt_articulo, Float odt_cantidad) {
        this.odt_orden = odt_orden;
        this.odt_articulo = odt_articulo;
        this.odt_cantidad = odt_cantidad;
    }

    public Float getOdt_cantidad() {
        return odt_cantidad;
    }

    public void setOdt_cantidad(Float odt_cantidad) {
        this.odt_cantidad = odt_cantidad;
    }

    public Orden getOdt_orden() {
        return odt_orden;
    }

    public void setOdt_orden(Orden odt_orden) {
        this.odt_orden = odt_orden;
    }

    public Articulo getOdt_articulo() {
        return odt_articulo;
    }

    public void setOdt_articulo(Articulo odt_articulo) {
        this.odt_articulo = odt_articulo;
    }
    
}
