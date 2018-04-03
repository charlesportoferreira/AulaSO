public class Worker2 implements Runnable{

  public double dados[][];
  public int inicio;
  public int fim;

  public Worker2(double dados[][], int inicio, int fim){
    this.dados = dados;
    this.inicio = inicio;
    this.fim = fim;
  }

  public void run(){
   for(int i = inicio; i < fim; i++)
     for(int j = 0; j < dados[0].length; j++)         
        dados[i][j] = Math.pow(i+j, 5);                                                                               
  }

}
