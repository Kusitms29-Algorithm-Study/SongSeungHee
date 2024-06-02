import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(true) {
			int a = N%B;
			N/=B;
			if(a<10) {
				sb.append(a);
			} else {
				sb.append((char)('A' + a-10));
			}
			if(N==0) break;
		}
		sb.reverse();
		System.out.println(sb);
		
	}

 
}