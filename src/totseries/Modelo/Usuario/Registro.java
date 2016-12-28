/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Usuario;

import totseries.Modelo.Usuario.Administrador;
import totseries.Modelo.Usuario.Cliente;
import java.util.ArrayList;
import java.util.List;
import totseries.Modelo.Usuario.ClienteCreator;
import totseries.Modelo.Usuario.Usuario;

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
        for(Cliente cliente : clientes){
            if(cliente.getUsername().equals(username))
                return false;
        }
        for(Administrador administrador : administradores){
            if(administrador.getUsername().equals(username))
                return false;
        }
        return true;
        
    }
    
    public void registrar(String nom, String dni, String adreca, String usuari, String password){
        String id="c"+clientes.size()+1;
        
        //ClienteCreator cc = new ClienteCreator();
        //Usuario user = cc.createUsuario("c0", "test", "test", "test");
        Cliente cliente = new Cliente(id,  usuari,  password, nom, dni, adreca, false);
        clientes.add(cliente);
    }
}
