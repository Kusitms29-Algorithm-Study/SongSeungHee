import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] visited;
    static int n; //열
    static int m; //행
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                visited[i][j] = -1;
            }
        }
        bfs(0,0,maps);
        return visited[m-1][n-1];
    }
    
    static void bfs(int x, int y,int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y] = 1;
        while(!q.isEmpty()) {
            int now[] = q.poll();
            for(int i=0; i<4; i++) {
                int newx = now[0] + dx[i];
                int newy = now[1] + dy[i];
                if(newx>=0 && newx<m && newy>=0 && newy<n) {
                    if(maps[newx][newy] == 1 && visited[newx][newy] == -1) {
                        visited[newx][newy] = 1 + visited[now[0]][now[1]];
                        q.offer(new int[] {newx,newy});
                    }
                }
            }
        }
    }
}