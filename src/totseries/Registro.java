/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Registro {
    private List<Cliente> clientes;
    private List<Administrador> administradores;
    
    public Registro(){
        this.clientes = new ArrayList<>();
        this.administradores = new ArrayList<>();
    }
    
    public boolean hasUsuario(String username){
        return false;
        
    }
    
    public void registrar(String nom, String dni, String adreca, String usuari, String password){
        
        Cliente cliente = new Cliente("makenewid",  usuari,  password, nom, dni, adreca, false);
        clientes.add(cliente);
    }
}
