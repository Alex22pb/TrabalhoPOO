/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Egipcio;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Guerreiro;
import Guerreiro.Nordico.GiganteDePedra;
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
            posDef = this.getIndiceProvocado();
            Guerreiro defensor = listaDefesa.get(posDef).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 5);
            if (defensor.getEnergia() <= 0) {
                 if (defensor instanceof GiganteDePedra) {
                    ((GiganteDePedra) defensor).tirarProvocar(listaAtacante, posDef);
                    defensor.morrer(listaDefesa, posDef);
                }
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
