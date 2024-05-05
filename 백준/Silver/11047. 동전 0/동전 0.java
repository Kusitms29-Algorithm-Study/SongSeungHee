import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	
		int result = 0;
		int nameun = K;
		while(true) {
			int max =0;
			for(int i=0; i<N; i++) {
				if(arr[i] <= nameun) {
					if(max < arr[i]) {
						max = arr[i];
					}
				}
 			}
			result += nameun/max;
			nameun = nameun%max;
			if(nameun==0) break;
		}
		System.out.println(result);
	}
 
}
 	 