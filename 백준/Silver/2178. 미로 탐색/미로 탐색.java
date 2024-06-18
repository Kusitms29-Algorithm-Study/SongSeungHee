import java.io.*;
import java.util.*;
import java.math.*;

public class Main { 
	static int[][] graph;
	static int[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		//graph완성 
		for(int i=1; i<N+1; i++) {
			char[] line = br.readLine().toCharArray();
 			for(int j=1; j<M+1; j++) {
				graph[i][j] = line[j-1] - '0';
			}
		}
		bfs(1,1);
		System.out.println(visited[N][M]);
		
	}
	
	static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {a,b});
		visited[a][b] = 1;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			for(int i=0; i<4; i++) {
				int nextx = now[0] + dx[i];
				int nexty = now[1] + dy[i];
				if(nextx >=1 && nextx <= N && nexty >=1 && nexty <= M) {
					if(graph[nextx][nexty] == 1 && visited[nextx][nexty] ==0) {
						queue.offer(new int[] {nextx, nexty});
						visited[nextx][nexty]= 1 + visited[now[0]][now[1]];
					}
				}
			}
		}
	}
	
	
	
 
}