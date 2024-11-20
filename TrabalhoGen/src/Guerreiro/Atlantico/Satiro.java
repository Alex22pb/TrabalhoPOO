/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Atlantico;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Guerreiro;
import Guerreiro.Nordico.GiganteDePedra;
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
        if (this.isProvocado()) {
            posDef = this.getIndiceProvocado();
        }
        ArrayList<Guerreiro> filaDefensor = listaDefesa.get(posDef);
        for (int i = 0; i < filaDefensor.size(); i++) {
            Guerreiro g = filaDefensor.get(i);
            QuestoesDoTrabalho.morreuMatou(this, g);
            g.setEnergia(g.getEnergia() - 10);
            if (g.getEnergia() <= 0) {
                if (g instanceof GiganteDePedra && this.isProvocado() && i == 0) {
                    ((GiganteDePedra) g).tirarProvocar(listaAtacante, posDef);
                    g.morrer(listaDefesa, posDef);
                } else {
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
