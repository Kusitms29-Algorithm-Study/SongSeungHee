import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
	static int[][] graph;
	static boolean[] visited; 
	static int cnt=0;
	static int M,N;
 	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		N = Integer.parseInt(st.nextToken());
 		M = Integer.parseInt(st.nextToken());
 		graph = new int[N+1][N+1];
 		visited = new boolean[N+1];
 		for(int i=0; i<M; i++) {
 			StringTokenizer sr = new StringTokenizer(br.readLine(), " ");
 			int x = Integer.parseInt(sr.nextToken());
 			int y = Integer.parseInt(sr.nextToken());
 			//인접 행렬을 만들어줌 
 			graph[x][y] = 1;
 			//무방향이므로 역방향을 만드는간선도 추가한다 
 			graph[y][x] = 1;
 		}
 		
 		for(int i=1; i<=N; i++) {
 			if(!visited[i]) {
 				bfs(i);
 				cnt++;
 			}
 		}
 		
 		System.out.println(cnt);
	}	
 	
 	static void bfs(int node) {
 		Queue<Integer> q = new LinkedList<>();
 		q.offer(node);
 		visited[node] = true;
 		while(!q.isEmpty()) {
 			int cur = q.poll();
 			for(int i=1; i<=N; i++) {
 				if(graph[cur][i] == 1 && !visited[i]) {
 					visited[i] = true;
 					q.offer(i);
 				}
 			}
 		}
 	}
 
 	}
 	