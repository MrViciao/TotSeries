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
public class IdleState implements ActivityState{
    
    public void nextState(Cliente c){
        c.setActivityState(new ActiveState());
    }
    
    public boolean canViewEpisode(){
        return true;
    }
}
