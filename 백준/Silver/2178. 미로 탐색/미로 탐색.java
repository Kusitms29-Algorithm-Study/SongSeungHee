import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][M+1];
		visit = new int[N+1][M+1];
		//그래프 초기화 완료 
		for(int i=1; i<=N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				graph[i][j] = line[j-1] - '0';
				
			}
		}
		
		bfs(1,1);
		System.out.println(visit[N][M]);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y}); //? 
		visit[x][y] =1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int ny = now[1];
			for(int i=0; i<4; i++) {
				int nextx = nx + dx[i];
				int nexty = ny + dy[i];
				if(nextx <1 || nextx>=N+1 || nexty<1 || nexty>=M+1) continue;
				if(graph[nextx][nexty]==0) continue;
				if(visit[nextx][nexty] ==0 && graph[nextx][nexty]==1) {
					q.offer(new int[] {nextx, nexty});
					visit[nextx][nexty] = visit[nx][ny] + 1;
				}
				
			}
			
		}
	}
	
	
}