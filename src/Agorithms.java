import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;


public class Agorithms {

	String stringLine;
	int countWord;
	static int countLine;
	BufferedReader BR;
	int patternLength;
	int lineLength;
	String pattern;
	String temp;
	static Hashtable<Integer,Integer> list;
	char alphabet[] = {':',';','ı',' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','y','z','w','x','q','.',',','?','!'};
	//String arr[][] = new String[20][50];
	//int arr[][]=new int[20][50];
	Hashtable<String,Integer> map = new Hashtable<String, Integer>();
	
	public void naiveAlgorithm(String pattern) throws IOException{
		//initialize
		BR = Functions.readText();
		countLine = 0;
		countWord = 0;
		list= new Hashtable();
		//start reading txt
		while((stringLine = BR.readLine()) != null){
			
			countLine++;
			lineLength = stringLine.length();
			patternLength = pattern.length();
			list.put(countLine, 0);
			//read line
			for (int S = 0; S < lineLength - patternLength ; S++) {
				
				String temp = "";
				//check pattern
				for (int k = 0; k < pattern.length(); k++) {
					
					temp = temp + stringLine.charAt(S+k);
				
				}
				//pattern eşleşirse hash line değğerini arttır
				if(pattern.equals(temp)){
					list.put(countLine , list.get(countLine)+1);
				}
				else{}
				
			}
			
		}
		
		BR.close();
		//yazdır
			/*for(int t=1; t < countLine;t++){
				System.out.println("Line : "+t+"\t"+"Matched :"+list.get(t));
			}*/
	}
	
	public void finiteAutomata(String pattern) throws IOException{
		System.out.println("finite start");
		//initialize
		BR = Functions.readText();
		countLine = 0;
		countWord = 0;
		list= new Hashtable();
		int q ;
		this.pattern=pattern;
		//start reading txt
		while((stringLine = BR.readLine().toLowerCase()) != null){
			
			countLine++;
			lineLength = stringLine.length();
			patternLength = pattern.length();
			list.put(countLine, 0);
			q = 0;
			/*
			for(int t=0;t<countLine+1;t++){
				list.put(countLine, 0);
			}*/
			
			//satırdakı harflerı tara
				for(int i=1;i<lineLength;i++){
					//q = CTF(q,stringLine.charAt(i));
					//System.out.println(stringLine.charAt(i));
					q = map.get(q+""+stringLine.charAt(i));
					//esıtse ekle
					if(q == patternLength){
						list.put(countLine, list.get(countLine)+1);
					}
				}
			
				//System.out.println(list);
				System.out.println(countLine+"-"+list.get(countLine));
		}
		System.out.println(list);
	}
	//pattern map olusur
	public void CTF(String patt) throws IOException{
		
		
		pattern=patt;
		patternLength=pattern.length();
		
		int k;
		String str_q="";
		System.out.println("giriş");
		//patternlength+1 state
		for(int q = 0;q <= patternLength;q++){
			System.out.println(q);
			//gidebilecegı tum alfabeler hangi state e gıder goster
			for(char a : alphabet){
				System.out.println(a);
				k = Math.min(patternLength+1,q+2);
				String str_k = "" ;
				
				str_k = pattern.substring(0,k-1);
				str_q = pattern.substring(0,q)+a;
				System.out.println(a+"iki");
				//kapsayana kadar ara
				while(!str_k.contains(str_q) && k!=1){
					System.out.println(str_k+"-"+str_q);
					k = k - 1 ;
					str_k = pattern.substring(0,k-1);
				}
				
				System.out.println("after while");
				map.put(q+""+a,k-1);
				//arr[q][a]=k;
				System.out.println(map.get(q+""+a));
			}
		}
	System.out.println(map);
	//finiteAutomata(pattern);
	
	}
	
	
	public Agorithms(){// throws IOException{
		//naiveAlgorithm("ab");
		//finiteAutomata("ab");
		
	}
}
