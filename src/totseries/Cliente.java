/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;


/**
 *
 * @author mrviciao
 */
public class Cliente extends Usuario{
    private String direccion;
    private String dni;
    private boolean vip;
    private List<Factura> facturas;
    
    public Cliente(String id, String nom, String dni, String adreca, String usuari, String password, boolean vip){
        super(id, usuari, password, nom);
        this.direccion=adreca;
        this.dni=dni;
        this.vip=vip;
        this.facturas= new ArrayList<>();
    }
    public void setVisualizacion(){
        this.facturas.get(this.facturas.size()-1).setVisualizacion();
    }
}
