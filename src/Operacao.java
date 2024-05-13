import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Operacao { 

    public static void operacoes()
    {   
        Scanner sc = new Scanner(System.in);
        int controle2=0;
        int vertice=0;
        String r = "s";
        while (r.equalsIgnoreCase("s")) {
            System.out.println("Qual operação deseja realizar ? \n(1) Criar mais arestas \n(2) Remover arestas \n(3) Vizinhança Vertice (Grafos não direcionados) \n(4) Identificação dos sucessores e predecessores (Grafos direcionados)\n(5) Identificação do grau de algum vértice \n(6) Testar se o grafo é simples \n(7) Testar se o grafo é completo \n(8) Testar se o grafo é regular  \n(9) Testar se o grafo é bipartido \n(10) Imprimir a matriz de adjacencia " + //
                        "\n(11) Realizar a busca em largura  \n(12) Ordenação Topologica   \n(13) Verificar se o grafo é conexo  \n(14) Busca em profundidade  \n(15) AGM  \n(16) Caminho mínimo entre dois vértices");
            controle2=sc.nextInt();
            switch (controle2) {
                case 1:
                    Criaçãografo.formandorelaçoes();
                    break; 

                case 2:
                    Criaçãografo.excluindorelaçoes();
                    break;
            

                case 3:
                    int resposta = 1;
                    while (resposta == 1) { // Ignora a diferença entre maiúsculas e minúsculas
                        System.out.println("Qual o número do vértice que você deseja conhecer a vizinhança? ");
                        vertice = sc.nextInt();
                        System.out.println("Vizinhos do vértice " + vertice + ": " +  ListaAdjacencia.obterVizinhosReais(vertice-1));
                        System.out.println("Escolha o que deseja realizar: \n(1)Conhecer a vizinhança de outro vértice \n(2) Voltar ao menu de operações");
                        resposta = sc.nextInt();
                    }
                    break;
                    
                case 4: 
                    resposta = 1;
                    while (resposta == 1) 
                    { // Ignora a diferença entre maiúsculas e minúsculas
                        System.out.println("Qual o número do vértice que você deseja conhecer os predecessores e sucessores?  ");
                        vertice = sc.nextInt();
                        System.out.println("Sucessores do vértice " + vertice + ": " +   ListaAdjacencia.obterSucessoresReais(vertice-1));
                        System.out.println("Predecessores do vértice " + vertice + ": " +  ListaAdjacencia.obterPredecessoresReais(vertice-1));
                        System.out.println("Escolha o que deseja realizar: \n(1)Conhecer os predecessores e sucessores de outro vértice \n(2) Voltar ao menu de operações");
                        resposta = sc.nextInt();
                    }
                break;

                case 5: 
                    resposta = 1;
                    while (resposta == 1) 
                    { // Ignora a diferença entre maiúsculas e minúsculas
                        System.out.println("Qual vértice você deseja conhecer o grau  ?");
                        vertice = sc.nextInt();
                        System.out.println("Grau do vérice " + vertice + ": " +   ListaAdjacencia.obterGrauVertice(vertice-1));
                        System.out.println("Escolha o que deseja realizar: \n(1)Conhecer o grau de outro vértice \n(2) Voltar ao menu de operações");
                        resposta = sc.nextInt();
                    }
                    break;

                case 6: 
                boolean verifgrafosimples=MatrizAdjCriacao.grafoSimples();
                if(!verifgrafosimples)
                {    System.out.println("Não é um grafo simples");

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
                {    System.out.println("Não é um grafo regular");

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
                
                case 11: 
                
                    System.out.println("Escolha o vértice Inicial que será realizada a busca:");
                    int y=sc.nextInt();
                    MatrizAdjCriacao.BuscaLargura(y-1);

                    break;

                case 12: 

                    MatrizAdjCriacao.OrdenaTop();
                    break;

                case 13:
                    MatrizAdjCriacao.conexo();
                    break;

                case 14:
                    System.out.print("Escolha o vértice Inicial que será realizada a busca: ");
                    vertice = sc.nextInt();
                    ListaAdjacencia.buscaProfundidade(vertice-1);
                    break;

                case 15:
                    ListaAdjacencia.primAlgoritmo();
                    break;

                case 16:
                    System.out.print("Digite o vértice de origem: ");
                    int origem = sc.nextInt();
            
                    System.out.print("Digite o vértice de destino: ");
                    int destino = sc.nextInt();
            
                    // Encontrar o caminho mínimo entre os vértices de origem e destino
                    CaminhoMinimo.dijkstra(origem-1, destino-1);
            
                    break;
                }

      do {  System.out.println("Deseja realizar mais operações? Digite 's' ou 'n'");
                r = sc.next().toLowerCase();
    
                if (!r.equals("s") && !r.equals("n")) {
                    System.out.println("Resposta inválida. Por favor, digite 's' para sim ou 'n' para não.");
                }
            } while (!r.equals("s") && !r.equals("n"));

            }
        }

     }
  
