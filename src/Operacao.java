public class Operacao {
    


    // Testar se o grafo é simples,
public static boolean grafosimples(int[][] matrizAdj) 
   
{


    int numeroVertice = matrizAdj.length;
    for (int i=0;i<numeroVertice ;i++)
    {   for (int j=0;j<numeroVertice ;j++)
             if (matrizAdj[i][j]>1 || (i==j && matrizAdj[i][i]==1))
                  {  return false; } 
    } 
    
    return true; // Grafo é simples

    }

    //testar se o grafo é regular
    public static boolean grafoRegular(int[][] matrizAdj) 
{ 





}

    //testar se o grafo é completo





    //testar se é bipartido 
    




}
