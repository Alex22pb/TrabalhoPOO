/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public abstract class Guerreiro {

    private String nome;
    private int idade;
    private double peso;
    private int energia;
    private boolean envenenado = false;
    private boolean provocado = false;
    private int indiceProvocado = - 1;

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isProvocado() {
        return provocado;
    }

    public void setProvocado(boolean provocado) {
        this.provocado = provocado;
    }

    public int getIndiceProvocado() {
        return indiceProvocado;
    }

    public void setIndiceProvocado(int indiceProvocado) {
        this.indiceProvocado = indiceProvocado;
    }
    
    
    

    public abstract void atacar(ArrayList<ArrayList<Guerreiro>> listaAtacante, ArrayList<ArrayList<Guerreiro>> listaDefesa, int posAtk, int posDef);
    
    public abstract void morrer(ArrayList<ArrayList<Guerreiro>> lista, int posDef);
    
    public void imprimir() {
        System.out.println("Nome: " +this.getNome() + " Idade: " + this.getIdade() + " Peso: " + this.getPeso());
    }
    
}
