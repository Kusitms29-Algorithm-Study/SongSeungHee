import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcnt = Integer.parseInt(br.readLine());
		while(testcnt-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); //문서의 개수 
			int m = Integer.parseInt(st.nextToken()); //궁금한 문서가 몇번째 놓이는지 
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			int cnt = 0;
			while(true) {
				int max = 0;
				int maxidx = 0;
				for(int i=0; i<q.size(); i++) {
					if(max < q.get(i)[1]) {
						max = q.get(i)[1];
						
					}
					
				}
				while(q.peek()[1] != max) {
					q.offer(q.poll());
				}
				//진짜 우선순위 맥스 값을 찾았으므로 빼야함 
				int index = q.poll()[0];
				cnt++;
				if(index == m) {
					System.out.println(cnt);
					break;
				}
			}
			
		}
		
	}	

}
