import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		while(k!=0) {
			int max = 0;
			for(int i=n-1; i>=0; i--) {
				if(arr[i] <= k) {
					if(arr[i] > max) {
						max = arr[i];
					}
				}
			}
			
			cnt += k/max;
			k = k%max;
		}
		System.out.println(cnt);
	}

}