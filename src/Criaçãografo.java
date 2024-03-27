import java.util.Scanner;

public static void Criaçãografo() {
    
    Scanner sc = new Scanner(System.in);


    //variáveis
    int tipo=0;
    int numeroVertice=0;

    System.out.println("Quantos vértices deseja ter? ");
    numerovertice=sc.nextInt();
    while (numerovertice<=0) 
    {   System.out.println("Digite um valor acima de 0 ");
        numeroVertice=sc.nextInt();  
    }
    System.out.println("Que tipo de grafo deseja montar? Digite : 1- Grafo direcionado , 2- Grafo não direcionado ");
    tipo=sc.nextInt();

    System.out.print("Digite os vértices que tem relação entre si , exemplo : 1,2/ 3,4 /2,4");
    int origem =sc.nextInt();
    int destino =sc.nextInt();



    MatrizAdjCriacao(numeroVertice);
    NomeVertice(numeroVertice);
    AddAresta(origem,destino);


    





    
}
