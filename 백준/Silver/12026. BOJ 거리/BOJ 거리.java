
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[n];
		long result = 0;
		arr = br.readLine().toCharArray();
		long[] dp = new long[n];
		for(int i=0; i<n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
				}
				else if(arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j] + (i-j)* (i-j));
				}
				else if(arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
				}
			}
		}
		if(dp[n-1] == Integer.MAX_VALUE) {
			result = -1;
		} else {
			result = dp[n-1];
		}
		System.out.println(result);
	}
	

}