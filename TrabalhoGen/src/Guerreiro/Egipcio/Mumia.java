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
public class Mumia extends Egipcio{
    
    public Mumia(String nome, int idade, double peso) {
        super(nome, idade, peso);  
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef){
        if (this.isProvocado()) {
            Guerreiro defensor = listaDefesa.get(this.getIndiceProvocado()).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 10);
            if (defensor.getEnergia() <= 0) {
                Guerreiro Zumbi = new MortoVivo(defensor.getNome(), defensor.getIdade(), defensor.getPeso());
                listaAtacante.get(posAtk).add(Zumbi);
                defensor.morrer(listaDefesa, this.getIndiceProvocado());
            }
        } else {
            Guerreiro defensor = listaDefesa.get(posDef).get(0);
            QuestoesDoTrabalho.morreuMatou(this, defensor);
            defensor.setEnergia(defensor.getEnergia() - 10);
            if (defensor.getEnergia() <= 0) {
                Guerreiro Zumbi = new MortoVivo(defensor.getNome(), defensor.getIdade(), defensor.getPeso());
                listaAtacante.get(posAtk).add(Zumbi);
                defensor.morrer(listaDefesa, posDef);
            }
        }
        
    }
    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        for(int i = lista.size()/2; i < lista.size(); i++ ){
           Guerreiro Vingador = new Anubita(this.getNome(),0, 60);
           lista.get(i).add(Vingador);
        }
        lista.get(posDef).remove(this);
    }
}
