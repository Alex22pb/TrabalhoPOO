/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajuda;

import Guerreiro.Atlantico.Argus;
import Guerreiro.Atlantico.Prometano;
import Guerreiro.Atlantico.Satiro;
import Guerreiro.Egipcio.Anubita;
import Guerreiro.Egipcio.HomemEscorpiao;
import Guerreiro.Egipcio.Mumia;
import Guerreiro.Gregos.Ciclope;
import Guerreiro.Gregos.Hidra;
import Guerreiro.Gregos.Manticora;
import Guerreiro.Guerreiro;
import Guerreiro.Nordico.GiganteDePedra;
import Guerreiro.Nordico.LoboFenris;
import Guerreiro.Nordico.Valquiria;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class LeituraArquivos {

//    private static ArrayList<Guerreiro> ListaGuerreiro;
//
//    public LeituraArquivos(ArrayList<Guerreiro> lista) {
//        this.ListaGuerreiro = lista;
//    }
//    
//    public static ArrayList<Guerreiro> getListaGuerreiro() {
//        return ListaGuerreiro;
//    }

    public static void lerArquivo(ArrayList<ArrayList<Guerreiro>> ListaNG, ArrayList<ArrayList<Guerreiro>> ListaAE, String nomeArquivo) throws IOException {
        try {
            FileInputStream arq = new FileInputStream(nomeArquivo);
            Scanner scan = new Scanner(arq);

            String name;
            int indice = 0;

            while (scan.hasNext()) {
                name = scan.next();

                indice = name.indexOf("Grego", indice);

                if (indice != -1) {
                    lerArquivoNG(name, ListaNG);
                } else {
                    lerArquivoAE(name, ListaAE);
                }
            }
            scan.close();
            arq.close();
        } catch (FileNotFoundException erro) {
            System.out.println("Erro na abertura do arquivo");
        }
    }

    public static void lerArquivoNG(String nomeNG, ArrayList<ArrayList<Guerreiro>> Lista) throws IOException {
        try {
            FileInputStream arqFila = new FileInputStream(nomeNG);
            Scanner scanFila = new Scanner(arqFila);

            String filasArq;

            while (scanFila.hasNext()) {
                filasArq = scanFila.next();
                
                ArrayList<Guerreiro> ListaGuerreiro = new ArrayList<Guerreiro>();
                
                FileInputStream arqGuerreiro = new FileInputStream(filasArq);
                Scanner scanGuerreiro = new Scanner(arqGuerreiro);

                int idade, lado;
                String nome;
                double peso;

                while (scanGuerreiro.hasNext()) {
                    lado = scanGuerreiro.nextInt();
                    nome = scanGuerreiro.next();
                    idade = scanGuerreiro.nextInt();
                    peso = scanGuerreiro.nextDouble();

                    Guerreiro g = null;

                    switch (lado) {
                        case 1 ->
                            g = new Ciclope(nome, idade, peso);
                        case 2 ->
                            g = new Manticora(nome, idade, peso);
                        case 3 ->
                            g = new Hidra(nome, idade, peso);
                        case 4 ->
                            g = new Valquiria(nome, idade, peso);
                        case 5 ->
                            g = new LoboFenris(nome, idade, peso);
                        case 6 ->
                            g = new GiganteDePedra(nome, idade, peso);
                    }
                    ListaGuerreiro.add(g);
                }

                Lista.add(ListaGuerreiro);
                scanGuerreiro.close();
                arqGuerreiro.close();
            }
            scanFila.close();
            arqFila.close();
        } catch (FileNotFoundException erro) {
            System.out.println("Erro na abertura do arquivo");
        }
    }

    public static void lerArquivoAE(String nomeAE, ArrayList<ArrayList<Guerreiro>> Lista) throws IOException {
        try {
            FileInputStream arqFila = new FileInputStream(nomeAE);
            Scanner scanFila = new Scanner(arqFila);

            String filasArq;

            while (scanFila.hasNext()) {
                filasArq = scanFila.next();

                ArrayList<Guerreiro> ListaGuerreiro = new ArrayList<Guerreiro>();
                
                FileInputStream arqGuerreiro = new FileInputStream(filasArq);
                Scanner scanGuerreiro = new Scanner(arqGuerreiro);

                int idade, lado;
                String nome;
                double peso;

                while (scanGuerreiro.hasNext()) {
                    lado = scanGuerreiro.nextInt();
                    nome = scanGuerreiro.next();
                    peso = scanGuerreiro.nextDouble();
                    idade = scanGuerreiro.nextInt();

                    Guerreiro g = null;

                    switch (lado) {
                        case 1 ->
                            g = new Prometano (nome, idade, peso);
                        case 2 ->
                            g = new Satiro (nome, idade, peso);
                        case 3 ->
                            g = new Argus (nome, idade, peso);
                        case 4 ->
                            g = new Anubita (nome, idade, peso);
                        case 5 ->
                            g = new HomemEscorpiao (nome, idade, peso);
                        case 6 ->
                            g = new Mumia (nome, idade, peso);
                    }
                    ListaGuerreiro.add(g);
                }
                Lista.add(ListaGuerreiro);
                scanGuerreiro.close();
                arqGuerreiro.close();
            }
            scanFila.close();
            arqFila.close();
        } catch (FileNotFoundException erro) {
            System.out.println("Erro na abertura do arquivo");
        }
    }
}
