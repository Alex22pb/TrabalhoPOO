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
public class Anubita extends Egipcio{
     
    public Anubita(String nome, int idade, double peso) {
        super(nome, idade, peso);  
    }
    
    @Override
    public void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef) {
        if (this.isProvocado()) {
            posDef = this.getIndiceProvocado();
            ArrayList<Guerreiro> filaDefensor = listaDefesa.get(posDef);

            Guerreiro defender = filaDefensor.get(0);
            QuestoesDoTrabalho.morreuMatou(this, defender);
            defender.setEnergia(defender.getEnergia() - 15);
            if (defender.getEnergia() <= 0) {
                if (defender instanceof GiganteDePedra) {
                    ((GiganteDePedra) defender).tirarProvocar(listaAtacante, posDef);
                    defender.morrer(listaDefesa, posDef);
                }
            }
            if (!filaDefensor.isEmpty()) {
                Guerreiro ultimoDefensor = filaDefensor.get(filaDefensor.size() - 1);
                QuestoesDoTrabalho.morreuMatou(this, ultimoDefensor);
                ultimoDefensor.setEnergia(ultimoDefensor.getEnergia() - 15);
                if (ultimoDefensor.getEnergia() <= 0) {
                    if (ultimoDefensor instanceof GiganteDePedra) {
                        ((GiganteDePedra) ultimoDefensor).tirarProvocar(listaAtacante, posDef);
                        ultimoDefensor.morrer(listaDefesa, posDef);
                    } else {
                        ultimoDefensor.morrer(listaDefesa, posDef);
                    }
                }
            }
        } else {
            ArrayList<Guerreiro> filaDefensor = listaDefesa.get(posDef);

            Guerreiro defender = filaDefensor.get(0);
            QuestoesDoTrabalho.morreuMatou(this, defender);
            defender.setEnergia(defender.getEnergia() - 15);
            if (defender.getEnergia() <= 0) {
                defender.morrer(listaDefesa, posDef);
            }
            if (!filaDefensor.isEmpty()) {
                Guerreiro ultimoDefensor = filaDefensor.get(filaDefensor.size() - 1);
                QuestoesDoTrabalho.morreuMatou(this, ultimoDefensor);
                ultimoDefensor.setEnergia(ultimoDefensor.getEnergia() - 15);
                if (ultimoDefensor.getEnergia() <= 0) {
                    ultimoDefensor.morrer(listaDefesa, posDef);
                }
            }
        }
    }

    @Override
    public void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef){
        lista.get(posDef).remove(this);
    }
}
