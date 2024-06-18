
import java.io.*;
import java.util.*;
import java.math.*;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		
		 char[] middle = new char[N];
		 String line = br.readLine();
		 middle = line.toCharArray();
		 int max =0;
		 for(int i=0; i<N; i++) {
			 max += Character.getNumericValue(middle[i]);
		 }
		System.out.println(max);
	}
	
	
 
}