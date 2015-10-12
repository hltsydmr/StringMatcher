import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		
		Agorithms algo = new Agorithms();
		while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a pattern");
		String b= sc.next();
		System.out.println("Choose one algorithm:\n1. Naive String Matcher\n2. Finite Automata");
		int a=sc.nextInt();
		switch(a){
		case 1:
			long startTime = System.nanoTime();
			algo.naiveAlgorithm(b);
			long elapsedTime = System.nanoTime()-startTime;
			
			for(int t=1; t < Agorithms.countLine;t++){
				System.out.println("Line : "+t+"\t"+"Matched :"+Agorithms.list.get(t));
			}
			
			System.out.println((float)elapsedTime/1000000+" ms");
			break;
		case 2:
			long startTime_2 = System.nanoTime();
			
			//algo.t("pt", "sda weq ada fgfbggptdf df");
			try{
			algo.CTF(b);
			algo.finiteAutomata(b);
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
			long elapsedTime_2 = System.nanoTime()-startTime_2;
			System.out.println((float)elapsedTime_2/1000000+" ms");
			break;
			}
		
		}
		}
	}

}
