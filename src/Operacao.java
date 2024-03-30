public class Operacao {
    


    // Testar se o grafo é simples,
    public static boolean grafosimples(int[][] matrizadj) 
    {
        int numeroVertice = matrizadj.length;
        for (int i=0;i<numeroVertice ;i++)
        {   for (int j=0;j<numeroVertice ;j++)
            if (matrizadj[i][j]>1 || (i==j && matrizadj[i][i]==1))
                {  return false; } 
        } 
    
        return true; // Grafo é simples

    }

    //testar se o grafo é regular


    //testar se o grafo é completo

    public static boolean grafoCompleto(int[][] matrizadj,int verifgrafosimples) 
    {   
        if (verifgrafosimples==1){
            for (int i = 0; i < matrizadj.length; i++) {
                for (int j = 0; j < matrizadj[i].length; j++) {
                    if (i != j && matrizadj[i][j] != 1) {
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


