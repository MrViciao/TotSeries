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
public class Administrador extends Usuario{
    
    public Administrador(){};
    public Administrador(String id,String username, String password, String nombre){
        super(id, username, password, nombre);
    };
}
