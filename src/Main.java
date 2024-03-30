import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
      
        Scanner sc = new Scanner(System.in);

        //Variáveis
        int controle=0;

        int direção=0;
        
        //Menu Interface 


        Criaçãografo.Criando();
        
        System.out.println("O que você deseja fazer ?/n Digite : 1- Fazer operações com os grafos / 2- Sair do programa ");

        controle=sc.nextInt();
        

        switch (controle) {


            case(1): 
                   Operacao.operacoes();
                    
            
            break;

            case(2):  
             System.out.println("Até logo");
             System.exit(0);



        }
            
     
                
    






        }

       

    }

