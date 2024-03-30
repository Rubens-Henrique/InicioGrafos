import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //Variáveis
        int controle=0;
        int direção=0;
        
        //Menu Interface 


        Criaçãografo.Criando();
        
        

        

        switch (controle) {


            case(1): { 
                    Criaçãografo.Criando();
                    
            }
            break;

            case(2):  
            
            MatrizAdjCriacao.removerAresta(origem, destino,tipo);
                
            int verifgrafosimples=Operacao.grafosimples(matrizadj);






        }













       

    }
}
