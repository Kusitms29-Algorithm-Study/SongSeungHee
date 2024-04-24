import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
	static int graph[][];
	static int cnt;
	static int M,N;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int nx,ny;
 	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		int T = Integer.parseInt(br.readLine());
 		StringBuilder sb = new StringBuilder();
 		while(T-->0) {
 			
 			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 			M = Integer.parseInt(st.nextToken());
 			N = Integer.parseInt(st.nextToken());
 			int K = Integer.parseInt(st.nextToken());
 			
 			//초기화 
 			graph = new int[M][N];
 			visited = new boolean[M][N]; 			//그래프에 값을 넣어준다 
 			for(int i=0; i<K; i++) {
 				StringTokenizer sr = new StringTokenizer(br.readLine(), " ");
 				int x = Integer.parseInt(sr.nextToken());
 				int y = Integer.parseInt(sr.nextToken());
 				graph[x][y] = 1;
 			}
 			cnt=0;
 			for(int l=0; l<M; l++) {
 				for(int r=0; r<N; r++) {
 					//그래프에서 1이 나오는 곳으로 진입한다 
 					if(graph[l][r] == 1 && !visited[l][r]) {						
 						dfs(l,r);
 						cnt++;
 					}
 				}
 			}
 			sb.append(cnt).append('\n');
 		}
 		System.out.println(sb);
 		br.close();
 		
	}	
 	
 	static void dfs(int x, int y) {
 		visited[x][y] = true;
 		
 		for(int i=0; i<4; i++) {
 			nx = x+dx[i];
 			ny = y+dy[i];
 			if(nx >= 0 && nx < M && ny>=0 && ny < N) {
 	 			if(graph[nx][ny] == 1 && !visited[nx][ny]) {
 	 	 			 
 	 	 			 dfs(nx,ny);
 	 	 		 }
 		 		}
 		}
 		
 	}
 	
 
 	}