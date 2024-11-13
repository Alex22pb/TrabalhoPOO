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
public class Manticora extends Grego{
    
    public Manticora(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.setEnergia(60);    
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

            defensor.setEnergia(defensor.getEnergia() - 30);

            if (posDef == 0) {
                if (!listaDefesa.get(posDef + 1).isEmpty()) {
                    Guerreiro defensorAdjacente = listaDefesa.get(posDef + 1).get(0);
                    defensorAdjacente.setEnergia(defensorAdjacente.getEnergia() - 15);
                    if (defensorAdjacente.getEnergia() <= 0) {
                        defensorAdjacente.morrer(listaDefesa, posDef + 1);
                    }
                }
            } else if (posDef == listaDefesa.size() - 1) {
                if (!listaDefesa.get(posDef - 1).isEmpty()) {
                    Guerreiro defensorAdjacente = listaDefesa.get(posDef - 1).get(0);
                    defensorAdjacente.setEnergia(defensorAdjacente.getEnergia() - 15);
                    if (defensorAdjacente.getEnergia() <= 0) {
                        defensorAdjacente.morrer(listaDefesa, posDef - 1);
                    }
                }
            } else {
                if (!listaDefesa.get(posDef + 1).isEmpty()) {
                    Guerreiro defensorAdjacente = listaDefesa.get(posDef + 1).get(0);
                    defensorAdjacente.setEnergia(defensorAdjacente.getEnergia() - 15);
                    if (defensorAdjacente.getEnergia() <= 0) {
                        defensorAdjacente.morrer(listaDefesa, posDef + 1);
                    }
                }

                if (!listaDefesa.get(posDef - 1).isEmpty()) {
                    Guerreiro defensorAdjacente = listaDefesa.get(posDef - 1).get(0);
                    defensorAdjacente.setEnergia(defensorAdjacente.getEnergia() - 15);
                    if (defensorAdjacente.getEnergia() <= 0) {
                        defensorAdjacente.morrer(listaDefesa, posDef - 1);
                    }
                }
            }

        }
    }
    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
