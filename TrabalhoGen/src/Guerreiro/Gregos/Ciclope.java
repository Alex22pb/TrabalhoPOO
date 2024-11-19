/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Gregos;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Guerreiro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Ciclope extends Grego{
    
    public Ciclope(String nome, int idade, double peso) {
        super(nome, idade, peso);    
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef) {

        if (this.isEnvenenado()) {
            this.setEnergia(this.getEnergia() - 5);
        }

        if (this.getEnergia() <= 0) {
            this.morrer(listaAtacante, posAtk);
        } else {
            Guerreiro defensor = listaDefesa.get(posDef).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            ArrayList<Guerreiro> filaDefensor = listaDefesa.get(posDef);
            defensor.setEnergia(defensor.getEnergia() - 35);

            if(defensor.isProvocado()){
                defensor.setIndiceProvocado(-1);
                defensor.setProvocado(false);
            }
            
            if (defensor.getEnergia() <= 0) {
                defensor.morrer(listaDefesa, posDef);
            } else {
                filaDefensor.remove(defensor);
                filaDefensor.add(defensor);
            }
        }
    }

    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
