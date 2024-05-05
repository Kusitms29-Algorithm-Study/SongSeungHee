import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String n = br.readLine();
		StringTokenizer st = new StringTokenizer(n, " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//오름차순 정렬
		Arrays.sort(arr);
		//앞에 곱해지는 부분
		int[] multiple = new int[N];
		for(int i=0; i<N; i++) {
			multiple[i] = N-i;
		}
		int sum = 0;
	
		for(int i=0; i<N; i++) {
			sum += multiple[i] * arr[i];
		}
		System.out.println(sum);
	}

	
	
}