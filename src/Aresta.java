import java.util.ArrayList;
import java.util.List;

public class Aresta {

    private static List<Aresta> listaArestas = new ArrayList<>();
    
    private int vertice1;
    private int vertice2;
    private int peso; // Peso da aresta, se aplicável

    public Aresta(int vertice1, int vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = 1; // Valor padrão para peso
    }

    public Aresta(int vertice1, int vertice2, int peso) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = peso;
    }

    public static void adicionarAresta(Aresta aresta) {
        listaArestas.add(aresta);
    }

    public static void removerAresta(Aresta aresta) {
        listaArestas.remove(aresta);
    }

    public int getVertice1() {
        return vertice1;
    }

    public int getVertice2() {
        return vertice2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
