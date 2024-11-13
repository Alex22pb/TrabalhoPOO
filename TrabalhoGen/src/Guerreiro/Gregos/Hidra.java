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
public class Hidra extends Grego{
    
    private int quantCabeças = 0;
    
    public Hidra(String nome, int idade, double peso) {
        super(nome, idade, peso); 
    }

    public int getQuantCabeças() {
        return quantCabeças;
    }

    public void setQuantCabeças(int quantCabeças) {
        this.quantCabeças = quantCabeças;
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

            int danoTotal = 50 + (5 * this.getQuantCabeças());

            defensor.setEnergia(defensor.getEnergia() - danoTotal);

            if (defensor.getEnergia() <= 0) {
                this.setQuantCabeças(this.getQuantCabeças() + 1);
                defensor.morrer(listaDefesa, posDef);
            }

            if (this.getEnergia() < 100) {
                this.setEnergia(this.getEnergia() + 20);
                this.setarEnergia(this);
            }
        }
    }

    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
