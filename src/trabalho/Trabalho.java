/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho;

import java.io.FileInputStream;
import java.util.Scanner;
import Guerreiro.Guerreiro;

/**
 *
 * @author Usuario
 */
public class Trabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileInputStream fil = new FileInputStream("Guerreiro.txt");
        Scanner scan = new Scanner(fil);
        
        Guerreiro gue1 = new Guerreiro(scan.nextLine());
        Guerreiro gue2 = new Guerreiro();
    }
    
}
