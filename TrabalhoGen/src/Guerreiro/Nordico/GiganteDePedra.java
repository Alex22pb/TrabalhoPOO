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
public class GiganteDePedra extends Nordico{
   
    public GiganteDePedra(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.setEnergia(300);
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

            defensor.setEnergia(defensor.getEnergia() - 30);

            for (int i = 0; i < listaDefesa.size(); i++) {
                if (!listaDefesa.get(i).isEmpty()) {
                    defensor = listaDefesa.get(i).get(0);
                    defensor.setProvocado(true);
                    defensor.setIndiceProvocado(posAtk);
                }
            }
        }
    }
    
    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
    
    public void tirarProvocar(ArrayList<ArrayList<Guerreiro>> lista, int posicaoProvocado){
        for(int i = 0; i < lista.size();i++){
            if(!lista.get(i).isEmpty()){
                Guerreiro g = lista.get(i).get(0);
                if(g.isProvocado() && g.getIndiceProvocado() == posicaoProvocado){
                    g.setProvocado(false);
                    g.setIndiceProvocado(-1);
                }
            }
        }
    }
}
