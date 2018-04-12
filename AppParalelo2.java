import java.util.List;
import java.util.ArrayList;

public class AppParalelo2{

  public static void main(String args[]){
    int numColumns = 10000;
    int numCPUs = Integer.parseInt(args[0]);
    double [][]dados = new double[numColumns][numColumns];
    int chunk = numColumns/numCPUs;  

    int start = 0;
    int end = chunk;
    List<Thread> threads = new ArrayList<>();

    for(int i = 0; i < numCPUs; i++){
      threads.add(new Thread(new Worker2(dados,start,end)));
      threads.get(i).start();
      start = end;
      end += chunk;
    }

    try{
      for(Thread t: threads){
        t.join();
      }
    }catch(Exception ex){
      System.out.println("Bad code...");
    }

    // checking the values with a simple sum
    double soma = 0;
    for(int i = 0; i < dados.length; i++)
      for(int j = 0; j < dados[0].length; j++)
        soma+= dados[i][j];

    System.out.println(soma);
  }
}

