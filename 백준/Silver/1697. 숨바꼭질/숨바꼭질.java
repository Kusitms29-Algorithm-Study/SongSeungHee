import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
	static int N,K;
	static int[] arr;
	static int[] visited;
	static int cnt=0;
 	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		N = Integer.parseInt(st.nextToken());
 		K = Integer.parseInt(st.nextToken());
 		arr = new int[100001];
 		visited = new int[100001];
 		bfs(N);
 		
 		
 		System.out.println(visited[K]-1);
	}	
 	
 	static void bfs(int node) {
 		Queue<Integer> q = new LinkedList<>();
 		q.add(node);
 		visited[node] = 1;
 		
 		while(!q.isEmpty()) {
 			cnt++;
 			int now = q.poll();
 			
 			if(now == K) break;
 			int[] next = {now-1, now+1, now*2};
 			
 			for(int i=0; i<3; i++) {
 				//이  탐색은 수행하지 않는다 
 				if(!isRange(next[i])) continue;
 				if(visited[next[i]] ==0) {
 					q.offer(next[i]);
 					
 					visited[next[i]] = visited[now]+1;
 				}
 			}
 				
 			}
 		
 		}
 	static boolean isRange(int x) {
 		return x>=0 && x <= 100000;
 	}
 	}
 	