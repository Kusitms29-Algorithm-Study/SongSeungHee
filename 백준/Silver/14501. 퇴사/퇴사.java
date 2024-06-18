import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		int[] dp = new int[N+1];
		for(int i=0; i<N; i++) {
			if(i+list.get(i)[0] <= N) {
				//초과되지 않으면 
				dp[i+list.get(i)[0]] = Math.max(dp[i+list.get(i)[0]], dp[i] + list.get(i)[1]);
			}
			// 만약 종료 날짜에 즉시 상담을 시작하지 않고 그날 건너뛴경우 고려하기 위해 전날 값을 누적해서 저시킨다 
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		int max = 0;
		for(int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}	
}