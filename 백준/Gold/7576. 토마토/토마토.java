import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] visited;
	static int[][] graph;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int result = -2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); //6 
		int m = Integer.parseInt(st.nextToken()); //4 
		visited = new int[m][n];
		graph = new int[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == -1) {
					visited[i][j] = -1;
				}
				if(graph[i][j] == 1) {
					visited[i][j] = -2;
				}
			}
		}
		bfs(m,n);
		if(check(m,n,visited)) {
			//애초에 모두 익은 상태이다 
			System.out.println(0);
		} else {//모두 익은 상태는 아니엇음 
			if(isAll(m,n,visited) == false) {
				System.out.println(-1);
			} else {
				System.out.println(count(m,n,visited)-1);
			}
			
		}
		
		
		
	}
	
	static void bfs(int m, int n) {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(graph[i][j] == 1) {
					q.offer(new int[] {i,j}); //3,5 
					visited[i][j] = 1;
				}
			}
		}

		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<4; i++ ) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx >=0 && nx <m && ny >=0 && ny<n) {
					if(graph[nx][ny] != -1 && graph[nx][ny] != 1 && visited[nx][ny]==0 && visited[nx][ny]!=-1 && visited[nx][ny]!=-2) {
						q.offer(new int[] {nx,ny});
						visited[nx][ny] = visited[now[0]][now[1]] + 1;
					}
				}
			}
		}
	}
	static boolean check(int m, int n, int[][] visited) {
		int cnt=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(graph[i][j] == -1 || graph[i][j] == 1) {
					cnt++;
				}
			}
		}
		if(cnt == m*n) {
			//애초에 모두 익은 상태이다 
			return true;
		} return false;
	}
	
	static boolean isAll(int m, int n, int[][] visited) {
		//모두 익었는가를 체크하기 위함 
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == 0) {
					//모두 익지는 않음 
					return false;
				}
			}
		}
		return true;
	}
	static int count(int m, int n, int[][] visited) {
		int max =0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, visited[i][j]);
			}
		}
		return max;
	}
	
	
}
