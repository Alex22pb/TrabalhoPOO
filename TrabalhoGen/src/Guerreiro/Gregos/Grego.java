/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Gregos;

import Guerreiro.Guerreiro;

/**
 *
 * @author Usuario
 */
public abstract class Grego extends Guerreiro{
    
    public Grego(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }
    
    
    public void setarEnergia(Guerreiro g){
        if(g.getEnergia()  > 100){
            g.setEnergia(100);
        }
    }
}
