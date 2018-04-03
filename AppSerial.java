public class AppSerial{

  public static void main(String args[]){

    double [][]dados = new double[10000][10000];

    for(int i = 0; i < dados.length; i++)
      for(int j = 0; j < dados[0].length; j++)
        dados[i][j] = Math.pow(i+j, 5); 
	 
    double soma = 0;
    for(int i = 0; i < dados.length; i++)
      for(int j = 0; j < dados[0].length; j++)
        soma+= dados[i][j];
  
    System.out.println(soma);
  }
}

