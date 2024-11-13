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
public class Satiro extends Atlantico{
    
     public Satiro(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef) {
        if (this.isProvocado()){
            ArrayList<Guerreiro> filaDefensor = listaDefesa.get(this.getIndiceProvocado());
            for (int i = 0; i < filaDefensor.size(); i++) {
                Guerreiro g = filaDefensor.get(i);
                QuestoesDoTrabalho.morreuMatou(this, g);
                g.setEnergia(g.getEnergia() - 10);
                if (g.getEnergia() <= 0) {
                    g.morrer(listaDefesa, listaDefesa.indexOf(filaDefensor));
                }
            }
        } else {
            ArrayList<Guerreiro> filaDefensor = listaDefesa.get(posDef);

            for (int i = 0; i < filaDefensor.size(); i++) {
                Guerreiro g = filaDefensor.get(i);
                QuestoesDoTrabalho.morreuMatou(this, g);
                g.setEnergia(g.getEnergia() - 10);
                if (g.getEnergia() <= 0) {
                    g.morrer(listaDefesa, posDef);
                }
            }
        }
    }
    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
