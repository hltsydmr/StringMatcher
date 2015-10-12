import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


public class Functions {
	
	
	public static BufferedReader readText() throws FileNotFoundException{
		
		FileInputStream fStream = new FileInputStream("text.txt");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(fStream));
		
		return bReader;
	}
	
}
