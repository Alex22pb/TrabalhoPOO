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
        System.out.println("============= Guerreiros Gregos e Nórdicos =============");
        QuestoesDoTrabalho.exibirDadosGuerreiros(Arena.getListaNG());
        System.out.println("\n============= Guerreiros Atlanticos e Egípcios =============");
        QuestoesDoTrabalho.exibirDadosGuerreiros(Arena.getListaAE());

        double maiorPesoNG = QuestoesDoTrabalho.somaPesos(Arena.getListaNG());
        System.out.println("\n=======| Soma Dos Pesos Dos Gregos e Nórdicos |======");
        System.out.println("A soma dos pesos de todos os guerreiros e: " + maiorPesoNG);
        
        double maiorPesoAE = QuestoesDoTrabalho.somaPesos(Arena.getListaAE());
        System.out.println("\n=======| Soma Dos Pesos Dos Atlánticos e Egipcios|======");
        System.out.println("A soma dos pesos de todos os guerreiros e: " + maiorPesoAE);

        QuestoesDoTrabalho.maisVelho(Arena.getListaNG(), Arena.getListaAE());

        Arena.comecarBatalha();
        System.out.println("\n=============================== | FIM DO JOGO | ===============================");
        QuestoesDoTrabalho.determinarVencedor();
        QuestoesDoTrabalho.ultimoMorreuUltimoAtk();
    }
    
}
