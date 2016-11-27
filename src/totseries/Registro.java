/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.Date;
import java.util.List;

/**
 *
 * @author mrviciao
 */
public class Registro {
    private List<Cliente> clientes;
    private List<Administrador> administradores;
    
    public boolean hasUsuario(String username){
        return false;
        
    }
    
    public void registrar(String username, String password,
            String name, String pais, Date nacimiento){
    }
}
