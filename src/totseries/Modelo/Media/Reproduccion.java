/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.Modelo.Media;

import java.util.Date;

/**
 *
 * @author mrviciao
 */
public class Reproduccion {

    private String usuario;
    private Date fecha;

    public Reproduccion(String usuario) {
        this.usuario = usuario;
        this.fecha = new Date();
    }
}
