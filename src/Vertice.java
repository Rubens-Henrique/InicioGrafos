import java.util.Scanner;

public class Vertice {
    
    Scanner sc = new Scanner(System.in);

    //NOMEAÇÃO DOS VÉRTICES
    public void nome(int numeroVertice)
    { 
        String []nomes = new String[numeroVertice];
        int k=0;
        while (k<numeroVertice) {
            System.out.printf("Digite o nome do %d vértice , ele será associado ao numero %d",k,k);
            nomes[k]=sc.nextLine();
            k++;
        }
    }

    public void associação(String nomes[],int matrizadj[][] ) { 


    }   


    //Identificação de vizinhança  QQQ
    public void Ident( int numeroVertice, int tipo)
    { 
        int controle=0;
        for (controle=0;MatrizAdj<numeroVertice;controle ++) {
            if ( tipo==1 && MatrizAdj[][numeroVertice]==1)   // tipo nao direcionado 
            {   System.out.println(" +origem+ é vizinho de +destino" );
            } 
    
        }

    }







    
}




