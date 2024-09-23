/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro;

import Guerreiro.Guerreiro;

/**
 *
 * @author Usuario
 */
public class Gregos extends Guerreiro{
    private boolean veneno;

    public boolean isVeneno() {
        return veneno;
    }

    public void setVeneno(boolean veneno) {
        this.veneno = veneno;
    }

    public void danoVeneno(){
        int energiaAtual = getEnergia();
        if(veneno){
            setEnergia(energiaAtual - 5);
        }
    }
    
    
}
