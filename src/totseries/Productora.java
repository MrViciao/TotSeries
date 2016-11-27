/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.Date;

/**
 *
 * @author mrviciao
 */
public class Productora {
    private String nombre;
    private String id;
    private Date f_creacion;
    
    public Productora(){};
    public Productora(String id, String nombre){
        this.id=id;
        this.nombre=nombre;
    };
}
