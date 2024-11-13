/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainGen;

import Ajuda.Arena;
import static Ajuda.Arena.iniciarArray;
import Ajuda.QuestoesDoTrabalho;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class MainTrab {

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       

        iniciarArray();
        
        // Chamadas para exibir dados de guerreiros, maior peso e guerreiro mais velho
        System.out.println("\n=======| Dados Dos Guerreiros |======\n");
        QuestoesDoTrabalho.exibirDadosGuerreiros(Arena.getListaNG(), Arena.getListaAE());

        double maiorPeso = QuestoesDoTrabalho.somaPesos(Arena.getListaNG(), Arena.getListaAE());
        System.out.println("\n=======| Soma Dos Pesos |======");
        System.out.println("A soma dos pesos de todos os guerreiros e: " + maiorPeso);

        QuestoesDoTrabalho.maisVelho(Arena.getListaNG(), Arena.getListaAE());

        Arena.comecarBatalha();
        System.out.println("\n=============================== | FIM DO JOGO | ===============================");
        QuestoesDoTrabalho.determinarVencedor();
        QuestoesDoTrabalho.ultimoMorreuUltimoAtk();
    }
    
}
