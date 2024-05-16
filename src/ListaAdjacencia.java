import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ListaAdjacencia {

    private static List<List<Integer>> listaAdj; // Lista de adjacência para grafos não direcionados
    // Para grafos direcionados
    private static List<List<Integer>> predecessores;
    private static List<List<Integer>> sucessores;

    private static int numVertices;
    private static boolean ehDirecionado;

    public ListaAdjacencia(int numVertices, int tipo) {
        this.numVertices = numVertices;
        // Define se o grafo é direcionado ou não baseado no tipo fornecido
        ehDirecionado = (tipo == 1);
        predecessores = new ArrayList<>();
        sucessores = new ArrayList<>();
        // Inicializa listas de adjacência se o grafo for não direcionado
        if (!ehDirecionado) {
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                listaAdj.add(new ArrayList<>());
            }
        }
        // Inicializa listas de predecessores e sucessores
        else{
            for (int i = 0; i < numVertices; i++) {
                predecessores.add(new ArrayList<>());
                sucessores.add(new ArrayList<>());
            }
        }
    }

    public static void addArestaLista(int v1, int v2, int peso) {

        Aresta novaAresta = new Aresta(v1, v2, peso);
        
        // Se o grafo não for direcionado, adiciona também nas listas de adjacência dos vértices
        if (!ehDirecionado) {
            listaAdj.get(v1).add(v2);
            listaAdj.get(v2).add(v1);
        }
        // Adiciona v2 como sucessor de v1 e v1 como predecessor de v2
        else {
            sucessores.get(v1).add(v2);
            predecessores.get(v2).add(v1);
        }
        // Adiciona a nova aresta à lista de arestas da classe Aresta
        Aresta.adicionarAresta(novaAresta);
    }

    public static void removerArestaLista(int v1, int v2) {

        Aresta arestaRemovida = new Aresta(v1, v2);
    
        // Se o grafo não for direcionado, remove também das listas de adjacência dos vértices
        if (!ehDirecionado) {
            listaAdj.get(v1).remove((Integer) v2);
            listaAdj.get(v2).remove((Integer) v1);
        }
        // Remove v2 da lista de sucessores de v1 e v1 da lista de predecessores de v2
        else {
            sucessores.get(v1).remove((Integer) v2);
            predecessores.get(v2).remove((Integer) v1);
        }

        // Remove a aresta da lista de arestas da classe Aresta
        Aresta.removerAresta(arestaRemovida);
    }

    public static int obterNumVertices() {
        return numVertices;
    }

    public static boolean ehDirecionado() {
        return ehDirecionado;
    }

    public static List<Integer> obterVizinhosReais(int v) {
        // Verifica se o grafo é direcionado
        if (ehDirecionado) {
            System.out.println("O grafo é direcionado.");
            return null; // Retorna null pois o grafo é direcionado
        }
        
        // Como o grafo não é direcionado, retorna a lista de adjacência do vértice
        // Obter os valores reais dos vértices, pois a lista começa da posição 0
        List<Integer> verticesReais = valoresReaisVertices(listaAdj.get(v));
    
        // Retorna a lista de vizinhos com os valores reais dos vértices
        return verticesReais;
    }

    public static List<Integer> obterPredecessoresReais(int v) {
        // Verifica se o grafo é direcionado
        if (!ehDirecionado) {
            return null; // Retorna null pois o grafo é não direcionado
        }
        
        List<Integer> verticesReais = valoresReaisVertices(predecessores.get(v));
    
        // Retorna a lista de vizinhos com os valores reais dos vértices
        return verticesReais;
    }

    public static List<Integer> obterSucessoresReais(int v) {
        // Verifica se o grafo é direcionado
        if (!ehDirecionado) {
            System.out.println("O grafo é não direcionado.");
            return null; // Retorna null pois o grafo é não direcionado
        }
        
        List<Integer> verticesReais = valoresReaisVertices(sucessores.get(v));
        return verticesReais;
    }

    public static int obterGrauVertice(int v) {
        if (ehDirecionado) {
            return predecessores.get(v).size() + sucessores.get(v).size();
        } else {
            return listaAdj.get(v).size();
        }
    }

    public static boolean regular() {
        int grau = obterGrauVertice(0);
        for (int i = 1; i < numVertices; i++) {
            if (obterGrauVertice(i) != grau) {
                return false;
            }
        }
        return true;
    }

  
    public static boolean ehBipartido() {
      

        int[] coloracao = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            coloracao[i] = -1;
            visitado[i] = false;
        }

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                if (!verificarBipartidoUtil(i, coloracao, visitado)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean verificarBipartidoUtil(int vertice, int[] coloracao, boolean[] visitado) {
        Queue<Integer> fila = new LinkedList<>();
        fila.offer(vertice);
        visitado[vertice] = true;
        coloracao[vertice] = 1;

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            List<Integer> vizinhos = obterVizinhos(atual);

            for (int vizinho : vizinhos) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    coloracao[vizinho] = 1 - coloracao[atual];
                    fila.offer(vizinho);
                } else if (coloracao[vizinho] == coloracao[atual]) {
                    // Se já visitado e possui a mesma cor que o vértice atual, então não é bipartido
                    return false;
                }
                // Verifica se o vizinho já foi visitado e se a sua cor é igual à cor do vértice atual
                else if (visitado[vizinho] && coloracao[vizinho] == coloracao[atual]) {
                    // Se sim, então há um ciclo, e o grafo não pode ser bipartido
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> obterSucessores(int v) {
        return sucessores.get(v);
    }

    public static List<Integer> obterPredecessores(int v) {
        return predecessores.get(v);
    }

    public static List<Integer> obterVizinhos(int v) {
        return listaAdj.get(v);
    }

    public static List<Integer> valoresReaisVertices(List<Integer> vertices) {
        List<Integer> verticesReais = new ArrayList<>();
        for (int v : vertices) {
            verticesReais.add(v + 1); // Adiciona 1 ao valor do vértice
        }
        return verticesReais;
    }

    public static void buscaProfundidade(int vertice) {
        boolean[] visitados = new boolean[ListaAdjacencia.obterNumVertices()];
        if (ListaAdjacencia.ehDirecionado()) {
            buscaProfundidadeDirecionado(vertice, visitados);
        } else {
            buscaProfundidadeRecursiva(vertice, visitados);
        }
    }

    private static void buscaProfundidadeRecursiva(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        System.out.print((vertice + 1) + " "); // Imprime o vértice visitado
        
        List<Integer> vizinhos = ListaAdjacencia.obterVizinhos(vertice);
        for (int vizinho : vizinhos) {
            if (!visitados[vizinho]) {
                buscaProfundidadeRecursiva(vizinho, visitados);
            }
        }
    }

    private static void buscaProfundidadeDirecionado(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
    
        System.out.print((vertice + 1) + " "); // Imprime o vértice visitado
        
        List<Integer> sucessores = obterSucessores(vertice);
        for (int sucessor : sucessores) {
            //System.out.println(sucessor);
            if (!visitados[sucessor]) {
                buscaProfundidadeDirecionado(sucessor, visitados);
            }
        }
    
    }

    // Algoritmo de Prim para encontrar a Árvore Geradora Mínima (AGM)
    public static void primAlgoritmo() {
        boolean[] visitado = new boolean[numVertices];
        int[] pai = new int[numVertices];
        int[] chave = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            chave[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }
        chave[0] = 0;
        pai[0] = -1;

        PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>();
        filaPrioridade.add(0);

        while (!filaPrioridade.isEmpty()) {
            int u = filaPrioridade.poll();
            visitado[u] = true;

            List<Integer> vizinhos = new ArrayList<>();
            if (!ehDirecionado) {
                vizinhos.addAll(listaAdj.get(u));
            } else {
                vizinhos.addAll(sucessores.get(u));
            }
            for (int v : vizinhos) {
                int peso = obterPesoAresta(u, v);
                if (!visitado[v] && peso < chave[v]) {
                    pai[v] = u;
                    chave[v] = peso;
                    filaPrioridade.add(v);
                }
            }
        }

        // Imprime a AGM
        System.out.println("Arestas da Árvore Geradora Mínima:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println((pai[i]+1) + " - " + (i+1));
        }
    }

    public static int obterPesoAresta(int origem, int destino) {
        if (!ehDirecionado) {
            // Grafo não direcionado
            for (Aresta aresta : Aresta.getArestas()) {
                if ((aresta.getVertice1() == origem && aresta.getVertice2() == destino) ||
                    (aresta.getVertice1() == destino && aresta.getVertice2() == origem)) {
                    return aresta.getPeso();
                }
            }
        } else {
            // Grafo direcionado
            for (Aresta aresta : Aresta.getArestas()) {
                if (aresta.getVertice1() == origem && aresta.getVertice2() == destino) {
                    return aresta.getPeso();
                }
            }
        }
        // Se não encontrar a aresta, retorna um valor que represente a ausência de conexão
        return Integer.MAX_VALUE;
    }
    


}
