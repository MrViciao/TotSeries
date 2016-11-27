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
public abstract class Usuario {
    
    protected String id;
    protected String username;
    protected String password;
    protected String nombre;
    
    public Usuario(){
        
    }
    public Usuario(String id,String username, String password, String nombre){
        this.id=id;
        this.username=username;
        this.password=password;
        this.nombre=nombre;
    }
}
