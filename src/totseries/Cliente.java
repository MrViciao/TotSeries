/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Cliente extends Usuario {

    private String pais;
    private Date nacimiento;
    private boolean vip;
    private String dni;
    private String direccion;
    private List<Factura> facturas;

    public Cliente(String id, String username, String password, String nombre) {
        super(id, username, password, nombre);
        this.facturas = new ArrayList<>();
        facturas.add(new Factura());
    }

    public Cliente(String id, String username, String password,
            String nombre, String dni, String adreca, boolean vip) {
        this(id, username, password, nombre);
        this.direccion = adreca;
        //this.nacimiento = nacimiento;
        this.vip = vip;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    public Factura getLastFactura() {
        if(facturas.isEmpty())return null;
        return this.facturas.get(facturas.size()-1);
    }
    
    public void addVisualizacion(){
        this.getLastFactura().addVisualizacion();
    }
}
