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
    private String pais;
    private Date nacimiento;
    private boolean vip;
    private List<Factura> facturas;
    
    public Cliente(String id, String username, String password, String nombre,String pais,Date nacimiento){
        super(id, username, password, nom);
        this.direccion=adreca;
        this.nacimiento = nacimiento;
        this.vip=false;
        this.facturas= new ArrayList<>();
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
}
