public class MatrizAdjCriacao {
    
    private static int[][] matrizadj;

    // Construtor da classe para inicializar a matriz
    
    public MatrizAdjCriacao(int numeroVertice) {
        matrizadj = new int[numeroVertice][numeroVertice];
        // Inicializa a matriz com zeros
        for (int i = 0; i < numeroVertice; i++) {
            for (int j = 0; j < numeroVertice; j++) {
                matrizadj[i][j] = 0;
            }
        }
    }

    // Adiciona uma aresta à matriz de adjacência
    public static void addArestaMatriz(int origem, int destino, int tipo) {
        if (tipo == 1) {
            matrizadj[origem][destino] = 1;
            matrizadj[destino][origem] = 1; // para grafos não direcionados
        } else {
            matrizadj[origem][destino] = 1; // para grafos direcionados 
        }
    }

    // Remove uma aresta da matriz de adjacência
    public static void removerArestaMatriz(int origem, int destino, int tipo) {
        if (tipo == 1) {
            matrizadj[origem][destino] = 0;
            matrizadj[destino][origem] = 0; // para grafos não direcionados
        } else {
            matrizadj[origem][destino] = 0; // para grafos direcionados 
        }
    }

    // Imprime a matriz
    public static void imprime(int numeroVertice, String nomes[]) {
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
}
