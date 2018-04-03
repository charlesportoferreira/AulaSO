import java.util.concurrent.CountDownLatch;

  public class Worker implements Runnable{

  public double dados[][];
  public int inicio;
  public int fim;
  public CountDownLatch contador;

  public Worker(double dados[][], int inicio, int fim, CountDownLatch contador){
    this.dados = dados;
    this.inicio = inicio;
    this.fim = fim;
    this.contador = contador;
  }

  public void run(){
   for(int i = inicio; i < fim; i++)
     for(int j = 0; j < dados[0].length; j++)            
        dados[i][j] = Math.pow(i+j, 5);          
 
   contador.countDown();
  }

}
