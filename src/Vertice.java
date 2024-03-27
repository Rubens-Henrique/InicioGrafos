import java.util.Scanner;

public class Vertice {
    


    Scanner sc = new Scanner(System.in);

    //NOMEAÇÃO DOS VÉRTICES
    public void nome(int numeroVertice)
{ 
 String []nomes = new String[numeroVertice];
    int k=0;
    while (k<numeroVertice) {
    System.out.printf("Digite o nome do %d vértice ",k);
    nomes[k]=sc.nextLine();
    k++;
    }
}


    public void AddAresta(origem,destino,tipo)
    {   if (tipo==1)// tipo nao direcionado 
        { 
            MatrizAdj[origem][destino]=1;
            MatrizAdj[destino][origem]=1; //para grafos não direcionados
     } 
        else { 
            MatrizAdj[origem][destino]=1;  // para grafos direcionados 
        }
    }
    //Remoção de aresta
    public void RemoverAresta(origem,destino,tipo)
    {   if (tipo==1)// tipo nao direcionado 
        { 
            MatrizAdj[origem][destino]=0;
            MatrizAdj[destino][origem]=0; //para grafos não direcionados
     } 
        else { 
            MatrizAdj[origem][destino]=0;  // para grafos direcionados 
        }

    }

    //Identificação de vizinhança  QQQ
    public void Ident(numeroVertice)
{ 
    int controle=0;
         for (int controle=0;Matriz<numerovertice;controle ++) {
               if ( tipo==1 && MatrizAdj[][numerovertice]==1)   // tipo nao direcionado 
    {                    System.out.println(" +origem+ é vizinho de +destino" );
                                             } 
    
                                            }

}







    
}

}




