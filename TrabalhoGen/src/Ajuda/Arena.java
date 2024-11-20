/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajuda;

import Guerreiro.Guerreiro;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Arena {
    private static ArrayList<ArrayList<Guerreiro>> ListaAE = new ArrayList<ArrayList<Guerreiro>>();
    private static ArrayList<ArrayList<Guerreiro>> ListaNG = new ArrayList<ArrayList<Guerreiro>>();


    public static ArrayList<ArrayList<Guerreiro>> getListaAE() {
        return ListaAE;
    }

    public static ArrayList<ArrayList<Guerreiro>> getListaNG() {
        return ListaNG;
    }

    public static void iniciarArray() throws IOException{
        LeituraArquivos.lerArquivo(ListaNG, ListaAE, "arquivos/ListasDosGuerreiros.txt");
    }
    
    
    public static void comecarBatalha(){
    
        boolean fimDaPartida = false;
        
        while(!fimDaPartida){
            
            if(Sorteio.realizarSorteio() == 1){
                fimDaPartida = chamarAtaque(ListaNG,ListaAE);
                fimDaPartida = chamarAtaque(ListaAE,ListaNG);
                fimDaPartida = retornarTamanhoVetor(ListaNG,ListaAE);
                if(!fimDaPartida){
                    mudarPosicoes(ListaAE);
                    mudarPosicoes(ListaNG);
                }
            }else{
                fimDaPartida = chamarAtaque(ListaAE,ListaNG);
                fimDaPartida = chamarAtaque(ListaNG,ListaAE);
                fimDaPartida = retornarTamanhoVetor(ListaNG,ListaAE);
                if(!fimDaPartida){
                    mudarPosicoes(ListaAE);
                    mudarPosicoes(ListaNG);
                }
            }
            
        }
    }
         
    public static boolean retornarTamanhoVetor(ArrayList<ArrayList<Guerreiro>> lista1, ArrayList<ArrayList<Guerreiro>> lista2) {
        int contNG = 0;
        int contAE = 0;
        for (int i = 0; i < lista1.size(); i++) {
            if (!lista1.get(i).isEmpty()) {
                contNG++;
            }
        }

        for (int i = 0; i < lista2.size(); i++) {
            if (!lista2.get(i).isEmpty()) {
                contAE++;
            }
        }

        return contAE == 0 || contNG == 0;
    }
        
     public static void mudarPosicoes(ArrayList<ArrayList<Guerreiro>> lista) {//VER SE TA FUNCIONANDO
        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).isEmpty()) {
                Guerreiro g = lista.get(i).get(0);
                if(g.isProvocado()){
                    g.setProvocado(false);
                    g.setIndiceProvocado(-1);
                }
                lista.get(i).add(g);
                lista.get(i).remove(g);
            }
        }
    }
    
    private static boolean chamarAtaque(ArrayList<ArrayList<Guerreiro>> listaATK, ArrayList<ArrayList<Guerreiro>> listaDEF) {

        for (int i = 0; i < listaATK.size(); i++) {
            
            if (!listaATK.get(i).isEmpty()) {
                int posDefensor = i;
                Guerreiro atacante = listaATK.get(i).get(0);
                if (listaDEF.get(posDefensor).isEmpty()) {
                    posDefensor = encontrarDefensor(posDefensor, listaDEF);
                }

                if (posDefensor >= 0 && posDefensor < listaDEF.size()) {
                    atacante.atacar(listaATK, listaDEF, i, posDefensor);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private static int encontrarDefensor(int posDefensor, ArrayList<ArrayList<Guerreiro>> listaDEF) {
        int contAux = posDefensor;
        
        for(int i = 0; i < 2; i++){
           while(contAux < listaDEF.size()){
               if(!listaDEF.get(contAux).isEmpty()){
                   return contAux;
               }
               contAux++;
           }
            contAux = 0;  
        }
        return -1;
    }
}
