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
    
    public void registrar(String id, String nom, String dni, String adreca, String usuari, String password, boolean vip){
        Cliente cliente = new Cliente(id, nom, dni, adreca, usuari, password, vip);
        clientes.add(cliente);
    }
}
