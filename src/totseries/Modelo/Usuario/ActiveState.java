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
public class ActiveState implements ActivityState{

    public void nextState(Cliente c) {
        c.setActivityState(new IdleState());
    }
    
    public boolean canViewEpisode(){
        return false;
    }
    
}
