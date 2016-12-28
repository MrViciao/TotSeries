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
public abstract class AbstractUsuarioCreator {

    public abstract Usuario createUsuario(String id, String username, String password, String nombre);
}
