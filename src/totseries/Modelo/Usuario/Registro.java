/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Usuario;

import com.sun.security.ntlm.Client;
import totseries.Modelo.Usuario.Administrador;
import totseries.Modelo.Usuario.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import totseries.Modelo.Usuario.ClienteCreator;
import totseries.Modelo.Usuario.Usuario;

/**
 *
 * @author mrviciao
 */
public class Registro {

    private List<Usuario> usuarios;
    private Usuario logged;

    public Registro() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarAdmin(String usuari, String password, String nom) {
        String id = "u" + usuarios.size() + 1;
        AdministradorCreator cc = new AdministradorCreator();
        Usuario user = cc.createUsuario(id, usuari, password, nom);
        usuarios.add(user);
    }

    public void registrarCliente(String nom, String dni, String adreca, String usuari, String password) {
        String id = "u" + usuarios.size() + 1;
        ClienteCreator cc = new ClienteCreator();
        Cliente user = cc.createUsuario(id, usuari, password, nom);
        user.setDni(dni);
        user.setDireccion(adreca);
        usuarios.add(user);
    }

    public void setLoggedUser(Usuario user) {
        logged = user;

    }

    public Usuario getLoggedUser() {
        return logged;
    }

    public boolean isLogged() {
        return logged != null;
    }

    public Cliente getLoggedAsCliente() {
        if (logged instanceof Cliente) {
            return (Cliente) logged;
        }
        return null;
    }

    public Administrador getLoggedAsAdmin() {
        if (logged instanceof Administrador) {
            return (Administrador) logged;
        }
        return null;
    }

    public Usuario login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                logged = usuario;
                return usuario;
            }
        }
        return null;
    }

    public boolean isLoggedAdmin() {
        return this.logged instanceof Administrador;
    }

    public List<Usuario> getClientesNonVIP() {
        Iterator usuario = this.usuarios.iterator();
        List<Usuario> lista = new ArrayList<>();
        Usuario aux;
        while (usuario.hasNext()) {
            aux = (Usuario) usuario.next();
            
            if (aux instanceof Cliente) {
                if (!((Cliente) aux).isVip()) {
                    lista.add(aux);
                }
            }
        }
        return lista;
    }
    
    public void setVIP(Cliente cliente){
           cliente.setVip(true);
    }
    
    /// SIN USO
    public boolean hasUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
