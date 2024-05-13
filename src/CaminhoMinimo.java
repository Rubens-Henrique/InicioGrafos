import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CaminhoMinimo {

    public static void dijkstra(int origem, int destino) {
        // Inicialização das estruturas necessárias para o algoritmo
        int numVertices = ListaAdjacencia.obterNumVertices();
        int[] distancia = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        int[] anterior = new int[numVertices];
        PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>(numVertices, Comparator.comparingInt(o -> distancia[o]));
    
        // Inicializa todas as distâncias como infinito e o vértice anterior como -1 (não definido)
        for (int i = 0; i < numVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
            anterior[i] = -1;
        }
    
        // Define a distância da origem para ela mesma como 0
        distancia[origem] = 0;
    
        // Adiciona a origem à fila de prioridade
        filaPrioridade.add(origem);
    
        // Loop principal do algoritmo
        while (!filaPrioridade.isEmpty()) {
            int u = filaPrioridade.poll();
            visitado[u] = true;
    
            // Se o destino foi alcançado, interrompe o algoritmo
            if (u == destino) {
                break;
            }
    
            // Itera sobre os vizinhos do vértice atual
            List<Integer> vizinhos;
            if (!ListaAdjacencia.ehDirecionado()) {
                vizinhos = ListaAdjacencia.obterVizinhos(u);
            } else {
                vizinhos = ListaAdjacencia.obterSucessores(u);
            }
            for (int v : vizinhos) {
                if (!visitado[v]) {
                    int peso = ListaAdjacencia.obterPesoAresta(u, v); // Obtém o peso da aresta de u para v
    
                    // Relaxamento da aresta
                    if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                        distancia[v] = distancia[u] + peso;
                        anterior[v] = u;
                        filaPrioridade.add(v);
                    }
                }
            }
        }
    
        // Após a execução do algoritmo, podemos recuperar o caminho mínimo até o destino
        // através do vetor 'anterior'
        if (anterior[destino] == -1) {
            System.out.println("Não existe caminho entre " + (origem+1) + " e " + (destino+1));
        } else {
            List<Integer> caminho = new ArrayList<>();
            int atual = destino;
            while (atual != -1) {
                caminho.add(atual);
                atual = anterior[atual];
            }
            Collections.reverse(caminho);
            System.out.println("Caminho mínimo de " + (origem+1) + " para " + (destino+1) + ": " + ListaAdjacencia.valoresReaisVertices(caminho));
        
            System.out.println();
        }
    }
    
    
}
