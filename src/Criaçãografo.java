import java.util.Scanner;

public class Criaçãografo {
    
    public static void Criando () {
    Scanner sc = new Scanner(System.in);


    //variáveis
    int tipo=0;
    int numeroVertice=0;
   
    System.out.println("Quantos vértices deseja ter? ");
    numeroVertice=sc.nextInt();
    while (numeroVertice<=0) 
    {   System.out.println("Digite um valor acima de 0 ");
        numeroVertice=sc.nextInt();  
    }
    String []nomes = new String[numeroVertice];
    int k=0;
    while (k<numeroVertice) {
        System.out.printf("Digite o nome do %d vértice , ele será associado ao numero %d",k,k);
        nomes[k]=sc.nextLine();
        k++; 
    }

    System.out.println("Que tipo de grafo deseja montar? Digite : 1- Grafo direcionado , 2- Grafo não direcionado ");
    tipo=sc.nextInt(); 
    MatrizAdjCriacao grafo = new MatrizAdjCriacao(numeroVertice);
    
}

    public void formandorelaçoes(int matrizadj[][], int tipo) {

    Scanner sc = new Scanner(System.in);

    System.out.printf("Digite os vértices que tem relação entre si: 1,3/4,5/2,4");
    String arestas = sc.nextLine();
    String[] pares = arestas.split("/");
    int quantidadeAresta = pares.length;
      //variavel 2 
      int origem=0;
      int destino=0;
    //
    for(int i=0;i<quantidadeAresta;i++) 
    {   String[] vertices = pares[i].split(",");
    origem= Integer.parseInt(vertices[0]);
    destino= Integer.parseInt(vertices[1]);
    MatrizAdjCriacao.addArestaMatriz(origem,destino,tipo);
   
}

    }
//excluindo relações 
   
    public static void excluindorelaçoes(int matrizadj[][], int tipo) {

    Scanner sc = new Scanner(System.in);

    System.out.printf("Digite os vértices que tem relação entre si: 1,3/4,5/2,4");
    String arestas = sc.nextLine();
    String[] pares = arestas.split("/");
    int quantidadeAresta = pares.length;
      //variavel 2 
      int origem=0;
      int destino=0;
    //
    for(int i=0;i<quantidadeAresta;i++) 
    {   String[] vertices = pares[i].split(",");
    origem= Integer.parseInt(vertices[0]);
    destino= Integer.parseInt(vertices[1]);
    MatrizAdjCriacao.removerArestaMatriz(origem, destino,tipo);
}

    }
    

    
}




    
