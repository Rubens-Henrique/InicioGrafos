import java.util.ArrayList;
import java.util.List;

public class ListaAdjacencia {

    private List<List<Integer>> listaAdj; // Lista de adjacência para grafos não direcionados
    // Para grafos direcionados
    private List<List<Integer>> predecessores;
    private List<List<Integer>> sucessores;

    private int numVertices;
    private boolean ehDirecionado;

    public ListaAdjacencia(int numVertices, int tipo) {
        this.numVertices = numVertices;
        // Define se o grafo é direcionado ou não baseado no tipo fornecido
        this.ehDirecionado = (tipo == 1);
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

    public void addArestaLista(int v1, int v2, int tipo) {
        
        this.ehDirecionado = (tipo == 1);
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
    }

    public void removerArestaLista(int v1, int v2) {
    
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
    }

    public int obterNumVertices() {
        return numVertices;
    }

    public boolean ehDirecionado() {
        return ehDirecionado;
    }

    public List<Integer> obterVizinhos(int v) {
    // Como o grafo não é direcionado, retorna a lista de adjacência do vértice
        return listaAdj.get(v);
        
    }

    public List<Integer> obterPredecessores(int v) {
        return predecessores.get(v);
    }

    public List<Integer> obterSucessores(int v) {
        return sucessores.get(v);
    }

    public int obterGrauVertice(int v) {
        if (ehDirecionado) {
            return predecessores.get(v).size() + sucessores.get(v).size();
        } else {
            return listaAdj.get(v).size();
        }
    }

    public boolean Regular() {
        int grau = obterGrauVertice(0);
        for (int i = 1; i < numVertices; i++) {
            if (obterGrauVertice(i) != grau) {
                return false;
            }
        }
        return true;
    }




}
