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


    //testar se o grafo é completo

    public static boolean grafoCompleto(int[][] matrizAdj+"RETORNO DO GRAFO SIMPLES") 
    {   
        if (grafosimples=true){
            for (int i = 0; i < matrizAdj.length; i++) {
                for (int j = 0; j < matrizAdj[i].length; j++) {
                    if (i != j && matrizAdj[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
        } else {
            return false; // Se o grafo não for simples, não pode ser completo
        }
    }



    //testar se é bipartido 
    //sera que da pra comitar 
}


