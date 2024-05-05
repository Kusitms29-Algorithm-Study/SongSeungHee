import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
	
		int[][] time = new int[N][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());	// 시작시간 
			time[i][1] = Integer.parseInt(st.nextToken());	// 종료시간 
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				//종료시간이 같은 원소가 있을 경우 시작시간을 기준으로 오름차순 정렬한
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				//종료시간을 기준으로 오름차순 정렬하
				return o1[1] - o2[1];
			}
 
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
 
}