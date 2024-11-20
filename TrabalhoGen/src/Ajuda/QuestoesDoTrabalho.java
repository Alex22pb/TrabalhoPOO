/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajuda;

import Guerreiro.Gregos.Grego;
import Guerreiro.Guerreiro;
import Guerreiro.Nordico.Nordico;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class QuestoesDoTrabalho {

    private static Guerreiro g_dead;
    private static Guerreiro atacante;

    public static Guerreiro getG_dead() {
        return g_dead;
    }

    public static void setG_dead(Guerreiro g_dead) {
        QuestoesDoTrabalho.g_dead = g_dead;
    }

    public static Guerreiro getAtacante() {
        return atacante;
    }

    public static void setAtacante(Guerreiro atacante) {
        QuestoesDoTrabalho.atacante = atacante;
    }

    public static void morreuMatou(Guerreiro matou, Guerreiro morreu) {
        setG_dead(morreu);
        setAtacante(matou);
    }

    public static void exibirDadosGuerreiros(ArrayList<ArrayList<Guerreiro>> lista) {

        for (ArrayList<Guerreiro> vetor : lista) {
            System.out.println("\nFila " + (lista.indexOf(vetor)+1) + ":");
            for (Guerreiro g : vetor) {
                System.out.println(g.getClass().getSimpleName()+ ": " + g.getNome() + ", " + g.getIdade() + " anos, " + g.getPeso() + " kilos.");
            }
        }
    }

    public static double somaPesos(ArrayList<ArrayList<Guerreiro>> lista) {
        double somaPeso = 0;
        for (ArrayList<Guerreiro> vetor : lista) {
            for (Guerreiro g : vetor) {
                somaPeso += g.getPeso();
            }
        }
        return somaPeso;
    }

    public static Guerreiro percorrer(ArrayList<ArrayList<Guerreiro>> lista, Guerreiro g) {
        Guerreiro maisVelho = g;
        int idadeMaior = maisVelho.getIdade();
        for (ArrayList<Guerreiro> vetor : lista) {
            for (Guerreiro warrior : vetor) {
                if (idadeMaior < warrior.getIdade()) {
                    maisVelho = warrior;
                    idadeMaior = maisVelho.getIdade();
                }
            }
        }
        return maisVelho;
    }

    public static void maisVelho(ArrayList<ArrayList<Guerreiro>> listaNG, ArrayList<ArrayList<Guerreiro>> listaAE) {
        Guerreiro armazenarVelho = null;
        if(!listaNG.get(0).isEmpty()){
            ArrayList<Guerreiro> armazenarLista = listaNG.get(0);
            armazenarVelho = armazenarLista.get(0);
        }else{
            boolean verificar = false;
            int i = 1;
            while(verificar == false){
                if(!listaNG.get(i).isEmpty()){
                    ArrayList<Guerreiro> armazenarLista = listaNG.get(i);
                    armazenarVelho = armazenarLista.get(0);
                    verificar = true;
                }else{
                    i++;
                }
            }
        }

        armazenarVelho = percorrer(listaNG, armazenarVelho);
        armazenarVelho = percorrer(listaAE, armazenarVelho);

        System.out.println("\n=======| Guerreiro Mais Velho |======");
        System.out.println("O " + armazenarVelho.getClass().getSimpleName() + " " + armazenarVelho.getNome() + " é o mais velho com " + armazenarVelho.getIdade() + " anos e " + armazenarVelho.getPeso() + " kilos.");
    }

    public static void ultimoMorreuUltimoAtk() {

        System.out.println("=====| Dados do Ultimo Morto| =====");
        if (g_dead instanceof Grego || g_dead instanceof Nordico) {
            System.out.println("O " + g_dead.getClass().getSimpleName() + " " + g_dead.getNome()
                    + " de " + g_dead.getIdade() + " anos e " + g_dead.getPeso() + " kilos foi o último a ser derrotado no lado dos Gregos e Nórdicos.\n");
        } else {
            System.out.println("O " + g_dead.getClass().getSimpleName() + " " + g_dead.getNome()
                    + " de " + g_dead.getIdade() + " anos e " + g_dead.getPeso() + " kilos foi o último a ser derrotado no lado dos Atlantes e Egípcios.\n");
        }

        System.out.println("=====| Dados do Ultimo A Atacar| =====");
        System.out.println("O " + atacante.getClass().getSimpleName() + " de nome " + atacante.getNome() + " idade " + atacante.getIdade() + " e peso " + atacante.getPeso() + ", deu o ultimo golpe no "
                + g_dead.getClass().getSimpleName() + " " + g_dead.getNome()
                + " de " + g_dead.getIdade() + " anos e " + g_dead.getPeso() + " kilos.");
    }

    public static void determinarVencedor() {
        System.out.println("\n=======| Determinar Vencedor |======");

        if (getAtacante() instanceof Grego || getAtacante() instanceof Nordico) {
            System.out.println("Os vencedores são os Gregos e Nórdicos!\n");
        } else {
            System.out.println("Os vencedores são os Atlánticos e Egípcios!\n");
        }
    }
}
