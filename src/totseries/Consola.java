/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mrviciao
 */
public class Consola {
    private Scanner sc;
    
    public int llegeixInt(){
        return sc.nextInt();
    }
    public String llegeixString(){
        return sc.next();
    }
    public Date llegeixDate(){
        return null;
    }
    
    public void escriu(String s){
        System.out.println(s);
    }
    
    public void escriu(int i){
        System.out.println(i);
    }
    
    public void escriu(float f){
        System.out.println(f);
    }
    
}
