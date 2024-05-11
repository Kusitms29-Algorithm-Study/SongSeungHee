import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int N;
	static int S;
	static int cnt=0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		StringTokenizer sr = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(sr.nextToken());
		}
		backTracking(0,0);
		if(S==0) {
			System.out.println(cnt-1);
		} else {
			System.out.println(cnt);
		}
		
	}
	
	static void backTracking(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				cnt++;
			}
			return;
		}
		backTracking(depth+1, sum+arr[depth]);
		backTracking(depth+1, sum);
	}
	
 
}