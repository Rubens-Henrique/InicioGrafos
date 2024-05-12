import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class MatrizAdjCriacao {
    
    private static int[][] matrizadj;
    private static boolean ehDirecionado;
    private static int numeroVertice;
    // Construtor da classe para inicializar a matriz

    public MatrizAdjCriacao(int numeroVertice,int tipo) {
        matrizadj = new int[numeroVertice][numeroVertice];
        ehDirecionado = (tipo == 1);
        this.numeroVertice = numeroVertice;

        // Inicializa a matriz com zeros
        for (int i = 0; i < numeroVertice; i++) {
            for (int j = 0; j < numeroVertice; j++) {
                matrizadj[i][j] = 0;
            }
        }
    }
   public boolean ehDirecionado() {
        return ehDirecionado;
    }
    public static int obterNumVertices() {
        return numeroVertice;
    }
    

    // Adiciona uma aresta à matriz de adjacência
    public static void addArestaMatriz(int origem, int destino, int peso) {

        if ( !ehDirecionado) {
            matrizadj[origem][destino] = peso;
            matrizadj[destino][origem] = peso; // para grafos não direcionados
        } else {
            matrizadj[origem][destino] = peso; // para grafos direcionados 
        }
    }

    // Remove uma aresta da matriz de adjacência
    public static void removerArestaMatriz(int origem, int destino) {
        if (!ehDirecionado)  {
            matrizadj[origem][destino] = 0;
            matrizadj[destino][origem] = 0; // para grafos não direcionados
        } else {
            matrizadj[origem][destino] = 0; // para grafos direcionados 
        }
    }


    public static boolean grafoSimples() 
    { int numeroVertice = matrizadj.length;
        for (int i=0;i<numeroVertice ;i++)
        {   for (int j=0;j<numeroVertice ;j++)
            if (matrizadj[i][j]>1 || (i==j && matrizadj[i][i]==1))
                {  return false; } 
        } 
        return true; // Grafo é simples


    }

    public static void grafoCompleto() {
        boolean verifica = grafoSimples();
        if (verifica) {
            boolean completo = true;
            for (int i = 0; i < matrizadj.length; i++) {
                for (int j = 0; j < matrizadj[i].length; j++) {
                    if (i != j && matrizadj[i][j] != 1) {
                        completo = false;
                        break;
                    }
                }
                if (!completo) {
                    break;
                }
            }
            if (completo) {
                System.out.println("É um grafo completo");
            } else {
                System.out.println("Não é um grafo completo");
            }
        } else {
            System.out.println("Não é um grafo completo"); // Se o grafo não for simples, não pode ser completo
        }
    }

    // Imprime a matriz
    public static void imprime() {
        Scanner sc = new Scanner(System.in);
    
        int numeroVertice = obterNumVertices(); // Correção aqui
        String[] nomes = new String[numeroVertice];
        int k = 0;
        while (k < numeroVertice) {
            System.out.printf("Digite o nome do %d vértice, ele será associado ao numero %d: ", k+1, k+1);
            nomes[k] = sc.nextLine();
            k++;
        }
    
        System.out.print("      ");
        for (String nome : nomes) {
            System.out.printf("%-7s", nome);
        }
        System.out.println();
    
        for (int i = 0; i < numeroVertice; i++) {
            System.out.printf("%-7s", nomes[i]);
            for (int j = 0; j < numeroVertice; j++) {
                System.out.printf("%-7d", matrizadj[i][j]);
            }
            System.out.println();
        }

    } 


    //Ordenação Topológica

    public static void OrdenaTop()
    {
        int V= matrizadj.length;
        int[] grauentrada = new int[V]; //Grau de entrada  do vértice 
    

        Queue<Integer> fila0 = new LinkedList<>(); //fila do grau de entrada 0
        Queue<Integer> filaoodenacao = new LinkedList<>(); 

        if (!ehDirecionado) //Verifica se o grafo é direcionado 
        {   System.out.println("Erro. O grafo é não direcionado !");
            return ;
            }
            else {   
        // Calcula o grau de entrada de cada vértice somando todas as adjacencias que ENTRAM 
         for (int i = 0; i < V; i++) {
             for (int j = 0; j < V; j++) {
                grauentrada[j] += matrizadj[i][j];
                    }
                }

        //ADICIONANDO os vertices de entrada 0 no inicio da fila
        for (int i=0;i<V;i++)
        {   if(grauentrada[i]==0)
            {    fila0.add(i);
            }

        } 
        while(!fila0.isEmpty())
        {  
            int x= fila0.poll();
            filaoodenacao.add(x);

              // Atualiza os graus de entrada ( tira 1 a cada busca)
              for (int i = 0; i < V; i++) {
                if (matrizadj[x][i] == 1) {
                    if (--grauentrada[i] == 0) {
                        fila0.add(i);}    }
                  
                    }
        }
            // Verifica se o grafo possui um ciclo
            if (filaoodenacao.size() != V ) {
                System.out.println("Erro. O grafo possui um ciclo !");
                return;
            }
    

            // Imprime a ordem topológica
            System.out.println("Ordem Topológica:");
            for (int i : filaoodenacao)
                System.out.print(i + " ");
    }

        
    }



    //busca em largura 
    public static int BuscaLargura(int VerticeIniccio) {

        int V= matrizadj.length;
        boolean[] visitados = new boolean[V];
        Queue<Integer> fila = new LinkedList<>();
        fila.add(VerticeIniccio);
        
          
        int busca=0;
        for (int Todosvertices=0; Todosvertices<V; Todosvertices++)
        {  
            
            if(!visitados[Todosvertices]) 
        {   busca++;
            fila.clear(); // Limpa a fila para uma nova busca em largura
            fila.add(Todosvertices); // Adiciona o vértice inicial à fila
            visitados[Todosvertices] = true; // Marca o vértice inicial como visitado
    
            System.out.printf("Busca n%d  :  ",busca);
             while (!fila.isEmpty()) {
            int vis = fila.poll();
    
            // Imprime o nó atual

            System.out.print(vis+1 + " ");
            
            // Para cada vértice adjacente ao vértice atual
            for (int i = 0; i < V; i++) {
                if (matrizadj[vis][i] == 1 && !visitados[i]) {
                    // Adiciona o vértice adjacente à fila
                    fila.add(i);
                    // Marca o vértice adjacente como visitado
                    visitados[i] = true;
                }
            } 
        }
        System.out.println();
        }
    }
        return busca;
}


public static void conexo() {
    int VerticeInicio = 0; // Defina o vértice inicial para a busca em largura
    int controle = BuscaLargura(VerticeInicio); // Chama a função BuscaLargura e atribui seu retorno à variável controle
    if (controle > 1) {
        System.out.println("O grafo é desconexo");
    } else {
        System.out.println("O grafo é conexo");
    }
}

}
