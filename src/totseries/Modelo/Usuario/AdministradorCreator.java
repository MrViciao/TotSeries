/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Usuario;

/**
 *
 * @author mrviciao
 */
public class AdministradorCreator extends AbstractUsuarioCreator{    
    public Usuario createUsuario(String id, String username, String password, String nombre) {
        return new Administrador(id, username, password, nombre);
    }
}
