/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Atlantico;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Guerreiro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Prometano extends Atlantico{
    
     public Prometano(String nome, int idade, double peso) {
        super(nome, idade, peso);   
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef){
        if (this.isProvocado()) {
            Guerreiro defensor = listaDefesa.get(this.getIndiceProvocado()).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 10);
            if (defensor.getEnergia() <= 0) {
                defensor.morrer(listaDefesa, this.getIndiceProvocado());
            }
        } else {
            Guerreiro defensor = listaDefesa.get(posDef).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 10);
            if (defensor.getEnergia() <= 0) {
                defensor.morrer(listaDefesa, posDef);
            }
        }       
    }
    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef) {
        ArrayList<Guerreiro> filaDefensor = lista.get(posDef);//VERIFICAR

        int indiceString = this.getNome().length();
        if (this.getNome().charAt(indiceString - 1) == '1' || this.getNome().charAt(indiceString - 1) == '2') {
            Guerreiro filho1 = new Prometano(this.getNome() + ".1", this.getIdade(), this.getPeso());
            Guerreiro filho2 = new Prometano(this.getNome() + ".2", this.getIdade(), this.getPeso());

            String nome = filho1.getNome();
            int quantNumero = 0;

            for (int i = 0; i < nome.length(); i++) {
                char c = nome.charAt(i);
                if (c == '1' || c == '2') {
                    quantNumero++;
                }
            }

            for (int i = 0; i < quantNumero; i++) {
                filho1.setEnergia(filho1.getEnergia() / 2);
                filho2.setEnergia(filho2.getEnergia() / 2);
            }

            if (filho1.getEnergia() > 1) {
                filaDefensor.add(filho1);
                filaDefensor.add(filho2);
                filaDefensor.remove(this);
            }else{
                filaDefensor.remove(this);
            }

        } else {
            Guerreiro filho1 = new Prometano(this.getNome() + " 1", this.getIdade(), this.getPeso());
            Guerreiro filho2 = new Prometano(this.getNome() + " 2", this.getIdade(), this.getPeso());

            filho1.setEnergia(filho1.getEnergia() / 2);
            filho2.setEnergia(filho2.getEnergia() / 2);

            filaDefensor.add(filho1);
            filaDefensor.add(filho2);
            filaDefensor.remove(this);
        }

    }
}
