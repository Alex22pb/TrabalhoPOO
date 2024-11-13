/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Egipcio;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Guerreiro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MortoVivo extends Egipcio{
    
    public MortoVivo(String nome, int idade, double peso) {
        super(nome, idade, peso);  
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef){
        if (this.isProvocado()) {
            Guerreiro defensor = listaDefesa.get(this.getIndiceProvocado()).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 5);
            if (defensor.getEnergia() <= 0) {
                defensor.morrer(listaDefesa, this.getIndiceProvocado());
            }
        } else {
            Guerreiro defensor = listaDefesa.get(posDef).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 5);
            if (defensor.getEnergia() <= 0) {
                defensor.morrer(listaDefesa, posDef);
            }
        }
    }
    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
