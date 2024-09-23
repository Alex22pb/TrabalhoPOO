/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiro;

/**
 *
 * @author Usuario
 */
public class Guerreiro {
    String nome;
    int idade;
    double peso;
    double energia;

    public Guerreiro(String nome, int idade, double peso, double energia) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = energia;
    }

    public Guerreiro(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
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

    public double getEnergia() {
        return energia;
    }
    
    public void matar(){
        if(getEnergia() <= 0){
            
        }
        
    }
    
}
