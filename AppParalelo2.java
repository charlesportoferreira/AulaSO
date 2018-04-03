public class AppParalelo2{

	public static void main(String args[]){

	 double [][]dados = new double[10000][10000];
   Worker2 w1 = new Worker2(dados, 0, 5000);
   Worker2 w2 = new Worker2(dados, 5000, dados.length);
   Thread t1 = new Thread(w1);
   Thread t2 = new Thread(w2);

   t1.start();
   t2.start();
	 
    try{
      t1.join();
      t2.join();
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

