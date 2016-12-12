/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries.totseries.Exceptions;

/**
 *
 * @author gcervifi15.alumnes
 */
public class SerieNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>SerieNotFoundException</code> without
     * detail message.
     */
    public SerieNotFoundException() {
    }

    /**
     * Constructs an instance of <code>SerieNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SerieNotFoundException(String msg) {
        super(msg);
    }
}
