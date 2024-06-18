import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][][] visited;
	
	static int[] dz = {1,-1,0,0,0,0};
	static int[] dx = {0,0,0,0,-1,1};
	static int[] dy = {0,0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String start = br.readLine();
			if(start == null||start.isEmpty()) {
				//무시하겠다 
				continue;
			}
			else {
				StringTokenizer st = new StringTokenizer(start, " ");
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				if(L==0 && R == 0 && C ==0) break;
				visited = new int[L][R][C];
				char[][][] graph = new char[L][R][C];
				
				for(int i=0; i<L; i++) {
					for(int j=0; j<R; j++) {
						String line = br.readLine();
						for(int k=0; k<C; k++) {
							graph[i][j][k] = line.charAt(k);
						}
					}
					br.readLine();
				}
				
				int startz = 0;
				int endz = 0;
				int startx = 0;
				int starty = 0;
				int endx = 0;
				int endy = 0;
				for(int k=0; k<L; k++) {
					for(int i=0; i<R; i++) {
						for(int j=0; j<C; j++) {
							if(graph[k][i][j] == 'S') {
								startz = k;
								startx = i;
								starty = j;
								
							}
							if(graph[k][i][j] == 'E') {
								endz = k;
								endx = i;
								endy = j;
							}
						}
					}
				}
				
			
				bfs(startz,startx, starty,endz, endx, endy, graph,L,R,C);
				
				if(visited[endz][endx][endy] != 0) {
					System.out.println("Escaped in " + visited[endz][endx][endy] + " minute(s).");
				} else {
					System.out.println("Trapped!");
				}
				
			}
	
			
		}
		
		
	}
	static void bfs(int z, int x, int y, int ez, int ex, int ey, char[][][] graph, int L, int R, int C) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {z,x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<6; i++) {
				int nz = now[0] + dz[i];
				int nx = now[1] + dx[i];
				int ny = now[2] + dy[i];
			
				if(nx >=0 && nx < R && ny >=0 && ny < C && nz >=0 && nz < L) {
					if(graph[nz][nx][ny] != '#' && visited[nz][nx][ny]==0) {
						q.offer(new int[] {nz,nx,ny});
						visited[nz][nx][ny] = visited[now[0]][now[1]][now[2]]+1;
						
					}
				}
				
			}
		}
		
	}
	
}