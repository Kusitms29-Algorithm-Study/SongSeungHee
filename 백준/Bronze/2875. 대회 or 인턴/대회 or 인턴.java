import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int team=0;
		int total = N+M;
		while(true) {
			if(total == K) break;
			N -=2;
			M-=1;
			total = N+M;
			if(total < K || N<0|| M<0) {
				break;
			}
			else {
				team++;
			}
		}
		System.out.println(team);
	}
 
}