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

    public static void exibirDadosGuerreiros(ArrayList<ArrayList<Guerreiro>> listaNG, ArrayList<ArrayList<Guerreiro>> listaAE) {

        System.out.println("============= Guerreiros Gregos e Nórdicos =============\n");

        for (ArrayList<Guerreiro> vetor : listaNG) {
            for (Guerreiro g : vetor) {
                System.out.println("Nome: " + g.getClass().getSimpleName()+ " " + g.getNome() + " Idade: " + g.getIdade() + " Peso: " + g.getPeso() + " Energia: " + g.getEnergia());
            }
        }

        System.out.println("\n============= Guerreiros Atlanticos e Egípcios =============\n");

        for (ArrayList<Guerreiro> vetor : listaAE) {
            for (Guerreiro g : vetor) {
                System.out.println("Nome: " + g.getClass().getSimpleName() + " " + g.getNome() + " Idade: " + g.getIdade() + " Peso: " + g.getPeso() + " Energia: " + g.getEnergia());
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

    public static Guerreiro percorrer(ArrayList<ArrayList<Guerreiro>> listaNG, ArrayList<ArrayList<Guerreiro>> listaAE, Guerreiro g) {
        Guerreiro maisVelho = g;
        int idadeMaior = maisVelho.getIdade();
        for (ArrayList<Guerreiro> vetor : listaNG) {
            for (Guerreiro warrior : vetor) {
                if (idadeMaior < warrior.getIdade()) {
                    maisVelho = warrior;
                    idadeMaior = maisVelho.getIdade();
                }
            }
        }

        for (ArrayList<Guerreiro> vetor : listaAE) {
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
        ArrayList<Guerreiro> armazenarLista = listaNG.get(0);
        Guerreiro armazenarVelho = armazenarLista.get(0);

        armazenarVelho = percorrer(listaNG, listaAE, armazenarVelho);

        System.out.println("\n=======| Guerreiro Mais Velho |======");
        System.out.println("Nome: " + armazenarVelho.getClass().getSimpleName() + " " + armazenarVelho.getNome() + " Idade: " + armazenarVelho.getIdade() + " Peso: " + armazenarVelho.getPeso() + " Energia: " + armazenarVelho.getEnergia());

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
                + " de " + g_dead.getIdade() + " anos e " + g_dead.getPeso());
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
