import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
	static int N,M,V;
	static int graph[][];
	static boolean visited[];
 	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		N = Integer.parseInt(st.nextToken());
 		M = Integer.parseInt(st.nextToken());
 		V = Integer.parseInt(st.nextToken());
 		graph = new int[N+1][N+1];
 		visited = new boolean[N+1];
 		for(int i =0; i<M; i++) {
			StringTokenizer sr = new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(sr.nextToken());
			int dst = Integer.parseInt(sr.nextToken());
			graph[src][dst] = 1;
			graph[dst][src] = 1;
		}
 		dfs(V);
 		System.out.println();
 		visited = new boolean[N+1];
 		bfs(V);
	}	
 	
 	static void dfs(int node) {
 		visited[node] = true;
 		System.out.print(node + " ");
 		for(int i=1; i<=N; i++) {
 			if(graph[node][i] == 1 && !visited[i]) {
 				dfs(i);
 			}
 		}
 	}
 	
 	static Queue<Integer> q;
 	static void bfs(int node) {
 		q = new LinkedList<>();
 		q.add(node);
 		visited[node] = true;
 		while(!q.isEmpty()) {
 			int now = q.poll();
 			System.out.print(now + " ");
 			for(int i=1; i<=N; i++) {
 				if(graph[now][i] == 1 && !visited[i]) {
 					q.offer(i);
 					visited[i] = true;
 				}
 			}
 		}
 	}
 	
 	 	
}