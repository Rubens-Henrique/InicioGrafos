import java.util.Scanner;


public class Operacao {
    
  
//Lapidar : Posição da lista. 
//Lapidar : Deseja continuar duplo na vizinhança 
    public static void operacoes()
 
    {   
        Scanner sc = new Scanner(System.in);
        int controle2=0;
        int vertice=0;
        String r = "s";
        while (r.equalsIgnoreCase("s")) {
        System.out.println("Qual operação deseja realizar ?  1-Criar mais arestas 2- Remover arestas 3- Vizinhança Vertice (Grafos não direcionados) 4-Identificação dos sucessores e predecessores 5-Identificação do Grau de algum vértice 6- Testar se o grafo é simples 7- Testar se é completo 8- Testar se é regular  9 Testar se é bipartido 10-Imprimir a matriz  ");
        controle2=sc.nextInt();
        switch (controle2) {
            case 1:
                Criaçãografo.formandorelaçoes();
                break; 

            case 2:
                Criaçãografo.excluindorelaçoes();
                break;
        

            case 3:
                String resposta = "s";
                while (resposta.equalsIgnoreCase("s")) { // Ignora a diferença entre maiúsculas e minúsculas
                    System.out.println("Qual o número do vértice que você deseja conhecer a vizinhança? Considere que a lista começa do 0");
                    vertice = sc.nextInt();
                    System.out.println("Vizinhos do vértice " + vertice + ": " +  ListaAdjacencia.obterVizinhos(vertice-1));
                    System.out.println("Deseja continuar? Digite 's' ou 'n'");
                    resposta = sc.next().toLowerCase(); // Converte a resposta para minúsculas
                }
                break;
                
            case 4: 
                resposta = "s";
                while (resposta.equalsIgnoreCase("s")) 
                { // Ignora a diferença entre maiúsculas e minúsculas
                    System.out.println("Qual o número do vértice que você deseja conhecer  os predecessores e sucessores? Considere que a lista começa no 0; ");
                    vertice = sc.nextInt();
                    System.out.println("Sucessores do vértice " + vertice + ": " +   ListaAdjacencia.obterSucessores(vertice-1));
                    System.out.println("Predecessores do vértice " + vertice + ": " +  ListaAdjacencia.obterPredecessores(vertice-1));
                    System.out.println("Deseja continuar? Digite 's' ou 'n'");
                    resposta = sc.next().toLowerCase(); // Converte a resposta para minúsculas
                }
               break;

            case 5: 
                resposta = "s";
                while (resposta.equalsIgnoreCase("s")) 
                { // Ignora a diferença entre maiúsculas e minúsculas
                    System.out.println("Qual vértice você deseja conhecer o grau  ?");
                    vertice = sc.nextInt();
                    ListaAdjacencia.obterGrauVertice(vertice);
                    System.out.println("Deseja continuar? Digite 's' ou 'n'");
                    resposta = sc.next().toLowerCase(); // Converte a resposta para minúsculas
                }
            break;

            case 6: 
               boolean verifgrafosimples=MatrizAdjCriacao.grafoSimples();
               if(!verifgrafosimples)
               { System.out.println("Não é um grafo simples");

               } else {  System.out.println("É  um grafo simples");

               }
                break;

            case 7:
                MatrizAdjCriacao.grafoCompleto();
               break;

            case 8:
               ListaAdjacencia.regular();
               boolean verifgrafoRegular=ListaAdjacencia.regular();
               if(!verifgrafoRegular)
               { System.out.println("Não é um grafo regular");

               } else {  System.out.println("É  um grafo regular");

               }
                break;
            case 9: 
                boolean verifGrafosBipartidos = ListaAdjacencia.ehBipartido();
                if(!verifGrafosBipartidos)
                { System.out.println("O grafo é bipartido");

                } else {  System.out.println("O grafo não é bipartido");

                }
            
                break;

            case 10: 
               MatrizAdjCriacao.imprime();

                    break; 

            }
            System.out.println("Deseja continuar? Digite 's' ou 'n'");
            r = sc.next().toLowerCase(); // Conver
        }
    

        
    









     }
  

  


}


