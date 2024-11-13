/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Nordico;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Guerreiro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class LoboFenris extends Nordico{
    
    public LoboFenris(String nome, int idade, double peso) {
        super(nome, idade, peso);    
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef){
        if (this.isEnvenenado()) {
            this.setEnergia(this.getEnergia() - 5);
        }
        
        if (this.getEnergia() <= 0) {
            this.morrer(listaAtacante, posAtk);
        } else {
            Guerreiro defensor = listaDefesa.get(posDef).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);

            ArrayList<Guerreiro> filaAtacante = listaAtacante.get(posAtk);
            int danoBase = 40;

            for (int i = 0; i < filaAtacante.size(); i++) {
                if (filaAtacante.get(i) instanceof LoboFenris) {
                    danoBase += 8;
                }
            }

            defensor.setEnergia(defensor.getEnergia() - danoBase);
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
