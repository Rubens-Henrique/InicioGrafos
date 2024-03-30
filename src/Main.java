import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //Variáveis
        int controle=0;
        int direção=0;
        
        //Menu Interface 


        
        System.out.println("Ola, o que deseja fazer?\n"+ "1- Criar um Grafo \n " + "2- Testar as propriedades de um grafo");
        controle=sc.nextInt();

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
