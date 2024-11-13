/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro.Nordico;

import Ajuda.QuestoesDoTrabalho;
import Guerreiro.Gregos.Grego;
import Guerreiro.Guerreiro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Valquiria extends Nordico{
    
    public Valquiria(String nome, int idade, double peso) {
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

            defensor.setEnergia(defensor.getEnergia() - 20);

            ArrayList<Guerreiro> filaAtacante = listaAtacante.get(posAtk);

            if ( filaAtacante.size() > 1 && filaAtacante.get(1) != null) {
                Guerreiro curarGuerreiro = filaAtacante.get(1);
                curarGuerreiro.setEnergia(curarGuerreiro.getEnergia() + 20);
                if(curarGuerreiro instanceof Grego){
                    ((Grego) curarGuerreiro).setarEnergia(curarGuerreiro);
                }
            }
        }
    }

    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
