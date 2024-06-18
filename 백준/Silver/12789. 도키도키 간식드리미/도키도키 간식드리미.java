import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q2 = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			q2.offer(Integer.parseInt(st.nextToken()));
		}
		int t = 1;
		while(!q2.isEmpty()) {			
			int m1 = q2.peek();

			if(t == m1) {
				q2.poll();
				t++;
			}
			else if(!s.isEmpty() && t==s.peek()) {
				s.pop();
				t++;
			}
			else {
				s.push(q2.poll());
			}
			
			
		}
		
		while(!s.isEmpty()) {
			int k = s.pop();
			if(t == k) {
				t+=1;
			} 
		}
		if(t==n+1) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
		
	}	

}