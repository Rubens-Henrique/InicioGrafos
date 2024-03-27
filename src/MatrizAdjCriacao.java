public class MatrizAdjCriacao {
    


//criando matriz
    public void CriarMatriz(int numeroVertice) {

    int vertice=numeroVertice;
    int [][] matrizadj=new int[vertice][vertice];

    //Cria matriz
    for (int i=0;i<numeroVertice;i++)
    { for (int j=0;j<numeroVertice;j++)
        {   
            matrizadj[i][j]=0;
        }
    
    }
    }

//Imprime a matriz 
public void Imprime(int numeroVertice,String nomes[],int matrizadj[][]) {
    System.out.print("      ");
    for (String nome : nomes) {
        System.out.printf("%-7s", nome);
    }

for (int i = 0; i < numeroVertice; i++) {
    System.out.printf("%-7s", nomes[i]);
    for (int j = 0; j < numeroVertice; j++) {
        System.out.printf("%-7d", matrizadj[i][j]);
    }
    System.out.println();

}






    
}
}
