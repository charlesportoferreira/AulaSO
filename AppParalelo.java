import java.util.concurrent.CountDownLatch;

public class AppParalelo{

	public static void main(String args[]){
    CountDownLatch contador = new CountDownLatch(2);

	  double [][]dados = new double[10000][10000];
    Worker w1 = new Worker(dados, 0, 5000, contador);
    Worker w2 = new Worker(dados, 5000, dados.length, contador);
    Thread t1 = new Thread(w1);
    Thread t2 = new Thread(w2);

    t1.start();
    t2.start();
	 
   try{
    contador.await();
   }catch(Exception ex){
    System.out.println("Algo errado ocorreu");
   }

    double soma = 0;
    for(int i = 0; i < dados.length; i++)
      for(int j = 0; j < dados[0].length; j++)
        soma+= dados[i][j];
  
    System.out.println(soma);
  }
}

